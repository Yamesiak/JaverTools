package me.javer.tools.commands;

import me.javer.tools.commands.utils.Executor;
import me.javer.tools.utils.StringUtil;
import me.javer.tools.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExcGameMode implements Executor{
	
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			Util.sendMessage(Bukkit.getConsoleSender(), "&4Blad: &cMusisz byc na serwerze aby wykonac ta komende!");
			return;
		}
		
		if(!sender.hasPermission("javertools.cmd.gamemode")){
			Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy &8(&7javertools.cmd.gamemode&8)");
			return;
		}
		
		if(args.length == 0){
			Util.sendMessage(sender, "&8» &7Poprawne uzycie: &4/gamemode &8[&40&8|&41&8|&42&8|&43&8] &8[&4gracz&8]");
			return;
		} else {
			Player p = (Player) sender;
			String[] survival = {"0", "survival"};
			String[] creative = {"1", "creative"};
			String[] adventure = {"2", "adventure"};
			String[] spectator = {"3", "spectator"};
			if(args.length == 1){
				if(StringUtil.containsIgnoreCase(survival, args[0].toLowerCase())){
					p.setGameMode(GameMode.SURVIVAL);
					Util.sendMessage(p, "&8» &7Twoj tryb gry zostal zmieniony na: &4SURVIVAL");
				}
				if(StringUtil.containsIgnoreCase(creative, args[0].toLowerCase())){
					p.setGameMode(GameMode.CREATIVE);
					Util.sendMessage(p, "&8» &7Twoj tryb gry zostal zmieniony na: &4CREATIVE");
				}
				if(StringUtil.containsIgnoreCase(adventure, args[0].toLowerCase())){
					p.setGameMode(GameMode.ADVENTURE);
					Util.sendMessage(p, "&8» &7Twoj tryb gry zostal zmieniony na: &4ADVENTURE");
				}
				if(StringUtil.containsIgnoreCase(spectator, args[0].toLowerCase())){
					p.setGameMode(GameMode.SPECTATOR);
					Util.sendMessage(p, "&8» &7Twoj tryb gry zostal zmieniony na: &4SPECTATOR");
				}
			} else {
				if(args.length == 2){
					Player other = Bukkit.getPlayer(args[1]);
					if(other == null){
						Util.sendMessage(p, "&4Blad: &cPodany gracz jest offline!");
						return;
					}
					if(!p.hasPermission("javertools.cmd.gamemode.other")){
						Util.sendMessage(p, "&cNie masz uprawnien do uzycia tej komendy &8(&7javertools.cmd.gamemode.other&8)");
						return;
					}
					
					if(StringUtil.containsIgnoreCase(survival, args[0].toLowerCase())){
						other.setGameMode(GameMode.SURVIVAL);
						Util.sendMessage(p, "&8» &7Tryb gry gracza: &4" + other.getName() + "&7 zostal zmieniony na: &4SURVIVAL");
						Util.sendMessage(other, "&8» &7Twoj tryb gry zostal zmieniony na: &4SURVIVAL &7przez administratora: &4" + p.getName());
						for(Player admin : Bukkit.getOnlinePlayers()){
							if(admin.hasPermission("javertools.socialspy")){
								Util.sendMessage(admin, "&eAdmin: " + p.getName() + " zmienil tryb gry graczowi: " + other.getName() + " na SURVIVAL");
							}
						}
					}
					if(StringUtil.containsIgnoreCase(creative, args[0].toLowerCase())){
						other.setGameMode(GameMode.CREATIVE);
						Util.sendMessage(p, "&8» &7Tryb gry gracza: &4" + other.getName() + "&7 zostal zmieniony na: &4CREATIVE");
						Util.sendMessage(other, "&8» &7Twoj tryb gry zostal zmieniony na: &4CREATIVE &7przez administratora: &4" + p.getName());
						for(Player admin : Bukkit.getOnlinePlayers()){
							if(admin.hasPermission("javertools.socialspy")){
								Util.sendMessage(admin, "&eAdmin: " + p.getName() + " zmienil tryb gry graczowi: " + other.getName() + " na CREATIVE");
							}
						}
					}
					if(StringUtil.containsIgnoreCase(adventure, args[0].toLowerCase())){
						other.setGameMode(GameMode.ADVENTURE);
						Util.sendMessage(p, "&8» &7Tryb gry gracza: &4" + other.getName() + "&7 zostal zmieniony na: &4ADVENTURE");
						Util.sendMessage(other, "&8» &7Twoj tryb gry zostal zmieniony na: &4ADVENTURE &7przez administratora: &4" + p.getName());
						for(Player admin : Bukkit.getOnlinePlayers()){
							if(admin.hasPermission("javertools.socialspy")){
								Util.sendMessage(admin, "&eAdmin: " + p.getName() + " zmienil tryb gry graczowi: " + other.getName() + " na ADVENTURE");
							}
						}
					}
					if(StringUtil.containsIgnoreCase(spectator, args[0].toLowerCase())){
						other.setGameMode(GameMode.SPECTATOR);
						Util.sendMessage(p, "&8» &7Tryb gry gracza: &4" + other.getName() + "&7 zostal zmieniony na: &4SPECTATOR");
						Util.sendMessage(other, "&8» &7Twoj tryb gry zostal zmieniony na: &4SPECTATOR &7przez administratora: &4" + p.getName());
						for(Player admin : Bukkit.getOnlinePlayers()){
							if(admin.hasPermission("javertools.socialspy")){
								Util.sendMessage(admin, "&eAdmin: " + p.getName() + " zmienil tryb gry graczowi: " + other.getName() + " na SPECTATOR");
							}
						}
					}
				}
			}
		}
	}
}