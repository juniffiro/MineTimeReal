package ua.juniffiro.ms.timereal.log;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 05/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class MyLogger {

    // Bukkit console sender
    public static ConsoleCommandSender LOGGER = Bukkit.getConsoleSender();

    public static void log(String message) {
        LOGGER.sendMessage(message);
    }

    public static void log(ChatColor color, String message) {
        LOGGER.sendMessage(String.format("%s%s", color, message));
    }

    public static void success(String message) {
        LOGGER.sendMessage(String.format("%s%s", ChatColor.GREEN, message));
    }

    public static void warn(String message) {
        LOGGER.sendMessage(String.format("%s%s", ChatColor.YELLOW, message));
    }

    public static void error(String message) {
        LOGGER.sendMessage(String.format("%s%s", ChatColor.RED, message));
    }
}
