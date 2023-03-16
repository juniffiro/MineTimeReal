package ua.juniffiro.ms.timereal.util;

import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class ConfigUtil {

    /**
     * Get all configuration sections of source.
     *
     * @param source
     *        ConfigurationSection
     *
     * @return {@link java.util.List} Configuration sections
     */
    public static List<ConfigurationSection> getSections(ConfigurationSection source) {
        List<ConfigurationSection> nodes = new ArrayList<>();
        for (String key : source.getKeys(false)) {
            if (source.isConfigurationSection(key)) {
                nodes.add(source.getConfigurationSection(key));
            }
        }
        return nodes;
    }
}
