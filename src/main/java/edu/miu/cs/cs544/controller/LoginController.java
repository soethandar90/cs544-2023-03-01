package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.model.LoginRequest;
import edu.miu.cs.cs544.model.LoginResponse;
import edu.miu.cs.cs544.model.RefreshTokenRequest;
import edu.miu.cs.cs544.service.LoginService;
import lombok.var;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    private final LoginService uaaService;

    public LoginController(LoginService uaaService) {
        this.uaaService = uaaService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = uaaService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return uaaService.refreshToken(refreshTokenRequest);
    }

}
