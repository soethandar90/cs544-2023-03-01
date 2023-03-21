package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.dto.RoleDto;
import edu.miu.cs.cs544.model.Role;

import java.util.Optional;

public interface RoleService {
    public Role addOneRole(Role role);
    public Role updateOneRoleByRoleId(Integer id, String name);
    public String deleteOneRoleByRoleId(Integer id);
    public RoleDto getOneRoleByRoleId(Integer roleId);
}
