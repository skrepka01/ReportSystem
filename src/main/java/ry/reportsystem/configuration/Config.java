package ry.reportsystem.configuration;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class Config {

    private File config;
    private static FileConfiguration configuration;

    public void loadConfig(Plugin plugin)
    {
        config = new File(plugin.getDataFolder(),"report.yml");
        if(!config.exists())
        {
            plugin.getDataFolder().mkdir();
            try {
                config.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            plugin.saveResource("report.yml",true);
        }
        configuration = YamlConfiguration.loadConfiguration(config);
    }

    public static FileConfiguration getConfig()
    {
        return configuration;
    }
}
