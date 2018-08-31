package me.javer.tools.commands;

import me.javer.tools.commands.utils.Executor;
import me.javer.tools.objects.User;
import me.javer.tools.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExcGod implements Executor{
	
	/*
	 * not working 100%
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			Util.sendMessage(Bukkit.getConsoleSender(), "&4Blad: &cMusisz byc na serwerze aby wykonac ta komende!");
			return;
		}
		
		if(!sender.hasPermission("javertools.cmd.god")){
			Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy &8(&7javertools.cmd.god&8)");
			return;
		}
		Player p = (Player) sender;
		User user = User.get(p);
		if(args.length == 0){
			if(user.isGod() == true){
				user.setGod(false);
				Util.sendMessage(p, "&8» &7Wylaczyles sobie goda");
				return;
			} else if(user.isGod() == false){
				user.setGod(true);
				Util.sendMessage(p, "&8» &7Wlaczyles sobie goda");
				return;
			}
		} else {
			if(args.length >= 1){
				Player other = Bukkit.getPlayer(args[0]);
				User target = User.get(other);
				if(other == null){
					Util.sendMessage(p, "&4Blad: &cPodany gracz jest offline!");
					return;
				}
				if(!p.hasPermission("javertools.cmd.god.other")){
					Util.sendMessage(p, "&cNie masz uprawnien do uzycia tej komendy &8(&7javertools.cmd.god.other&8)");
					return;
				}
				
				if(target.isGod() == true){
					target.setGod(false);
					Util.sendMessage(p, "&8» &7Wylaczyles goda graczowi: &4" + other.getName());
					Util.sendMessage(other, "&8» &7Administrator: &4" + p.getName() + " &7wylaczyl ci goda!");
					for(Player admin : Bukkit.getOnlinePlayers()){
						if(admin.hasPermission("javertools.socialspy")){
							Util.sendMessage(admin, "&eAdmin: " + p.getName() + " wylaczyl goda graczowi: " + other.getName());
						}
					}
					return;
				} else if(user.isGod() == false){
					target.setGod(true);
					Util.sendMessage(p, "&8» &7Wlaczyles goda graczowi: &4" + other.getName());
					Util.sendMessage(other, "&8» &7Administrator: &4" + p.getName() + " &7wlaczyl ci goda!");
					for(Player admin : Bukkit.getOnlinePlayers()){
						if(admin.hasPermission("javertools.socialspy")){
							Util.sendMessage(admin, "&eAdmin: " + p.getName() + " wlaczyl goda graczowi: " + other.getName());
						}
					}
					return;
				}
			}
		}
	}
}
