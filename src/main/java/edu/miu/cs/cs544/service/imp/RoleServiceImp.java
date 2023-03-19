package edu.miu.cs.cs544.service.imp;

import edu.miu.cs.cs544.model.Role;
import edu.miu.cs.cs544.repository.RoleRepository;
import edu.miu.cs.cs544.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
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
}
