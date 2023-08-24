package org.example.controller;

import org.example.model.Post;
import org.example.model.PostDto;
import org.example.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDto> all() {
        return postService.all();
    }

    @GetMapping("/{id}")
    public PostDto getById(@PathVariable long id) {
        return postService.getById(id);
    }

    @PostMapping
    public PostDto save(@RequestBody PostDto postDto) {
        return postService.save(postDto);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable long id) {
        postService.removeById(id);
    }
}
