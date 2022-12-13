package me.window.permissions;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.minestom.server.adventure.audience.Audiences;
import net.minestom.server.entity.Player;
import net.minestom.server.extensions.Extension;

public class PermissionProvider {

    String[] extensionPermissions;
    int opLevel;

    public PermissionProvider(String... extensionPermissions) {
        this.extensionPermissions = extensionPermissions;
        opLevel = 4;
    }
    public PermissionProvider(int opLevel, String... extensionPermission) {
        this.extensionPermissions = extensionPermission;
        this.opLevel = opLevel;
    }
    
    public void updatePermissions(String... extensionPermissions) {
        this.extensionPermissions = extensionPermissions;
        opLevel = 4;
    }
    public void updatePermissions(int opLevel, String... extensionPermission) {
        this.extensionPermissions = extensionPermission;
        this.opLevel = opLevel;
    }

    public boolean hasExtensionPermission(Player player, String permission) {
        if (player.hasPermission("*")|| player.getPermissionLevel() >= opLevel)
            return true;
        for(String perm : extensionPermissions) {
            if(player.hasPermission(perm + ".*") || player.hasPermission(perm + "." + permission)) return true;
        }
        return false;
    }

    public boolean hasExtensionPermission(Player player) {
        if(player.hasPermission("*") || player.getPermissionLevel() >= opLevel) return true;
        for(String perm : extensionPermissions) {
            if(player.hasPermission(perm)) return true;
        }
        return false;
    }

    public static boolean hasPermission(Player player, String permission) {
        return player.hasPermission("*") || player.hasPermission(permission) || player.getPermissionLevel() >= 4;
    }

    public static boolean hasPermission(Player player, String permission, int opLevel) {
        return player.hasPermission("*") || player.hasPermission(permission) || player.getPermissionLevel() >= opLevel;
    }

}
