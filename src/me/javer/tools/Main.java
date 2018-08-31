package me.javer.tools;

import me.javer.tools.commands.Commands;
import me.javer.tools.data.DataManager;
import me.javer.tools.data.FileManager;
import me.javer.tools.listeners.EntityDamage;
import me.javer.tools.listeners.PlayerChat;
import me.javer.tools.listeners.PlayerJoin;
import me.javer.tools.listeners.PlayerLogin;
import me.javer.tools.listeners.PlayerMove;
import me.javer.tools.listeners.PlayerQuit;
import me.javer.tools.objects.Chat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	private static Main instance;
	private boolean disabling;
	
	@Override
	public void onLoad() {
		new Commands().register();
	}
	
	@SuppressWarnings("deprecation")
	public void onEnable(){
		instance = this;
		FileManager.check();
		DataManager.load();
		Chat.setChat(true);
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new EntityDamage(), this);
		pm.registerEvents(new PlayerChat(), this);
		pm.registerEvents(new PlayerLogin(), this);
		pm.registerEvents(new PlayerMove(), this);
		pm.registerEvents(new PlayerQuit(), this);
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				DataManager.save();
				
			}
		}, 5*20, 5*20);
	}
	
	public void onDisable(){
		disabling = true;
		DataManager.save();
	}
	public static String getVersion(){
		return instance.getDescription().getVersion();
	}

	public static String getPluginName(){
		return instance.getDescription().getName();
	}
	
	public boolean isDisabling(){
		return disabling;
	}
	
	public static Main getInstance(){
		if(instance == null) return new Main();
		return instance;
	}

}