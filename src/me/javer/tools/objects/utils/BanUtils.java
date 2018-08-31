package me.javer.tools.objects.utils;

import java.util.ArrayList;
import java.util.List;

import me.javer.tools.objects.Ban;

public class BanUtils {
	
	public static List<Ban> bans = new ArrayList<Ban>();
	
	public static List<Ban> getBans(){
		return new ArrayList<Ban>(bans);
	}
	
	public static void addBan(Ban ban){
		if(!bans.contains(ban)) bans.add(ban);
	}
	
	public static void removeBan(Ban ban){
		if(bans.contains(ban)) bans.remove(ban);
	}

}
