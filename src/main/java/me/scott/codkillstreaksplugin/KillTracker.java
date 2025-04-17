package me.scott.codkillstreaksplugin;

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
        int kills = currentKills.getOrDefault(uuid, 0) + 1;
        currentKills.put(uuid, kills);

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



}
