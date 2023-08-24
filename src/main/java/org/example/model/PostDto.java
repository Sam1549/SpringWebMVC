package org.example.model;


import lombok.Data;


@Data
public class PostDto {
    private long id;
    private String content;

    public PostDto() {
    }

    public PostDto(long id, String content) {
        this.id = id;
        this.content = content;
    }
}
