package me.window.permissions;

import net.minestom.server.entity.Player;

public class GlobalPermissionProvider {
    /**
     * Check if the player has a root permission. Uses op level 4 by default.
     * @param player the player
     * @param permission The permission to check
     * @return if the player has the permission
     */
    public static boolean hasPermission(Player player, String permission) {
        return player.hasPermission("*") || player.hasPermission(permission) || player.getPermissionLevel() >= 4;
    }

    /**
     * Check if the player has a root permission. 
     * @param player the player
     * @param permission The permission to check
     * @param opLevel the minimum op level where the player bypasses permission check. 
     * @return if the player has the permission
     */
    public static boolean hasPermission(Player player, String permission, int opLevel) {
        return player.hasPermission("*") || player.hasPermission(permission) || player.getPermissionLevel() >= opLevel;
    }
}
