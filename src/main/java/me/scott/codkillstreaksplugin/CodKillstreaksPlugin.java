package me.scott.codkillstreaksplugin;
import org.bukkit.plugin.java.JavaPlugin;

public class CodKillstreaksPlugin extends JavaPlugin {
    private static CodKillstreaksPlugin instance;

    private CodKillstreaksPlugin() {

    }

    public static CodKillstreaksPlugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("CodKillstreaksPlugin has been enabled!");
        getCommand("CarePackage").setExecutor(new CodKillstreakCommandHandler(this));
        getServer().getPluginManager().registerEvents(new CodKillstreakEventHandler(this), this);
    }


    @Override
    public void onDisable() {
        getLogger().info("CodKillstreaksPlugin has been disabled!");
    }
}
