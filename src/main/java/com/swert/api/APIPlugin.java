package com.swert.api;

import com.swert.api.listeners.PlayerCommandListener;
import com.swert.api.listeners.PlayerJoinListener;
import com.swert.api.listeners.PlayerQuitListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class APIPlugin extends JavaPlugin {

    @Getter
    private static APIPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        new PlayerJoinListener(this);
        new PlayerQuitListener(this);
        new PlayerCommandListener(this);

        getLogger().info("API plugin enabled successfully");
    }
}
