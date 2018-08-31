package me.javer.tools.commands.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.javer.tools.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

public class ExecutorCaller implements CommandExecutor, TabExecutor{
	
	private String overriding;
	private Executor executor;
	private String permission;
	private List<String> aliases;
	private String[] secondary;
	private List<ExecutorCaller> executors = new ArrayList<ExecutorCaller>();
	private static final List<ExecutorCaller> ecs = new ArrayList<ExecutorCaller>();
	
	public ExecutorCaller(Executor executor, String command, String permission, List<String> aliases){
		if(executor == null || command == null) return;
		
		this.executor = executor;
		this.permission = permission;
		if(aliases !=null && aliases.size() > 0) this.aliases = aliases;
		else this.aliases = null;
		
		String[] splited = command.split("\\s+");
		this.overriding = splited[0];
		if(splited.length > 1){
			this.secondary = new String[splited.length - 1];
			for(int i = 1; i< splited.length; i++){
				this.secondary[i-1] = splited[i];
			}
		} else {
			this.secondary = null;
		}
		for(ExecutorCaller ec : ecs){
			if(ec.overriding.equalsIgnoreCase(this.overriding)){
				ec.executors.add(this);
				return;
			}
		}
		this.register();
		executors.add(this);
		ecs.add(this);
	}
	private boolean call(CommandSender sender, Command cmd, String[] args){
		if(!cmd.getName().equals(this.overriding)) return false;
		ExecutorCaller main = null;
		for(ExecutorCaller ec : this.executors){
			if(ec.secondary !=null){
				if(ec.secondary.length > args.length) continue;
				boolean sec = false;
				for(int i = 0; i<ec.secondary.length; i++){
					if(!ec.secondary[i].equalsIgnoreCase(args[i])){
						sec = true;
						break;
					}
				}
				if(sec) continue;
				args = Arrays.copyOfRange(args, ec.secondary.length, args.length);
			} else {
				main = ec;
				continue;
			}
			if(sender instanceof Player){
				if(ec.permission !=null && !sender.hasPermission(ec.permission)){
					Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy &8(&7" + ec.permission + "&8)");
					return true;
				}
			}
			ec.executor.execute(sender, args);
			return true;
		}
		main.executor.execute(sender, args);
		return true;
	}
	
	private void register(){
		try {
		Performer p = new Performer(this.overriding);
		if(this.aliases !=null) p.setAliases(this.aliases);
		p.setPermissionMessage("&cNie masz uprawnien do uzycia tej komendy");
		Field f = Bukkit.getServer().getClass().getDeclaredField("commandMap");
		f.setAccessible(true);
		CommandMap cmap = (CommandMap) f.get(Bukkit.getServer());
		cmap.register("", p);
		p.setExecutor(this);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return call(sender, cmd, args);
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if(this.secondary !=null) return Arrays.asList(this.secondary);
		else return null;
	}
}
