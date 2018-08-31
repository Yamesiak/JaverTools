package me.javer.tools.commands;

import me.javer.tools.commands.utils.Executor;
import me.javer.tools.utils.Util;

import org.bukkit.command.CommandSender;

public class ExcHelp implements Executor{
	
	@Override
	public void execute(CommandSender sender, String[] args) {		
		if(!sender.hasPermission("javertools.cmd.help")){
			Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy &8(&7javertools.cmd.help&8)");
			return;
		}
		if(args.length == 0){
			Util.sendMessage(sender, "&8» &7Pomoc pluginu: &4JaverTools&7: &8(&71/10&8)");
			if(sender.hasPermission("javertools.cmd.broadcast")) Util.sendMessage(sender, "&4/broadcast &8[&4wiadomosc&8] - &7Wysyla wiadomosc na serwer");
			if(sender.hasPermission("javertools.cmd.gamemode")) Util.sendMessage(sender, "&4/gamemode &8[&40&8|&41&8|&42&8|&43&8] &8[&4gracz&8] - &7Zmienia tryb gry");
			if(sender.hasPermission("javertools.cmd.helpop")) Util.sendMessage(sender, "&4/helpop &8[&4wiadomosc&8] - &7Kontakt z administracja");
			if(sender.hasPermission("javertools.cmd.exp")) Util.sendMessage(sender, "&4/exp &8[&4set&8|&4give&8|&4remove&8] &8[&4gracz&8] &8[&4ilosc&8] - &7Dawanie punktow expa");
			if(sender.hasPermission("javertools.cmd.heal")) Util.sendMessage(sender, "&4/heal &8([&4gracz&8]) - &7Leczenie");
			if(sender.hasPermission("javertools.cmd.feed")) Util.sendMessage(sender, "&4/feed &8([&4gracz&8]) - &7Jedzenie");
			if(sender.hasPermission("javertools.cmd.fly")) Util.sendMessage(sender, "&4/fly &8([&4gracz&8]) - &7Zmienia tryb latania");
			if(sender.hasPermission("javertools.cmd.tp")) Util.sendMessage(sender, "&4/tp &8[&4gracz&8] &8([&4gracz&8]) - &7Teleportacja gracza");
			if(sender.hasPermission("javertools.cmd.tphere")) Util.sendMessage(sender, "&4/tphere &8[&4gracz&8] - &7Teleportacja gracza do siebie");
			Util.sendMessage(sender, "&8» &7Aby przejsc na kolejna strone wpisz: &4/help 2");
		} else {
			if(args.length >= 1){
				/*
				 * Po 9 komend na strone.
				 */
				if(args[0].equalsIgnoreCase("1")){
					Util.sendMessage(sender, "&8» &7Pomoc pluginu: &4JaverTools&7: &8(&71/10&8)");
					if(sender.hasPermission("javertools.cmd.broadcast")) Util.sendMessage(sender, "&4/broadcast &8[&4wiadomosc&8] - &7Wysyla wiadomosc na serwer");
					if(sender.hasPermission("javertools.cmd.gamemode")) Util.sendMessage(sender, "&4/gamemode &8[&40&8|&41&8|&42&8|&43&8] &8[&4gracz&8] - &7Zmienia tryb gry");
					if(sender.hasPermission("javertools.cmd.helpop")) Util.sendMessage(sender, "&4/helpop &8[&4wiadomosc&8] - &7Kontakt z administracja");
					if(sender.hasPermission("javertools.cmd.exp")) Util.sendMessage(sender, "&4/exp &8[&4set&8|&4give&8|&4remove&8] &8[&4gracz&8] &8[&4ilosc&8] - &7Dawanie punktow expa");
					if(sender.hasPermission("javertools.cmd.heal")) Util.sendMessage(sender, "&4/heal &8([&4gracz&8]) - &7Leczy gracza");
					if(sender.hasPermission("javertools.cmd.feed")) Util.sendMessage(sender, "&4/feed &8([&4gracz&8]) - &7Najedza gracza");
					if(sender.hasPermission("javertools.cmd.fly")) Util.sendMessage(sender, "&4/fly &8([&4gracz&8]) - &7Zmienia tryb latania");
					if(sender.hasPermission("javertools.cmd.tp")) Util.sendMessage(sender, "&4/tp &8[&4gracz&8] &8([&4gracz&8]) - &7Teleportacja gracza");
					if(sender.hasPermission("javertools.cmd.tphere")) Util.sendMessage(sender, "&4/tphere &8[&4gracz&8] - &7Teleportacja gracza do siebie");
					Util.sendMessage(sender, "&8» &7Aby przejsc na kolejna strone wpisz: &4/help 2");
				}
				else if(args[0].equalsIgnoreCase("2")){
					Util.sendMessage(sender, "&8» &7Pomoc pluginu: &4JaverTools&7: &8(&72/10&8)");
					if(sender.hasPermission("javertools.cmd.clearinv")) Util.sendMessage(sender, "&4/clearinv &8([&4gracz&8]) - &7Czysci ekwipunek");
					if(sender.hasPermission("javertools.cmd.enchant")) Util.sendMessage(sender, "&4/enchant &8[&4enchant&8] [&4level&8] - &7Enchantuje przedmiot");
					if(sender.hasPermission("javertools.cmd.tppos")) Util.sendMessage(sender, "&4/tppos &8[&4gracz&8] [&4x&8] [&4y&8] [&4z&8] - &7Teleportuje gracza w dane miejsce");
					if(sender.hasPermission("javertools.cmd.chat")) Util.sendMessage(sender, "&4/chat &8[&4on&8|&4off&8|&4cc&8] - &7Zarzadzanie czatem");
					Util.sendMessage(sender, "&8» &7Aby przejsc na kolejna strone wpisz: &4/help 3");
		
				}
				else if(args[0].equalsIgnoreCase("3")){
					Util.sendMessage(sender, "&8» &7Pomoc pluginu: &4JaverTools&7: &8(&73/10&8)");
					
					Util.sendMessage(sender, "&8» &7Aby przejsc na kolejna strone wpisz: &4/help 4");
				}
				else if(args[0].equalsIgnoreCase("4")){
					Util.sendMessage(sender, "&8» &7Pomoc pluginu: &4JaverTools&7: &8(&74/10&8)");
		
					Util.sendMessage(sender, "&8» &7Aby przejsc na kolejna strone wpisz: &4/help 5");
				}
				else if(args[0].equalsIgnoreCase("5")){
					Util.sendMessage(sender, "&8» &7Pomoc pluginu: &4JaverTools&7: &8(&75/10&8)");
		
					Util.sendMessage(sender, "&8» &7Aby przejsc na kolejna strone wpisz: &4/help 6");
				}
				else if(args[0].equalsIgnoreCase("6")){
					Util.sendMessage(sender, "&8» &7Pomoc pluginu: &4JaverTools&7: &8(&76/10&8)");
		
					Util.sendMessage(sender, "&8» &7Aby przejsc na kolejna strone wpisz: &4/help 7");
				}
				else if(args[0].equalsIgnoreCase("7")){
					Util.sendMessage(sender, "&8» &7Pomoc pluginu: &4JaverTools&7: &8(&77/10&8)");
		
					Util.sendMessage(sender, "&8» &7Aby przejsc na kolejna strone wpisz: &4/help 8");
				}
				else if(args[0].equalsIgnoreCase("8")){
					Util.sendMessage(sender, "&8» &7Pomoc pluginu: &4JaverTools&7: &8(&78/10&8)");
		
					Util.sendMessage(sender, "&8» &7Aby przejsc na kolejna strone wpisz: &4/help 9");
				}
				else if(args[0].equalsIgnoreCase("9")){
					Util.sendMessage(sender, "&8» &7Pomoc pluginu: &4JaverTools&7: &8(&79/10&8)");
		
					Util.sendMessage(sender, "&8» &7Aby przejsc na kolejna strone wpisz: &4/help 10");
				}
				else if(args[0].equalsIgnoreCase("10")){
					Util.sendMessage(sender, "&8» &7Pomoc pluginu: &4JaverTools&7: &8(&710/10&8)");
		
					Util.sendMessage(sender, "");
					Util.sendMessage(sender, "&8» &7Autor pluginu: &4Javer01 + javer-Squad");
					Util.sendMessage(sender, "&8» &7Youtube: &4Javer01");
					Util.sendMessage(sender, "&8» &7Dla: &4Was");
		
				}
			}
		}
	}
}
