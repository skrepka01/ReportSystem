package ry.reportsystem.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import ry.reportsystem.util.HelperImpl;

public class BDLoader implements Listener {

    private final HelperImpl helper = new HelperImpl();

    @EventHandler
    public void loadData(PluginEnableEvent event)
    {
        helper.runLoadDBData();
    }

}
