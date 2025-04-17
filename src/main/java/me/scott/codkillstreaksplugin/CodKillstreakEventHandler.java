package me.scott.codkillstreaksplugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class CodKillstreakEventHandler implements Listener {
    private CodKillstreaksPlugin mainPlugin = CodKillstreaksPlugin.getInstance();
    private CodKillstreaksScoreboard scoreboard = CodKillstreaksScoreboard.getInstance();





    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.AQUA + player.getName() + " welcome to the server!");

        scoreboard.setKillstreaksScoreboard(player);
    }

}
