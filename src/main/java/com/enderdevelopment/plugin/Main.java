package com.enderdevelopment.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Purpur End plugin enabled!");
        this.getCommand("PurpurEnd").setExecutor(new PurpurEndCommand());
        this.getCommand("PurpurPortal").setExecutor(new PurpurPortalCommand());
        getServer().getPluginManager().registerEvents(new PurpurEndListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Purpur End plugin disabled!");
    }
}