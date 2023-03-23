package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Member;
import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.security.JwtHelper;
import edu.miu.cs.cs544.model.LoginRequest;
import edu.miu.cs.cs544.model.LoginResponse;
import edu.miu.cs.cs544.model.LoginResponseMember;
import edu.miu.cs.cs544.model.RefreshTokenRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtHelper jwtHelper;
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public LoginResponseMember login(LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }

        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail());
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        Member member = memberRepository.findByEmail(loginRequest.getEmail());
        return new LoginResponseMember(accessToken, refreshToken, member.getMemberId());
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtHelper.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            final String accessToken = jwtHelper.generateToken(jwtHelper.getSubject(refreshTokenRequest.getRefreshToken()));
            return new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
        }
        return new LoginResponse();
    }
}
