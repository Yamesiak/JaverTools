package me.javer.tools.objects;

import java.io.File;
import java.util.UUID;

import me.javer.tools.data.FileManager;
import me.javer.tools.objects.utils.UserUtils;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class User{
	
	private String name;
	private Player player;
	private UUID uuid;
	private boolean god;
	private Location home;
	private boolean hasHome;
	private long mute;
	private Ban ban;
	
	private User(String name){
		this.name = name;
		UserUtils.addUser(this);
	}
	
	private User(UUID uuid){
		this.uuid = uuid;
		UserUtils.addUser(this);
	}
	
	private User(Player player){
		this.player = player;
		this.uuid = player.getUniqueId();
		UserUtils.addUser(this);
	}
	
	public String getName() {
		return this.name;
	}

	public Player getPlayer() {
		return this.player;
	}

	public UUID getUUID() {
		return this.uuid;
	}

	public boolean isGod() {
		return this.god;
	}

	public Location getHome() {
		return this.home;
	}
	
	public boolean hasHome() {
		return this.hasHome;
	}

	public long getMute() {
		return this.mute;
	}

	public Ban getBan() {
		return this.ban;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setUUID(UUID uuid) {
		this.uuid = uuid;
	}

	public void setGod(boolean god) {
		this.god = god;
	}

	public void setHome(Location home) {
		this.home = home;
	}
	
	public void setHasHome(boolean hasHome) {
		this.hasHome = hasHome;
	}

	public void setMute(long mute) {
		this.mute = mute;
	}
	
	public void setBan(Ban ban){
		this.ban = ban;
	}
	
	public static User get(String name){
		for(User user : UserUtils.getUsers()){
			if(user.getName().equalsIgnoreCase(name)) return user;
		}
		return new User(name);
	}
	
	public static User get(Player player){
		for(User user : UserUtils.getUsers()){
			if(user.getName().equalsIgnoreCase(player.getName())) return user;
			if(user.getUUID().equals(player.getUniqueId())){
				if(!user.getName().equalsIgnoreCase(player.getName())){
					if(new File(FileManager.getUsersFolder(), user.getName() + ".yml").exists()){
						new File(FileManager.getUsersFolder(), user.getName() + ".yml").delete();
					}
					user.setName(player.getName());
				}
				return user;
			}
		}
		return new User(player);
	}
	
	public String toString(){
		return this.name;
	}

}
