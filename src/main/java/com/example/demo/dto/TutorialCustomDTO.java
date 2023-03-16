package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TutorialCustomDTO {

    private Integer id;

    private String title;

    private String description;

    private int level;

    private boolean published;

    private String author_name;

    public TutorialCustomDTO(Integer id, String title, int level, String description, boolean published, String author_name) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.level = level;
        this.published = published;
        this.author_name = author_name;
    }
}
