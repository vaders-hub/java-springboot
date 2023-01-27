package com.tutorial.board.service;

import com.tutorial.board.domain.entity.Member;
import com.tutorial.board.domain.repository.MemberRepository;
import com.tutorial.board.dto.MemberDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private MemberRepository MemberRepository;

    public MemberService(MemberRepository MemberRepository) {
        this.MemberRepository = MemberRepository;
    }

    @Transactional
    public String addMember(MemberDto memberDto) {
        return MemberRepository.save(memberDto.toEntity()).getId();
    }

    public Member getMember(Member member) {
        String memberId = member.getId();
        Optional<Member> findMember = MemberRepository.findById(memberId);

        if (findMember.isPresent())
            return findMember.get();
        else return null;
    }

    @Transactional
    public List<MemberDto> getMemberList() {
        List<Member> memberList = MemberRepository.findAll();
        List<MemberDto> memberDtoList = new ArrayList<>();

        for (Member member : memberList) {
            MemberDto memberDto = MemberDto.builder()
                    .id(member.getId())
                    .password(member.getPassword())
                    .name(member.getName())
                    .role(member.getRole())
                    .createdDate(member.getCreatedDate())
                    .build();
            memberDtoList.add(memberDto);
        }
        return memberDtoList;
    }

    @Transactional
    public void deleteUser(String id) {
        MemberRepository.deleteById(id);
    }
}