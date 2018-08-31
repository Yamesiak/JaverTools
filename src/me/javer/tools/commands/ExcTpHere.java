package me.javer.tools.commands;

import me.javer.tools.commands.utils.Executor;
import me.javer.tools.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExcTpHere implements Executor{
	
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			Util.sendMessage(Bukkit.getConsoleSender(), "&4Blad: &cMusisz byc na serwerze aby wykonac ta komende!");
			return;
		}
		
		if(!sender.hasPermission("javertools.cmd.tphere")){
			Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy &8(&7javertools.cmd.tphere&8)");
			return;
		}
		Player p = (Player) sender;
		if(args.length == 0){
			Util.sendMessage(p, "&8» &7Poprawne uzycie: &4/tphere &8[&4gracz&8]");
			return;
		} else {
			if(args.length == 1){
				Player other = Bukkit.getPlayer(args[0]);
				if(other == null){
					Util.sendMessage(p, "&4Blad: &cPodany gracz jest offline!");
					return;
				}
				if(other.equals(p)){
					Util.sendMessage(p, "&4Blad: &cNie mozesz teleportowac sie do samego siebe!");
					return;
				}
				other.teleport(p.getLocation());
				Util.sendMessage(other, "&8» &7Administrator: &4" + p.getName() + "&7 przeteleportowal ciebie do siebie!");
				Util.sendMessage(p, "&8» &7Pomyslnie przeteleportowales gracza: &4" + other.getName() + "&7 do siebie!");
				return;
			}
		}
	}
}

