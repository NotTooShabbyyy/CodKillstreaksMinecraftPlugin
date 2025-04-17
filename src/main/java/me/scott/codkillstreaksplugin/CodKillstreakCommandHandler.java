package me.scott.codkillstreaksplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CodKillstreakCommandHandler implements CommandExecutor {
    private CodKillstreaksPlugin mainPlugin;

    public CodKillstreakCommandHandler(CodKillstreaksPlugin mainPlugin) {
        this.mainPlugin = mainPlugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player player)) {
            mainPlugin.getLogger().info("Sender of command must be a player!");
            return true;
        }

        // tutorial command

        new BukkitRunnable() {
            int ticks = 0;

            @Override
            public void run() {
                switch(ticks) {
                    case 0:
                        player.sendMessage(ChatColor.YELLOW + "This is a call of duty killstreaks plugin for Minecraft");
                        break;
                    case 60:
                        player.sendMessage(ChatColor.YELLOW + "Try to get the best killstreak possible to earn those unique call of duty killstreaks!");
                        break;
                    case 110:
                        player.sendMessage(ChatColor.GOLD + "Good luck!");
                        break;
                    case 120:
                        this.cancel();
                        break;
                }

                ticks++;
            }
        }.runTaskTimer(mainPlugin, 0, 1L);



        return true;
    }
}
