package ry.reportsystem.util;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public interface Helper {

    void registerCommand();
    void registerEvents(Plugin plugin);

    void runSendActionBar(Player player);

    void runLoadDBData();
}
