package com.tutorial.board.domain.repository;

import com.tutorial.board.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}