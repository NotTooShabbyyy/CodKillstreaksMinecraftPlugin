package me.scott.codkillstreaksplugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.UUID;

public class CodKillstreaksScoreboard {
  private KillTracker killTracker;
  private static CodKillstreaksScoreboard instance;
  private HashMap<UUID, Scoreboard> playerBoards = new HashMap<>();
  private HashMap<UUID, Objective> playerObjectives = new HashMap<>();

  private CodKillstreaksScoreboard() {}

    public static CodKillstreaksScoreboard getInstance() {
      if (instance == null) {
          instance = new CodKillstreaksScoreboard();
          instance.killTracker = KillTracker.getInstance();
      }

      return instance;
    }

    public void setKillstreaksScoreboard(Player player) {
      UUID uuid = player.getUniqueId();

      Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
      Objective obj = scoreboard.registerNewObjective("killTracker", "dummy", ChatColor.GOLD + "" +  ChatColor.BOLD + "Kill Tracker");

      // Attach this obj (HTML look-a-like container div to user UI)
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.getScore("").setScore(2);
        obj.getScore(ChatColor.GRAY + "Kills + " + killTracker.getCurrentKills(uuid)).setScore(1);
    }


    public void updatePlayerScoreboard(Player player) {
      UUID uuid = player.getUniqueId();
      Scoreboard playerBoard = getPlayerBoard(uuid);



    }


    public void resetPlayerObjectives(Player player) {
      UUID uuid = player.getUniqueId();
      Scoreboard playerBoard = playerBoards.get(uuid);

      // reset each of these sorta inner divs like in html
      for (String entry : playerBoard.getEntries()) {
        playerBoard.resetScores(entry);
      }

    }

    public Scoreboard getPlayerBoard(UUID uuid) {
        return playerBoards.getOrDefault(uuid, null);
    }



}
