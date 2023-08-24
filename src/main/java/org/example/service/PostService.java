package org.example.service;

import org.example.exception.NotFoundException;
import org.example.mapping.PostMapper;
import org.example.model.Post;
import org.example.model.PostDto;
import org.example.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
        this.postMapper = PostMapper.INSTANCE;
    }

    public List<PostDto> all() {
        return postMapper.PostToPostDTO(postRepository.all());
    }

    public PostDto getById(long id) {
        return postMapper.PostToPostDTO(postRepository.getById(id).orElseThrow(NotFoundException::new));
    }

    public PostDto save(PostDto postDto) {
        return postMapper.PostToPostDTO(postRepository.save(postMapper.PostDtoToPost(postDto)));
    }

    public PostDto removeById(long id) {
        return postMapper.PostToPostDTO(postRepository.removeById(id).orElseThrow(NotFoundException::new));
    }
}
