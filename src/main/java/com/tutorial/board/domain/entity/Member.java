package com.tutorial.board.domain.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 100, nullable = false)
    private String password;
    @Column(length = 10, nullable = false)
    private String name;
    @Column(length = 20, nullable = false)
    private String role;
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @Builder
    public Member(Long id, String password, String name, String role) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.role = role;
    }
}
