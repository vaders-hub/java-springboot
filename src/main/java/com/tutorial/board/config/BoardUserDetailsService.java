package com.tutorial.board.config;

import com.tutorial.board.domain.entity.Member;
import com.tutorial.board.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository MemberRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username" + username);
        Optional<Member> optional = MemberRepo.findById(username);

        if (!optional.isPresent()) {
            throw new UsernameNotFoundException(username + " doesn't exist");
        } else {
            Member member = optional.get();
            return new SecurityUser(member);
        }
    }
}
