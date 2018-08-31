package me.javer.tools.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class PlayerLogin implements Listener{
	
	@EventHandler
	public void onLogin(PlayerLoginEvent event){
		Player player = event.getPlayer();
		//	if(!user.getBan()){
			if(Bukkit.getOnlinePlayers().size() >= Bukkit.getMaxPlayers()){
				if(player.hasPermission("javertools.joinfullserver")){
					event.allow();
					return;
				} else {
					event.disallow(Result.KICK_FULL, "&6Przepraszamy, ale serwer jest pelen! &eZakup rangi premium na naszej stronie!");
					return;
				}
			}
	//	}
	}

}
