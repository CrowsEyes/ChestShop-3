package com.Acrobot.ChestShop.Events;

import org.bukkit.block.Chest;
import org.bukkit.block.Sign;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;

/**
 * @author Acrobot
 */
public class EmptyShopRemovedEvent extends Event {
	
    private static final HandlerList handlers = new HandlerList();

    private final Sign sign;
    private final Chest chest;
    private final String player;
    private final String item;

    public EmptyShopRemovedEvent(Sign sign, @Nullable Chest chest, String player, String item) {
        this.sign = sign;
        this.chest = chest;
        this.player = player;
        this.item = item;
    }

    @Nullable public Chest getChest() {
        return chest;
    }

    public Sign getSign() {
        return sign;
    }
    
    public String getPlayer() {
        return player;
    }
    
    public String getItem() {
        return item;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
