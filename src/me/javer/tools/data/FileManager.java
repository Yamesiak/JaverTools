package me.javer.tools.data;

import java.io.File;

import me.javer.tools.Main;
import me.javer.tools.utils.LogUtil;

public class FileManager {

	private static File mainDir = Main.getInstance().getDataFolder();
	private static File users = new File(mainDir, "users");
	private static File bans = new File(mainDir, "bans");
	
	public static void check(){
		if(!mainDir.exists()) mainDir.mkdir();
		if(!users.exists()) users.mkdir();
		LogUtil.info("&aStworzono folder: /users/");
		if(!bans.exists()) bans.mkdir();
		LogUtil.info("&aStworzono folder: /bans/");
	}
	
	public static File getUsersFolder(){
		return users;
	}

	public static File getBansFolder(){
		return bans;
	}
}

