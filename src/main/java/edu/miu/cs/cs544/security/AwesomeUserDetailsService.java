package edu.miu.cs.cs544.security;

import edu.miu.cs.cs544.model.Member;
import edu.miu.cs.cs544.repository.MemberRepository;
import lombok.var;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Transactional
public class AwesomeUserDetailsService implements UserDetailsService {

    private final MemberRepository userRepo;

    public AwesomeUserDetailsService(MemberRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return new AwesomeUserDetails(userRepo.findByEmail(username));
    }

}
