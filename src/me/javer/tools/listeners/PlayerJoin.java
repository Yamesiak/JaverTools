package me.javer.tools.listeners;

import me.javer.tools.objects.User;
import me.javer.tools.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		User user = User.get(player);
		User.get(player);
		user.setGod(false);
		for(Player all : Bukkit.getOnlinePlayers()){
			if(all.hasPermission("javertools.spy")){
				Util.sendMessage(all, "&6Administrator:&c " + player.getName() + " &6dolaczyl na serwer!");
			}
		}
		if(!player.hasPlayedBefore()){
			Util.sendAction(player, "&aWitaj na naszym serwerze!");
		}
	}

}