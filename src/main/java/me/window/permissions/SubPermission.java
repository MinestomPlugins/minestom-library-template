package me.window.permissions;

import java.util.ArrayList;

/**
 *Subpermission of a {@link PermissionProvider PermissionProvider}
 */
public class SubPermission extends PermissionProvider {

    /**
     * THe parent permission.
     */
    public PermissionProvider parent;

    /**
     * Creates a new subpermission
     * @param parent The parent permission can be either a permission provider or a SubPermission
     * @param extensionPermissions The permissions that this that will be checked
     */
    public SubPermission(PermissionProvider parent, String... extensionPermissions) {
        ArrayList<String> permissions = new ArrayList<>();
        for(String perm1 : parent.extensionPermissions) {
            for(String perm2 : parent.extensionPermissions) {
                permissions.add(perm1 + perm2);
            }
        }
        this.extensionPermissions = permissions.toArray(new String[0]);
        opLevel = 4;
        this.parent = parent;
    }

    /**
     * Creates a new subpermission
     * @param parent The parent permission can be either a permission provider or a SubPermission
     * @param opLevel The permission level where a player will be able to bypass permissions
     * @param extensionPermissions The permissions that will be checked
     */
    public SubPermission(PermissionProvider parent, int opLevel, String... extensionPermissions) {
        ArrayList<String> permissions = new ArrayList<>();
        for(String perm1 : parent.extensionPermissions) {
            for(String perm2 : parent.extensionPermissions) {
                permissions.add(perm1 + perm2);
            }
        }
        this.extensionPermissions = permissions.toArray(new String[0]);
        this.opLevel = opLevel;
        this.parent = parent;
    }
}
