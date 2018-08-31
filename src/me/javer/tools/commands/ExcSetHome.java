package me.javer.tools.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.javer.tools.commands.utils.Executor;
import me.javer.tools.data.DataManager;
import me.javer.tools.objects.User;
import me.javer.tools.utils.Util;

public class ExcSetHome implements Executor{
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			Util.sendMessage(Bukkit.getConsoleSender(), "&4Blad: &cMusisz byc na serwerze aby wykonac ta komende!");
			return;
		}
		
		if(!sender.hasPermission("javertools.cmd.sethome")){
			Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy &8(&7javertools.cmd.sethome&8)");
			return;
		}
		Player p = (Player) sender;
		User user = User.get(p);
		user.setHome(p.getLocation());
		user.setHasHome(true);
		DataManager.save();
		DataManager.load();
		Util.sendTitle(p, "", 15, 15, 15);
		Util.sendSubTitle(p, "&8» &7Pomyslnie ustawiles sobie nowy dom!", 15, 15, 15);
		Util.sendMessage(p, "&8» &7Pomyslnie ustawiles sobie nowy dom!");
	}

}
