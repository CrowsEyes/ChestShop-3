package com.Acrobot.ChestShop.Plugins;

import java.util.ArrayList;

import com.Acrobot.ChestShop.Events.EmptyShopRemovedEvent;
import com.octagami.claimit.object.Claimable;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * @author Acrobot
 */
public class ClaimIt implements Listener {

	public ClaimIt() {

	}

	@EventHandler
	public void onEmptyShopRemoved(EmptyShopRemovedEvent event) {

		Inventory containerInventory = event.getChest().getInventory();

		ItemStack[] itemsInContainer = containerInventory.getContents();

		ArrayList<ItemStack> claimItems = new ArrayList<ItemStack>();
		
		claimItems.add(new ItemStack(Material.SIGN));
		claimItems.add(new ItemStack(Material.CHEST));

		boolean empty = true;
		
		for (ItemStack stack : itemsInContainer) {

			if (stack != null && stack.getAmount() > 0) {
				claimItems.add(stack);
				empty = false;
			}
				
		}

		if (claimItems.size() > 0) {
			
			String label = "ChestShop";
			
			if (empty)
				label = "Empty ChestShop";
			else
				label = "Depleted ChestShop";
				
			Claimable claimable = new Claimable(label, event.getItem(), 0, 0, claimItems);

			com.octagami.claimit.ClaimIt.addClaimToPlayer(event.getPlayer(), claimable);
		}
		
		containerInventory.clear();
	}

}
