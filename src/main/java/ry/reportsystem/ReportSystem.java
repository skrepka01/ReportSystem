package ry.reportsystem;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.bukkit.plugin.java.JavaPlugin;
import ry.reportsystem.configuration.Config;
import ry.reportsystem.model.Complaint;
import ry.reportsystem.util.HelperImpl;

import java.util.concurrent.TimeUnit;

public final class ReportSystem extends JavaPlugin {

    private final HelperImpl helper = new HelperImpl();

    public static ReportSystem instance;

    public static Cache<Long, Complaint> reportCache;

    private final Config config = new Config();

    @Override
    public void onEnable() {
        instance = this;
        helper.registerCommand();
        helper.registerEvents(this);
        reportCache = Caffeine.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(15, TimeUnit.MINUTES)
                .build();
        config.loadConfig(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
