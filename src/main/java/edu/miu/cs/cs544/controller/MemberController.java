package edu.miu.cs.cs544.controller;

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
    public void addOneNewMember(@RequestBody Member member) {
        memberService.addOneNewMember(member);
    }

    @PutMapping("/{id}")
    public void updateOneMemberByMemberId(@RequestBody Member member, @PathVariable String id) {
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

    @GetMapping("/{memberId}/memberships")
    public Optional<List<Membership>> findAllMembershipsOfOneMemberByMemberId(@PathVariable int memberId) {
        return membershipService.findAllMembershipsOfOneMemberByMemberId(memberId);
    }

    @GetMapping("/{memberId}/badges")
    public List<Badge> findAllBadgesOfOneMemberByMemberId(@PathVariable int memberId) {
        return badgeService.findAllBadgesOfOneMemberByMemberId(memberId);
    }

    @GetMapping("/{memberId}/plans")
    public List<MembershipPlan> findAllPlansOfOneMemberByMemberId(@PathVariable int memberId) {
        return membershipPlanService.findAllMembershipPlanOfmemberByMemberId(memberId);
    }

    @GetMapping("/{memberId}/transactions")
    public Optional<List<BadgeTransaction>> findAllTransactionsOfOneMemberByMemberId(@PathVariable int memberId) {
        return badgeTransactionService.findAllBadgeTransactionByMemberId(memberId);
    }

}