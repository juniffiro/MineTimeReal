package ua.juniffiro.ms.timereal.cfg;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public enum CfgKey {

    /**
     * Keys for working with config
     */

    PLUGIN_STATUS("settings.enabledPlugin"),
    WORLDS("settings.worlds"),
    WORLD_NAME("worldName"),
    TIME_ZONE("timeZone");

    private final String path;

    CfgKey(String path) {
        this.path = path;
    }

    public String path() {
        return path;
    }
}