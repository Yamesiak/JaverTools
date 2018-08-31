package me.javer.tools.listeners;

import me.javer.tools.utils.HomeUtil;
import me.javer.tools.utils.Util;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener{
	
	@EventHandler
	public void onMove(PlayerMoveEvent event){
		Player p = event.getPlayer();
		Location nfrom = event.getFrom();
		Location nto = event.getTo();
		
		if(nfrom == null || nto == null) return;
		if(nfrom.getBlockX() == nto.getBlockX() && nfrom.getBlockZ() == nto.getBlockZ()) return;
		
		// HOME 
		
		if(HomeUtil.getHomeTeleport().contains(p)){
			HomeUtil.removePlayerHomeTeleport(p);
			Util.sendMessage(p, "&4Blad: &cWykryto ruch! Teleport przerwany...");
		}
	}
}

