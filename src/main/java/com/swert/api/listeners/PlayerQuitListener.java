package com.swert.api.listeners;

import com.swert.api.managers.HideManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class PlayerQuitListener implements Listener {

    public PlayerQuitListener(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
        if (!HideManager.hide.contains(event.getPlayer())) return;

        HideManager.hide.remove(event.getPlayer());
        Bukkit.getOnlinePlayers().forEach(online -> event.getPlayer().showPlayer(online));
    }
}
