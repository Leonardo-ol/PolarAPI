package com.swert.api.listeners;

import com.swert.api.managers.HideManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

public class PlayerCommandListener implements Listener {

    public PlayerCommandListener(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();

        if (message.equalsIgnoreCase("/off")) {
            event.setCancelled(true);

            if (HideManager.hide.contains(player)) return;

            player.sendMessage("§aModo esconder ativado, tenha cuidado para não entrar em pvp.");
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
            Bukkit.getOnlinePlayers().forEach(online -> player.hidePlayer(online));
            HideManager.hide.add(player);
        } else if (message.equalsIgnoreCase("/on")) {
            event.setCancelled(true);

            if (!HideManager.hide.contains(player)) return;

            player.sendMessage("§aModo esconder desativado com sucesso.");
            player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 1.0F, 1.0F);
            Bukkit.getOnlinePlayers().forEach(online -> player.showPlayer(online));
            HideManager.hide.remove(player);
        }
    }
}
