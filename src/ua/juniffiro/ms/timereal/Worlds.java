package ua.juniffiro.ms.timereal;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import ua.juniffiro.ms.timereal.cfg.CfgKey;
import ua.juniffiro.ms.timereal.log.MyLogger;
import ua.juniffiro.ms.timereal.util.ConfigUtil;
import ua.juniffiro.ms.timereal.util.TimeUtil;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class Worlds {

    private ConfigurationSection root;
    private List<ConfigurationSection> nodes;
    private List<TimeWorld> worlds;

    public Worlds(ConfigurationSection root) {
        this.root = root;
        this.nodes = ConfigUtil.getSections(root);
        this.worlds = new ArrayList<>();
    }

    public void setRoot(ConfigurationSection root) {
        this.root = root;
    }

    public void setWorlds(List<TimeWorld> worlds) {
        this.worlds = worlds;
    }

    public void setNodes(List<ConfigurationSection> nodes) {
        this.nodes = nodes;
    }

    public List<ConfigurationSection> getNodes() {
        return nodes;
    }

    public List<TimeWorld> getWorlds() {
        return worlds;
    }

    public void find() {
        nodes.forEach(node -> {
            String w = node.getString(CfgKey.WORLD_NAME.path());
            World world = Bukkit.getWorld(w);
            if (world == null) {
                MyLogger.error(String.format(
                        "World %s not found. Check the configuration file for errors.", w));
                return;
            }
            String zone = node.getString(CfgKey.TIME_ZONE.path());
            ZoneId zoneId = TimeUtil.getTimeZone(zone);
            if (zoneId == null) {
                zoneId = ZoneId.of("UTC");
                MyLogger.error("Time zone set incorrectly. Check the configuration file for errors.");
                MyLogger.warn("Timezone set to UTC.");
            }
            worlds.add(new TimeWorld(world, zoneId));
        });
    }

    public void refresh() {
        nodes.clear();
        setNodes(ConfigUtil.getSections(root));
        worlds.clear();
        find();
    }
}
