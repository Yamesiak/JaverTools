package me.javer.tools.utils;

import java.util.regex.Pattern;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Util {

	public static String colored(String arg0){
		return ChatColor.translateAlternateColorCodes('&', arg0);
	}
	
	public static String fixColor(String arg0){
		return arg0.replace('&', '§');
	}
	
	public static IChatBaseComponent sendJSONMessage(String message){
		return ChatSerializer.a("{\"text\":\"" + Util.colored(message) + "\"}");
	}
	
	public static void sendTitle(Player toSend, String message, int is, int on, int off){
		PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, sendJSONMessage(message), is, on, off);
		((CraftPlayer)toSend).getHandle().playerConnection.sendPacket(title);
	}
	
	public static void sendSubTitle(Player toSend, String message, int is, int on, int off){
		PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, sendJSONMessage(message), is, on, off);
		((CraftPlayer)toSend).getHandle().playerConnection.sendPacket(subtitle);
	}
	
	public static void sendAction(Player toSend, String message){
		PacketPlayOutChat action = new PacketPlayOutChat(sendJSONMessage(message), (byte) 2);
		((CraftPlayer)toSend).getHandle().playerConnection.sendPacket(action);
	}
	
	public static boolean sendMessage(CommandSender sender, String string){
		if((string != null) || (string != " ")){
			sender.sendMessage(colored(string));
		}
		return false;
	}
	
	public static boolean isInteger(String string) {
	    return Pattern.matches("-?[0-9]+", string.subSequence(0, string.length()));
	}
	
	public static boolean broadcast(String string, boolean sendToConsole){
		if((string != null) || (string != " ")){
			if(!sendToConsole){
				for(Player p : Bukkit.getOnlinePlayers()){
					Util.sendMessage(p, string);
				}
			} else {
				Bukkit.getServer().broadcastMessage(colored(string));
			}
		}
		return false;
	}
	
}