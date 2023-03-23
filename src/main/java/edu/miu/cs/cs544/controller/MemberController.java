package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.contract.BadgeDTO;
import edu.miu.cs.cs544.model.*;
import edu.miu.cs.cs544.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MembershipService membershipService;
    @Autowired
    private BadgeService badgeService;
    @Autowired
    private MembershipPlanService membershipPlanService;
    @Autowired
    private BadgeTransactionService badgeTransactionService;


    @GetMapping("/{id}")
    public Optional<Member> findOneMemberByMemberId(@PathVariable int id) {
        return memberService.findOneMemberByMemberId(id);
    }

    @PostMapping
    public Member addOneNewMember(@RequestBody Member member) {
        return memberService.addOneNewMember(member);
    }

    @PutMapping("/{id}")
    public Member updateOneMemberByMemberId(@PathVariable int id, @RequestBody Member member) {
        return memberService.updateOneMemberByMemberId(id, member);
    }

    @DeleteMapping("/{id}")
    public void deleteOneMemberByMemberId(@PathVariable int id) {
        memberService.deleteOneMemberByMemberId(id);
    }

    @GetMapping
    public List<Member> findAllMembers() {
        return memberService.findAllMembers();

    }

    @GetMapping("/{memberId}/memberships")
    public Optional<List<Membership>> findAllMembershipsOfOneMemberByMemberId(@PathVariable int memberId) {
        return membershipService.findAllMembershipsOfOneMemberByMemberId(memberId);
    }

    @GetMapping("/{memberId}/badges")
    public List<BadgeDTO> findAllBadgesOfOneMemberByMemberId(@PathVariable int memberId) {
        return badgeService.findAllBadgesOfOneMemberByMemberId(memberId);
    }

    @GetMapping("/{memberId}/plans")
    public List<MembershipPlan> findAllPlansOfOneMemberByMemberId(@PathVariable int memberId) {
        return membershipPlanService.findAllMembershipPlanOfMemberByMemberId(memberId);
    }

    @GetMapping("/{memberId}/transactions")
    public Optional<List<BadgeTransaction>> findAllTransactionsOfOneMemberByMemberId(@PathVariable int memberId) {
        return badgeTransactionService.findAllBadgeTransactionByMemberId(memberId);
    }

}