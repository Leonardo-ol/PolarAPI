package com.swert.api.utils;

import com.swert.api.APIPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public abstract class CommandUtil extends Command {

    protected final APIPlugin plugin = APIPlugin.getInstance();

    public CommandUtil(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        return perform(commandSender, strings);
    }

    public abstract boolean perform(CommandSender sender, String... args);

    public boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    public int toInt(String s) {
        return Integer.parseInt(s);
    }

    public boolean message(CommandSender player, String... message) {
        player.sendMessage(message);
        return false;
    }
}
