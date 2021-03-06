package com.timvisee.glowstonelanterns.command.executable;

import com.timvisee.glowstonelanterns.GlowstoneLanterns;
import com.timvisee.glowstonelanterns.command.CommandParts;
import com.timvisee.glowstonelanterns.command.ExecutableCommand;
import com.timvisee.glowstonelanterns.util.Profiler;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ReloadCommand extends ExecutableCommand {

    /**
     * Execute the command.
     *
     * @param sender           The command sender.
     * @param commandReference The command reference.
     * @param commandArguments The command arguments.
     *
     * @return True if the command was executed successfully, false otherwise.
     */
    @Override
    public boolean executeCommand(CommandSender sender, CommandParts commandReference, CommandParts commandArguments) {
        // Profile the reload process
        Profiler p = new Profiler(true);

        // Show a status message
        sender.sendMessage(ChatColor.YELLOW + "Reloading Glowstone Lanterns...");

        // Reload the configuration
        GlowstoneLanterns.instance.reloadConfig();
        sender.sendMessage(ChatColor.YELLOW + "Loaded the configuration.");

        // Reload lanterns
        GlowstoneLanterns.instance.loadLanterns();
        sender.sendMessage(ChatColor.YELLOW + "Loaded " + ChatColor.WHITE + GlowstoneLanterns.instance.glLanterns.size() + ChatColor.YELLOW + " lanterns.");

        // Dungeon Maze reloaded, show a status message
        sender.sendMessage(ChatColor.GREEN + "Glowstone Lanterns has been reloaded, took " + p.getTimeFormatted() + "!");
        return true;
    }
}
