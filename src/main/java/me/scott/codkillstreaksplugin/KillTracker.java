package me.scott.codkillstreaksplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class KillTracker {
    private HashMap<UUID, Integer> currentKills = new HashMap<>();
    private HashMap<UUID, Integer> highestKillstreak = new HashMap<>();
    private HashMap<UUID, Integer> playerDeaths = new HashMap<>();
    private static KillTracker instance;

    private KillTracker() {}

    public static KillTracker getInstance() {
        if (instance == null) {
            instance = new KillTracker();
        }
        return instance;
    }


    public void addKill(UUID uuid) {
        Player player = Bukkit.getPlayer(uuid);

        int kills = currentKills.getOrDefault(uuid, 0) + 1;
        currentKills.put(uuid, kills);

        // if the kill count is divisible by 5
        if (kills % 5 == 0) {
            showKillstreakBadge(player, kills);
        }

        int currentHighestKillstreak = highestKillstreak.getOrDefault(uuid, 0);


        if (kills > highestKillstreak.get(uuid)) {
            highestKillstreak.put(uuid, kills);
        }

    }

    public void resetCurrentKills(UUID uuid) {
        currentKills.put(uuid, 0);
    }

    public int getCurrentKills(UUID uuid) {
        return currentKills.getOrDefault(uuid, 0);
    }

    public int getHighestKillstreak(UUID uuid) {
        return highestKillstreak.getOrDefault(uuid, 0);
    }

    public void addDeath(UUID uuid) {
        int deaths = playerDeaths.getOrDefault(uuid, 0) + 1;
        playerDeaths.put(uuid, deaths);
    }

    public int getPlayerDeaths(UUID uuid) {
        return playerDeaths.getOrDefault(uuid, 0);
    }

    public void showKillstreakBadge(Player player, int currentKills) {
        String badge = "";

        switch (currentKills) {
            case 5:
                badge = ChatColor.GREEN + "" + ChatColor.BOLD + "✈ UAV Ready [5 Kills]";
                break;
            case 10:
                badge = ChatColor.GOLD + "" + ChatColor.BOLD + "🚁 Chopper Gunner [10 Kills]";
                break;
            case 15:
                badge = ChatColor.RED + "" + ChatColor.BOLD + "💀 Ruthless! [15 Kills]";
                break;
            case 20:
                badge = ChatColor.DARK_RED + "" + ChatColor.BOLD + "🔥 Relentless Rampage [20 Kills]";
                break;
            case 25:
                badge = ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "☠ Brutal Executioner [25 Kills]";
                break;
            case 30:
                badge = ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "☢ NUCLEAR UNLOCKED [30 Kills]";
                break;
        }

        if (!badge.isEmpty()) {
            ActionBarUtil.sendActionBar(player, badge);
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
        }
    }



}
