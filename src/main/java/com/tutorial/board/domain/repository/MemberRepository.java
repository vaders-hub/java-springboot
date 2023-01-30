package com.tutorial.board.domain.repository;

import com.tutorial.board.domain.entity.Member;
import org.springframework.data.repository.CrudRepository;


public interface MemberRepository extends CrudRepository<Member, String> {

}