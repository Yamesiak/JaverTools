package me.javer.tools.commands;

import me.javer.tools.commands.utils.Executor;
import me.javer.tools.objects.Chat;
import me.javer.tools.utils.Util;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExcChat implements Executor{
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!sender.hasPermission("javertools.cmd.chat")){
			Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy &8(&7javertools.cmd.chat&8)");
			return;
		}
		if(args.length == 0){
			Util.sendMessage(sender, "&8» &7Poprawne uzycie: &4/chat &8[&4on&8|&4off&8|&4cc&8]");
			return;
		} else {
			if(args.length >= 1){
				if(args[0].equalsIgnoreCase("on")){
					if(Chat.getChat() == true){
						Util.sendMessage(sender, "&4Blad: &cChat jest juz wlaczony! Musisz go najpierw wylaczyc");
						return;
					}
					
					Chat.setChat(true);
					Util.broadcast("&7Chat zostal wlaczony przez: &4" + sender.getName(), true);
					Util.sendMessage(sender, "&8» &7Pomyslnie wlaczyles chat!");
					if(sender instanceof Player){
						Util.sendTitle((Player) sender, "&4CHAT", 5, 15, 15);
						Util.sendSubTitle((Player) sender, "&8» &7Pomyslnie wlaczyles chat!", 5, 15, 15);
					}
				}
				else if(args[0].equalsIgnoreCase("off")){
					if(Chat.getChat() == false){
						Util.sendMessage(sender, "&4Blad: &cChat jest juz wylaczony! Musisz go najpierw wlaczyc");
						return;
					}
					
					Chat.setChat(false);
					Util.broadcast("&7Chat zostal wylaczony przez: &4" + sender.getName(), true);
					Util.sendMessage(sender, "&8» &7Pomyslnie wylaczyles chat!");
					if(sender instanceof Player){
						Util.sendTitle((Player) sender, "&4CHAT", 5, 15, 15);
						Util.sendSubTitle((Player) sender, "&8» &7Pomyslnie wylaczyles chat!", 5, 15, 15);
					}
				}
				else if(args[0].equalsIgnoreCase("cc")){
					for(int i = 0; i < 101; i++){
						Util.broadcast("", false);
					}
					
					Util.broadcast("&7Chat zostal wyczyszczony przez: &4" + sender.getName(), true);
					Util.sendMessage(sender, "&8» &7Pomyslnie wyczysciles chat!");
					if(sender instanceof Player){
						Util.sendTitle((Player) sender, "&4CHAT", 5, 15, 15);
						Util.sendSubTitle((Player) sender, "&8» &7Pomyslnie wyczysciles chat!", 5, 15, 15);
					}
				}
			}
		}
	}

}