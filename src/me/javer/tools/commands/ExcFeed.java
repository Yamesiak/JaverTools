package me.javer.tools.commands;

import me.javer.tools.commands.utils.Executor;
import me.javer.tools.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExcFeed implements Executor{
	
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			Util.sendMessage(Bukkit.getConsoleSender(), "&4Blad: &cMusisz byc na serwerze aby wykonac ta komende!");
			return;
		}
		
		if(!sender.hasPermission("javertools.cmd.feed")){
			Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy &8(&7javertools.cmd.feed&8)");
			return;
		}
		Player p = (Player) sender;
		if(args.length == 0){
			p.setFoodLevel(20);
			Util.sendMessage(p, "&8» &7Pomyslnie zostales najedzony!");
			return;
		} else {
			if(args.length >= 1){
				Player other = Bukkit.getPlayer(args[0]);
				if(other == null){
					Util.sendMessage(p, "&4Blad: &cPodany gracz jest offline!");
					return;
				}
				if(!p.hasPermission("javertools.cmd.feed.other")){
					Util.sendMessage(p, "&cNie masz uprawnien do uzycia tej komendy &8(&7javertools.cmd.feed.other&8)");
					return;
				}
				other.setFoodLevel(20);
				Util.sendMessage(other, "&8» &7Pomyslnie zostales najedzony przez admina: &4" + p.getName() + "&7!");
				Util.sendMessage(p, "&8» &7Pomyslnie najadles gracza: &4" + other.getName());
				for(Player admin : Bukkit.getOnlinePlayers()){
					if(admin.hasPermission("javertools.socialspy")){
						Util.sendMessage(admin, "&eAdmin: " + p.getName() + " najadl gracza: " + other.getName());
					}
				}
				return;
			}
		}
	}
}