package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.contract.RoleDTO;
import edu.miu.cs.cs544.model.Role;

public interface RoleService {
    public Role addOneRole(Role role);
    public Role updateOneRoleByRoleId(Integer id, String name);
    public String deleteOneRoleByRoleId(Integer id);
    public Role getOneRoleByRoleId(Integer roleId);
}
