package org.example.mapping;

import org.example.model.Post;
import org.example.model.PostDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostDto PostToPostDTO(Post post);
    Post PostDtoToPost(PostDto postDto);
    List<PostDto> PostToPostDTO(List<Post> list);
}
