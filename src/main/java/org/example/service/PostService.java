package org.example.service;

import org.example.exception.NotFoundException;
import org.example.model.Post;
import org.example.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> all() {
        return postRepository.all();
    }

    public Post getById(long id) {
        return postRepository.getById(id).orElseThrow(NotFoundException::new);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void removeById(long id) {
        postRepository.removeById(id);
    }
}
