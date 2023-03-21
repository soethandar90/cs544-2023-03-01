package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.LoginRequest;
import edu.miu.cs.cs544.model.LoginResponse;
import edu.miu.cs.cs544.model.RefreshTokenRequest;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
