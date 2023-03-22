package edu.miu.cs.cs544.service.impl;

import edu.miu.cs.cs544.contract.RoleDTO;
import edu.miu.cs.cs544.exception.ResourceNotFoundException;
import edu.miu.cs.cs544.model.Role;
import edu.miu.cs.cs544.repository.RoleRepository;
import edu.miu.cs.cs544.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Role addOneRole(Role role) {
        //check role exist or not
//        Role role = new Role();
//        role.setRoleName(name);
        roleRepository.save(role);
        return role;
    }

    @Override
    public Role updateOneRoleByRoleId(Integer id, String name) {
        Role role = roleRepository.findById(id).get();
        role.setRoleName(name);
        roleRepository.save(role);
        return role;
    }

    @Override
    public String deleteOneRoleByRoleId(Integer id) {
        roleRepository.deleteById(id);
        return "200";
    }

    public Role getOneRoleByRoleId(Integer roleId){
        Role role = roleRepository.findById(roleId).get();
        //Role role = roleRepository.findById(roleId).orElseThrow(() -> new ResourceNotFoundException("Role", "roleId", roleId));
     //   RoleDTO roleDto = this.modelMapper.map(role, Role.class);
        return role;
    }
}
