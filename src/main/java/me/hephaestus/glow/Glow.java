package me.hephaestus.glow;

import me.hephaestus.glow.Commands.GlowCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Glow extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        // Adds the registation of command. The "" part is the command to prompt in chat.
        // The setExucator needs to be the command class
        getCommand("glow").setExecutor(new GlowCommand());
    }
}
