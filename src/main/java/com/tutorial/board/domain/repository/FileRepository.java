package com.tutorial.board.domain.repository;

import com.tutorial.board.domain.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}