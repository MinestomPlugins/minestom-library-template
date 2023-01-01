package me.window.permissions;

import net.minestom.server.entity.Player;

/**
 *
 *Easy methods for handling permissions.
 * <pre></pre>
 *See also: {@link GlobalPermissionProvider GlobalPermissionProvider}
 *
 */
public class PermissionProvider {

    /**
     * Permission
     */
    public String extensionPermission;
    /**
     *<pre>
     *The minimum permission level where the player bypasses permission check.
     *1-4, 5 to disable.
     *</pre> 
     */
    public int opLevel;

    /**
     * Creates a new PermissionProvider
     * @param extensionPermission The permission that this that will be checked
     */
    public PermissionProvider(String extensionPermission) {
        this.extensionPermission = extensionPermission;
        opLevel = 4;
    }
    /**
     * Creates a new PermissionProvider
     * @param opLevel The permission level where a player will be able to bypass permissions
     * @param extensionPermission The permission that this that will be checked
     */
    public PermissionProvider(int opLevel, String extensionPermission) {
        this.extensionPermission = extensionPermission;
        this.opLevel = opLevel;
    }
    
    /**
     * Replaces permission with new permissions
     * @param extensionPermission The new permissions
     */
    public void updatePermissions(String extensionPermission) {
        this.extensionPermission = extensionPermission;
        opLevel = 4;
    }
    /**
     * Replaces permission with new permissions
     * @param opLevel the new op level
     * @param extensionPermission The new permissions
     */
    public void updatePermissions(int opLevel, String extensionPermission) {
        this.extensionPermission = extensionPermission;
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
        return player.hasPermission(extensionPermission + ".*") || player.hasPermission(extensionPermission + "." + permission);
    }

    /**
     * Checks if the player has one of the provider permissions
     * @param player the player to check
     * @return if the player has permission
     */
    public boolean hasPermission(Player player) {
        if(player.hasPermission("*") || player.getPermissionLevel() >= opLevel) return true;
        return player.hasPermission(extensionPermission);
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
        return player.hasPermission(extensionPermission + ".*") || player.hasPermission(extensionPermission + "." + permission);
    }

    /**
     * Checks if the player has one of the provider permissions
     * @param player the player to check
     * @param opLevel override the default provider op level
     * @return if the player has permission
     */
    public boolean hasPermission(Player player, int opLevel) {
        if(player.hasPermission("*") || player.getPermissionLevel() >= opLevel) return true;
        return player.hasPermission(extensionPermission);
    }

}
