package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Role;

public interface RoleService {
    Role addOneRole(Role role);

    Role updateOneRoleByRoleId(Integer id, String name);

    String deleteOneRoleByRoleId(Integer id);

    Role getOneRoleByRoleId(Integer roleId);
}
