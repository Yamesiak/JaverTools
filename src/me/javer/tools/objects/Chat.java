package me.javer.tools.objects;

public class Chat {

	private static boolean chat;
	
	public static boolean getChat(){
		return chat;
	}
	
	public static boolean setChat(boolean mode){
		chat = mode;
		return mode;
	}
}
