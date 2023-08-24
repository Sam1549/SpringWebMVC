package org.example.repository;

import org.example.exception.NotFoundException;
import org.example.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryStubImpl implements PostRepository {

    private final ConcurrentHashMap<Long, Post> posts;
    private final AtomicLong idCounter = new AtomicLong(0);

    public PostRepositoryStubImpl() {
        posts = new ConcurrentHashMap<>();
    }

    public List<Post> all() {
        return new ArrayList<>(posts.values().stream()
                .filter(v -> !v.isRemoved())
                .collect(Collectors.toList()));
    }

    public Optional<Post> getById(long id) {
       Optional<Post> post = posts.get(id).isRemoved() ? (Optional<Post>) Optional.empty().orElseThrow(NotFoundException::new) : Optional.ofNullable(posts.get(id));
        return post;
    }

    public Post save(Post post) {
        if (post.getId() != 0 && !posts.containsKey(post.getId())) {
            throw new NotFoundException();
        } else {
            if (posts.containsKey(post.getId())) {
                    posts.put(post.getId(), post);
                System.out.println(post.getContent());
            }
            if (post.getId() == 0) {
                post.setId(idCounter.incrementAndGet());
                posts.put(post.getId(), post);
                System.out.println(post.getContent());
            }
        }
        return post;
    }

    public Optional<Post> removeById(long id) {
        Optional<Post> post = Optional.ofNullable(posts.get(id));
        post.ifPresent(value -> value.setRemoved(true));
        return post;
    }
}
