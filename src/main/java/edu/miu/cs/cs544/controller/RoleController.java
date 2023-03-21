package edu.miu.cs.cs544.controller;


import edu.miu.cs.cs544.dto.RoleDto;
import edu.miu.cs.cs544.model.Role;
import edu.miu.cs.cs544.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RoleService roleService;

    @PostMapping("/")
    public Role addOneRole(@RequestBody Role role) {
        roleService.addOneRole(role);

        return role;
    }
    @PutMapping("/{id}")
    public Role updateOneRoleByRoleId(@PathVariable Integer id,@RequestParam String name) {
        Role role = roleService.updateOneRoleByRoleId(id,name);

        return role;
    }
    @DeleteMapping("/{id}")
    public String deleteOneRoleByRoleId(@PathVariable Integer id){
        return roleService.deleteOneRoleByRoleId(id);
    }

    @GetMapping("/roleId")
    public ResponseEntity<RoleDto> getOneRoleByRoleId(@PathVariable("roleId") Integer roleId){
        RoleDto roleDto = this.roleService.getOneRoleByRoleId(roleId);
        return new ResponseEntity<RoleDto>(roleDto, HttpStatus.OK);
    }
}
