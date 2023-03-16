package ua.juniffiro.ms.timereal;

import org.bukkit.World;
import ua.juniffiro.ms.timereal.util.TimeUtil;

import java.time.ZoneId;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class TimeWorld {

    private World world;
    private ZoneId zoneId;

    public TimeWorld(World world, ZoneId zoneId) {
        this.world = world;
        this.zoneId = zoneId;
    }

    public void setRealTime() {
        world.setTime(TimeUtil.getTime(zoneId));
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }
}
