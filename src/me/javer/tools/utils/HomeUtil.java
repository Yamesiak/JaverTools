package me.javer.tools.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class HomeUtil {
	
	private static List<Player> players = new ArrayList<>();
	
	public static List<Player> getHomeTeleport(){
		return new ArrayList<Player>(players);
	}
	
	public static void addPlayerHomeTeleport(Player player){
		if(!players.contains(player)) players.add(player);
	}
	
	public static void removePlayerHomeTeleport(Player player){
		if(players.contains(player)) players.remove(player);
	}

}

