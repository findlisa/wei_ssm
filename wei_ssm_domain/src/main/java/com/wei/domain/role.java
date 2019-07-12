package com.wei.domain;

import java.util.List;

public class role {
    private String id;
    private String roleName;
    private String roleDesc;
    private List<permission> permissions;
    private List<userInfo> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<permission> permissions) {
        this.permissions = permissions;
    }

    public List<userInfo> getUsers() {
        return users;
    }

    public void setUsers(List<userInfo> users) {
        this.users = users;
    }
}
