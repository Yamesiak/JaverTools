package me.javer.tools.objects;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class TeleportRequest {
	
	public static HashMap<Player, Player> lastReceiverByRequester = new HashMap<Player, Player>();
	public static HashMap<Player, Player> lastRequesterByReceiver = new HashMap<Player, Player>();
	public static HashMap<Player, Long> lastRequestTime = new HashMap<Player, Long>();

	public static HashMap<Player, Player> getReceiverByRequester(){
		return lastReceiverByRequester;
	}
	
	public static HashMap<Player, Player> getRequesterByReceiver(){
		return lastReceiverByRequester;
	}
	
	public static HashMap<Player, Long> getLastRequestTime(){
		return lastRequestTime;
	}
	
	public static void send(Player requester, Player receiver){
		getReceiverByRequester().put(requester, receiver);
		getRequesterByReceiver().put(receiver, requester);
		getLastRequestTime().put(requester, Long.valueOf(System.currentTimeMillis()));
	}
	
	public static void accept(Player requester, Player receiver){
		getReceiverByRequester().remove(requester);
		getRequesterByReceiver().remove(receiver);
		getLastRequestTime().remove(requester);
	}
	
	public static void deny(Player requester, Player receiver){
		getReceiverByRequester().remove(requester);
		getRequesterByReceiver().remove(receiver);
		getLastRequestTime().remove(requester);
	}
}
