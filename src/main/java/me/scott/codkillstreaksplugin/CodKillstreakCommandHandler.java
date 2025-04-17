package me.scott.codkillstreaksplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CodKillstreakCommandHandler implements CommandExecutor {
    private CodKillstreaksPlugin mainPlugin;

    public CodKillstreakCommandHandler(CodKillstreaksPlugin mainPlugin) {
        this.mainPlugin = mainPlugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        return true;
    }
}
