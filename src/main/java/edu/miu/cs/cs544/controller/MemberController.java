package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.model.Member;
import edu.miu.cs.cs544.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/{id}")
    public Optional<Member> findOneMemberByMemberId(@PathVariable int id) {
        return memberService.findOneMemberByMemberId(id);
    }

    @PostMapping
    public void addOneNewMember(@RequestBody Member member) {
        memberService.addOneNewMember(member);
    }

    @PutMapping("/{id}")
    public void updateOneMemberByMemberId(@RequestBody Member member) {
        memberService.updateOneMemberByMemberId(member);
    }

    @DeleteMapping("/{id}")
    public void deleteOneMemberByMemberId(@PathVariable int id) {
        memberService.deleteOneMemberByMemberId(id);
    }

    @GetMapping
    public List<Member> findAllMembers() {
        return memberService.findAllMembers();

    }
}
