package me.window.permissions;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.minestom.server.adventure.audience.Audiences;
import net.minestom.server.entity.Player;
import net.minestom.server.extensions.Extension;

public class PermissionProvider {

    public String[] extensionPermissions;
    public int opLevel;

    /**
     * Creates a new PermissionProvider
     * @param extensionPermissions The permissions that this that will be checked
     */
    public PermissionProvider(String... extensionPermissions) {
        this.extensionPermissions = extensionPermissions;
        opLevel = 4;
    }
    /**
     * Creates a new PermissionProvider
     * @param opLevel The permission level where a player will be able to bypass permissions
     * @param extensionPermissions The permissions that this that will be checked
     */
    public PermissionProvider(int opLevel, String... extensionPermissions) {
        this.extensionPermissions = extensionPermissions;
        this.opLevel = opLevel;
    }
    
    /**
     * Replaces permission with new permissions
     * @param extensionPermissions The new permissions
     */
    public void updatePermissions(String... extensionPermissions) {
        this.extensionPermissions = extensionPermissions;
        opLevel = 4;
    }
    /**
     * Replaces permission with new permissions
     * @param opLevel the new op level
     * @param extensionPermissions The new permissions
     */
    public void updatePermissions(int opLevel, String... extensionPermissions) {
        this.extensionPermissions = extensionPermissions;
        this.opLevel = opLevel;
    }

    /**
     * Checks if the player has a subpermission
     * @param player the player to check
     * @param permission the permission
     * @return if the player has the permission
     */
    public boolean hasPermission(Player player, String permission) {
        if (player.hasPermission("*")|| player.getPermissionLevel() >= opLevel)
            return true;
        for(String perm : extensionPermissions) {
            if(player.hasPermission(perm + ".*") || player.hasPermission(perm + "." + permission)) return true;
        }
        return false;
    }

    /**
     * Checks if the player has one of the provider permissions
     * @param player the player to check
     * @return if the player has permission
     */
    public boolean hasPermission(Player player) {
        if(player.hasPermission("*") || player.getPermissionLevel() >= opLevel) return true;
        for(String perm : extensionPermissions) {
            if(player.hasPermission(perm)) return true;
        }
        return false;
    }

    /**
     * Checks if the player has a subpermission
     * @param player the player to check
     * @param permission the permission
     * @param opLevel override the default provider op level
     * @return if the player has the permission
     */
    public boolean hasPermission(Player player, String permission, int opLevel) {
        if (player.hasPermission("*")|| player.getPermissionLevel() >= opLevel)
            return true;
        for(String perm : extensionPermissions) {
            if(player.hasPermission(perm + ".*") || player.hasPermission(perm + "." + permission)) return true;
        }
        return false;
    }

    /**
     * Checks if the player has one of the provider permissions
     * @param player the player to check
     * @param opLevel override the default provider op level
     * @return if the player has permission
     */
    public boolean hasPermission(Player player, int opLevel) {
        if(player.hasPermission("*") || player.getPermissionLevel() >= opLevel) return true;
        for(String perm : extensionPermissions) {
            if(player.hasPermission(perm)) return true;
        }
        return false;
    }

}
