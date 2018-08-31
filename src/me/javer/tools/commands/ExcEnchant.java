package me.javer.tools.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.javer.tools.commands.utils.Executor;
import me.javer.tools.utils.EnchantUtil;
import me.javer.tools.utils.Util;

public class ExcEnchant implements Executor{
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender instanceof Player)){
			Util.sendMessage(Bukkit.getConsoleSender(), "&4Blad: &cMusisz byc na serwerze aby wykonac ta komende!");
			return;
		}
		
		if(!sender.hasPermission("javertools.cmd.enchant")){
			Util.sendMessage(sender, "&cNie masz uprawnien do uzycia tej komendy &8(&7javertools.cmd.enchant&8)");
			return;
		}
		Player p = (Player) sender;
		if(args.length == 0){
			Util.sendMessage(p, "&8» &7Poprawne uzycie: &4/enchant &8[&4enchant&8] [&4level&8]");
			return;
		} else {
			if(args.length >= 2){
				String enchantName = args[0];
				ItemStack item = p.getItemInHand();
				Enchantment enchant = EnchantUtil.get(enchantName);
				if(enchant == null){
					Util.sendMessage(p, "&4Blad: &cTakie zaklecie nie istnieje!");
					return;
				}
				int level = enchant.getMaxLevel();
				if(Util.isInteger(args[1])){
					level = Integer.parseInt(args[1]);
				} else {
					Util.sendMessage(p, "&4Blad: &cPoziom zaklecia musi byc liczba!");
					return;
				}
				item.addUnsafeEnchantment(enchant, level);
				Util.sendMessage(p, "&8» &7Pomyslnie zaenchantowales &4" + item.getType().toString() + "&7 na: &4" + enchant.getName() + " &8(&7" + level + "&8)");
			}
		}
		
	}

}

