package edu.miu.cs.cs544.service.imp;

import edu.miu.cs.cs544.dto.RoleDto;
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

    public RoleDto getOneRoleByRoleId(Integer roleId){
        //Role role = roleRepository.findById(roleId).get();
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new ResourceNotFoundException("Role", "roleId", roleId));
        RoleDto roleDto = this.modelMapper.map(role, RoleDto.class);
        return roleDto;
    }
}
