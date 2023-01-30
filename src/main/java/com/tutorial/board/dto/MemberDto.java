package com.tutorial.board.dto;

import com.tutorial.board.domain.entity.Member;
import com.tutorial.board.domain.entity.Role;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {

    private Long seq;
    private String password;
    private String id;
    private Role role;
    private LocalDateTime createdDate;

    public Member toEntity() {
        Member build = Member.builder()
                .seq(seq)
                .password(password)
                .id(id)
                .role(role)
                .build();
        return build;
    }

    @Builder
    public MemberDto(Long seq, String password, String id, Role role, LocalDateTime createdDate) {

        this.seq = seq;
        this.password = password;
        this.id = id;
        this.role = role;
        this.createdDate = createdDate;
    }
}