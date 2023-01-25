package com.tutorial.board.dto;

import com.tutorial.board.domain.entity.Member;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String password;
    private String name;
    private String role;
    private LocalDateTime createdDate;

    public Member toEntity() {
        Member build = Member.builder()
                .id(id)
                .password(password)
                .name(name)
                .role(role)
                .build();
        return build;
    }

    @Builder
    public MemberDto(Long id, String password, String name, String role, LocalDateTime createdDate) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.role = role;
        this.createdDate = createdDate;
    }
}