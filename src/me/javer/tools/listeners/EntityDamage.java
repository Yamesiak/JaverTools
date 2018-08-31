package me.javer.tools.listeners;

import me.javer.tools.objects.User;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener{
	
	@EventHandler
	public void onDamage(EntityDamageEvent event){
		if(event.getEntity() instanceof Player){
			Player player = (Player) event.getEntity();
			User user = User.get(player);
			if(user.isGod()){
				event.setCancelled(true);
			}
		}
	}

}
