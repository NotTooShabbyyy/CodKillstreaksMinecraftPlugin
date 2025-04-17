package me.scott.codkillstreaksplugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class CodKillstreakEventHandler implements Listener {
    private CodKillstreaksPlugin mainPlugin = CodKillstreaksPlugin.getInstance();
    private CodKillstreaksScoreboard scoreboard = CodKillstreaksScoreboard.getInstance();
    private KillTracker killTracker = KillTracker.getInstance();





    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.AQUA + player.getName() + " welcome to the server!");

        scoreboard.setKillstreaksScoreboard(player);
    }

    @EventHandler
    public void OnEntityDeath(EntityDeathEvent event) {
        //  check if killer is player
        Entity killer = event.getEntity().getKiller();
        if ((event.getEntity() instanceof Monster) && killer instanceof Player player) {
            // update kills for player
            killTracker.addKill(player.getUniqueId());


        }

    }
}
