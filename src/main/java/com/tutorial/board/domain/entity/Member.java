package com.tutorial.board.domain.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id
    @GeneratedValue
    private Long seq;
    @Column(length = 100, nullable = false)
    private String password;
    @Column(length = 10, nullable = false)
    private String id;
    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

    @Builder
    public Member(Long seq, String password, String id, Role role) {
        this.seq = seq;
        this.password = password;
        this.id = id;
        this.role = role;
    }
}
