package ua.juniffiro.ms.timereal;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import ua.juniffiro.ms.timereal.cfg.CfgKey;
import ua.juniffiro.ms.timereal.commands.CommandConfigReload;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class Main extends JavaPlugin {

    private static Main instance;
    private BukkitTask task;
    private Worlds worlds;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        setupConfig();

        getCommand("rtreload").setExecutor(new CommandConfigReload());

        if (isPluginEnabled()) {
            worlds = new Worlds(root());
            worlds.find();

            startTask();
        }
    }

    public Worlds getWorlds() {
        return worlds;
    }

    public boolean isPluginEnabled() {
        return getConfig().getBoolean(CfgKey.PLUGIN_STATUS.path(), true);
    }

    private void setupConfig() {
        FileConfiguration config = this.getConfig();
        config.options().copyDefaults(true);
        this.saveConfig();
    }

    private ConfigurationSection root() {
        return getConfig().getConfigurationSection(CfgKey.WORLDS.path());
    }

    private void startTask() {
        task = getServer().getScheduler().runTaskTimer(this,
                () -> worlds.getWorlds().forEach(TimeWorld::setRealTime), 20L, 20L);
    }

    public void reload() {
        reloadConfig();
        if (isPluginEnabled()) {
            worlds.setRoot(root());
            worlds.refresh();
            if (task == null || task.isCancelled()) {
                startTask();
            }
        } else {
            if (task != null) {
                task.cancel();
            }
        }
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onDisable() {
        if (task != null) task.cancel();
    }
}