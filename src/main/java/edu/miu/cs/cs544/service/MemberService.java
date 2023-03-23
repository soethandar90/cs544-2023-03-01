package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Member addOneNewMember(Member member);

    Member updateOneMemberByMemberId(Member member);

    void deleteOneMemberByMemberId(int id);

    List<Member> findAllMembers();

    Optional<Member> findOneMemberByMemberId(int id);

}
