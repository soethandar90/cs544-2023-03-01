package edu.miu.cs.cs544.service.imp;

import edu.miu.cs.cs544.model.Member;
import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public void addOneNewMember(Member member) {

        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        memberRepository.save(member);
    }

    @Override
    public void updateOneMemberByMemberId(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void deleteOneMemberByMemberId(int id) {
        memberRepository.deleteById(id);
    }

    @Override
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> findOneMemberByMemberId(int id) {
        return memberRepository.findById(id);
    }


}
