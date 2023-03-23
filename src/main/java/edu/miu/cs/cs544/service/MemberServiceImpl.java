package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Location;
import edu.miu.cs.cs544.model.Member;
import edu.miu.cs.cs544.repository.MemberRepository;
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
    public Member addOneNewMember(Member member) {
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        return memberRepository.save(member);
    }

    @Override
    public Member updateOneMemberByMemberId(int id, Member member) {

        Optional<Member> optionalMember = memberRepository.findById(id);
        if (!optionalMember.isPresent()) {
            System.err.println("Member not found with id " + id);
        }
        Member existingmember = optionalMember.get();

        // Update the existing Member with the new data
        if(member.getFirstName()!=null || member.getFirstName()==""){
            existingmember.setFirstName(member.getFirstName());
        }
        if(member.getLastName()!=null || member.getLastName()==""){
            existingmember.setLastName(member.getLastName());
        }
        if(member.getEmail()!=null || member.getEmail()==""){
            existingmember.setEmail(member.getEmail());
        }

        if(member.getPassword()!=null || member.getPassword()==""){
            existingmember.setPassword(member.getPassword());
        }

        if(member.getRole()!=null){
            existingmember.setRole(member.getRole());
        }

        if(member.getMembership()!=null){
            existingmember.setMembership(member.getMembership());
        }

        return memberRepository.save(existingmember);
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
