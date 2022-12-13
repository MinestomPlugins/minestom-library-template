package me.window.permissions;

import java.util.ArrayList;

public class SubPermission extends PermissionProvider {

    PermissionProvider parent;

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
    public SubPermission(PermissionProvider parent, int opLevel, String... extensionPermission) {
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
