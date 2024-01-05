package ry.reportsystem.util;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import ry.reportsystem.ReportSystem;
import ry.reportsystem.commands.Report;
import ry.reportsystem.commands.ReportList;
import ry.reportsystem.configuration.Config;
import ry.reportsystem.listener.BDLoader;
import ry.reportsystem.listener.PunishPlayer;

public class HelperImpl implements Helper {

    @Override
    public void registerCommand() {
        Bukkit.getPluginCommand("report").setExecutor(new Report());
        Bukkit.getPluginCommand("report_list").setExecutor(new ReportList());
    }

    @Override
    public void registerEvents(Plugin plugin) {
        Bukkit.getServer().getPluginManager().registerEvents(new PunishPlayer(),plugin);
        Bukkit.getServer().getPluginManager().registerEvents(new BDLoader(), plugin);
    }

    @Override
    public void runSendActionBar(Player player) {
        Bukkit.getScheduler().runTaskLater(ReportSystem.instance, new Runnable() {
            @Override
            public void run() {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(Config.getConfig().getString("color")+Config.getConfig().getString("title")
                ));
            }
        },20L);
    }

    @Override
    public void runLoadDBData() {
        Bukkit.getScheduler().runTaskTimer(ReportSystem.instance, new Runnable() {
            @Override
            public void run() {
                // todo : отправка данных в бд.
            }
        },0,18000);
    }
}
