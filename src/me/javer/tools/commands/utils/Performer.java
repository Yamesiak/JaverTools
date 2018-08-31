package me.javer.tools.commands.utils;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Performer extends Command{

	private ExecutorCaller caller;
	
	protected Performer(String command){
		super(command);
	}

	public void setExecutor(ExecutorCaller caller){
		this.caller = caller;
	}
	
	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {
		if(this.caller == null) return false;
		return this.caller.onCommand(sender, this, commandLabel, args);
	}
	
	@Override
	public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
		return caller.onTabComplete(sender, this, alias, args);
	}
}
