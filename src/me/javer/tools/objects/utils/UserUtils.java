package me.javer.tools.objects.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.javer.tools.objects.User;

public class UserUtils {

	public static List<User> users = new ArrayList<User>();
	
	public static List<User> getUsers(){
		return new ArrayList<User>(users);
	}
	
	public static void addUser(User user){
		if(!users.contains(user)) users.add(user);
	}
	
	public static void removeUser(User user){
		if(users.contains(user)) users.remove(user);
	}
	
	public static boolean playedBefore(String name){
		for(User user : users){
			if(user.getName().equalsIgnoreCase(name)) return true;
		}
		return false;
	}
	
	public static boolean playedBefore(UUID uuid){
		for(User user : users){
			if(user.getUUID().equals(uuid)) return true;
		}
		return false;
	}
	
	public static List<String> toNames(List<User> users){
		List<String> names = new ArrayList<String>();
		for(User user : users) names.add(user.getName());
		return names;
	}

	public static List<User> fromNames(List<String> names){
		List<User> users = new ArrayList<User>();
		for(String string : names) users.add(User.get(string));
		return users;
	}
	
}

