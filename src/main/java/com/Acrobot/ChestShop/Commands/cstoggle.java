package com.Acrobot.ChestShop.Commands;

import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Acrobot
 */


public class cstoggle implements CommandExecutor {
	private final static HashMap<Player, ArrayList<Block>> chesttoggle = new HashMap<Player,ArrayList<Block>>();
	
	public void CSToggle(Player player) {
		if(chesttoggle.containsKey(player)) {
			chesttoggle.remove(player);
			player.sendMessage("You will no longer recieve buy/sell messages.");
		}
		else {
			chesttoggle.put(player, null);
			player.sendMessage("You will once again recieve buy/sell messages.");
		}
			
	}
	
	public static boolean CSCheck(Player player) {
		if(chesttoggle.containsKey(player))
			return true;
		else
			return false;
	}
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
    	CSToggle(player);
    	return true;
    }
}