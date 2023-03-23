package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Role;
import edu.miu.cs.cs544.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Role addOneRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateOneRoleByRoleId(Integer id, String name) {
        Role role = roleRepository.findById(id).get();
        role.setRoleName(name);
        return roleRepository.save(role);
    }

    @Override
    public String deleteOneRoleByRoleId(Integer id) {
        roleRepository.deleteById(id);
        return "200";
    }

    public Role getOneRoleByRoleId(Integer roleId) {
        return roleRepository.findById(roleId).get();
    }
}
