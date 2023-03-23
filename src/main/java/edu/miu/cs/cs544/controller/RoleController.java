package edu.miu.cs.cs544.controller;


import edu.miu.cs.cs544.model.Role;
import edu.miu.cs.cs544.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RoleService roleService;
    @GetMapping("/{roleId}")
    public Role getOneRoleByRoleId(@PathVariable("roleId") Integer roleId){
        return roleService.getOneRoleByRoleId(roleId);
    }
    @PostMapping("/")
    public Role addOneRole(@RequestBody Role role) {
        roleService.addOneRole(role);

        return role;
    }
    @PutMapping("/{id}")
    public Role updateOneRoleByRoleId(@PathVariable Integer id,@RequestParam String name) {
        return roleService.updateOneRoleByRoleId(id,name);
    }
    @DeleteMapping("/{id}")
    public String deleteOneRoleByRoleId(@PathVariable Integer id){
        return roleService.deleteOneRoleByRoleId(id);
    }


}
