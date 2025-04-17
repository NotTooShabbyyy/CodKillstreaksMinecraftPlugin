package me.scott.codkillstreaksplugin;

public class CodKillstreaksManager {
    private CodKillstreaksPlugin mainPlugin;
    private static CodKillstreaksManager instance;

    private CodKillstreaksManager() {}

    public static CodKillstreaksManager getInstance() {
        if (instance == null) {
            instance = new CodKillstreaksManager();
        }

        return instance;
    }

}
