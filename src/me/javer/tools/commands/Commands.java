package me.javer.tools.commands;

import java.util.Arrays;

import me.javer.tools.commands.utils.ExecutorCaller;


public class Commands {

	private static Commands instance;
	
	public Commands(){
		instance = this;
	}
	
	public void register(){
		new ExecutorCaller(new ExcBroadcast(), "broadcast", "javertools.cmd.broadcast", Arrays.asList("bc"));
		new ExecutorCaller(new ExcGameMode(), "gamemode", "javertools.cmd.gamemode", Arrays.asList("gm"));
		new ExecutorCaller(new ExcHelpop(), "helpop", "javertools.cmd.helpop", Arrays.asList("zglos"));
		new ExecutorCaller(new ExcExp(), "exp", "javertools.cmd.exp", Arrays.asList("xp"));
		new ExecutorCaller(new ExcHeal(), "heal", "javertools.cmd.heal", null);
		new ExecutorCaller(new ExcFeed(), "feed", "javertools.cmd.feed", null);
		new ExecutorCaller(new ExcFly(), "fly", "javertools.cmd.fly", null);
		new ExecutorCaller(new ExcTp(), "teleport", "javertools.cmd.tp", Arrays.asList("tp"));
		new ExecutorCaller(new ExcTpHere(), "tphere", "javertools.cmd.tphere", null);
		new ExecutorCaller(new ExcHelp(), "help", null, null);
		new ExecutorCaller(new ExcClearInventory(), "clearinventory", "javertools.cmd.clearinv", Arrays.asList("clearinv", "ci"));
		new ExecutorCaller(new ExcEnchant(), "enchant", "javertools.cmd.enchant", Arrays.asList("ench"));
		new ExecutorCaller(new ExcTppos(), "tppos", "javertools.cmd.tppos", null);
		new ExecutorCaller(new ExcChat(), "chat", "javertools.cmd.chat", null);
	}
	
	public static Commands getInstance(){
		if(instance == null) return new Commands();
		return instance;
	}
	
}
