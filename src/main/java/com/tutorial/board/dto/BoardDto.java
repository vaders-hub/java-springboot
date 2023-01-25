package com.tutorial.board.dto;

import com.tutorial.board.domain.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private Long fileId;
    private String fileName;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Board toEntity() {
        Board build = Board.builder()
                .id(id)
                .author(author)
                .title(title)
                .content(content)
                .fileId(fileId)
                .fileName(fileName)
                .build();
        return build;
    }

    @Builder
    public BoardDto(Long id, String author, String title, String content, Long fileId, String fileName, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.fileId = fileId;
        this.fileName = fileName;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}