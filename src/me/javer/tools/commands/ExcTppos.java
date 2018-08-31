package me.javer.tools.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.javer.tools.commands.utils.Executor;
import me.javer.tools.utils.Util;

public class ExcTppos implements Executor{
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			Util.sendMessage(Bukkit.getConsoleSender(), "&4Blad: &cMusisz byc na serwerze aby wykonac ta komende!");
			return;
		}
		
		if(!sender.hasPermission("javertools.cmd.tppos")){
			Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy &8(&7javertools.cmd.tppos&8)");
			return;
		}
		Player p = (Player) sender;
		if(args.length == 0){
			Util.sendMessage(p, "&8» &7Poprawne uzycie: &4/tppos &8[&4gracz&8] [&4x&8] [&4y&8] [&4z&8]");
			return;
		} else {
			if(args.length >= 4){
				@SuppressWarnings("deprecation")
				Player target = Bukkit.getPlayer(args[0]);
				if(target == null){
					Util.sendMessage(p, "&4Blad: &cPodany gracz jest offline!");
					return;
				}
				int x;
				int y;
				int z;
				try{
					x = Integer.valueOf(args[1]);
					y = Integer.valueOf(args[2]);
					z = Integer.valueOf(args[3]);
				} catch(NumberFormatException e){
					Util.sendMessage(p, "&4Blad: &cKordynaty musza byc liczba!");
					return;
				}
				target.teleport(new Location(target.getWorld(), x, y, z));
				Util.sendMessage(target, "&8» &7Pomyslnie przetelportowales gracza: &4" + target.getName() + "&7 na kordynaty: x: &4" + x + " &7y: &4" + y + " &7z: &4" + z);
				for(Player admin : Bukkit.getOnlinePlayers()){
					if(admin.hasPermission("javertools.socialspy")){
						Util.sendMessage(admin, "&eAdmin: " + p.getName() + " przeteleportowal gracza: " + target.getName() + " na kordynaty: x: " + x +" y: " + y + " z: " + z);
					}
				}
			}
		}
		
	}

}
