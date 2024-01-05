package ry.reportsystem.listener;

import lombok.NoArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import ry.reportsystem.model.Complaint;
import ry.reportsystem.service.ReportServiceImpl;
import ry.reportsystem.util.HelperImpl;

import java.util.Objects;

@NoArgsConstructor
public class PunishPlayer implements Listener {

    private final ReportServiceImpl reportServiceImpl = new ReportServiceImpl();

    private boolean punished = false;
    private int counter = 0;
    private final HelperImpl helper = new HelperImpl();

    @EventHandler
    public void punish(PlayerMoveEvent event)
    {
        if (punished)
        {
            event.setCancelled(true);
            helper.runSendActionBar(event.getPlayer());
        }
    }

    @EventHandler
    public void joinTheGame(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        for (Complaint complaint :  reportServiceImpl.findAllReports())
        {
            if (complaint.getRecipient().equals(player.getDisplayName()))
            {
                ++counter;
                if (counter == 3)
                {
                    punished = true;
                }
            }
        }
    }
}
