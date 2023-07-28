package com.aman.blogapp.services;

import com.aman.blogapp.entities.Post;
import com.aman.blogapp.payload.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

    //update

    PostDto updatePost(PostDto postDto, Integer postId);

    // delete

    void deletePost(Integer postId);

    //get all posts

//    PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
    List<Post> getAllPost();

    //get single post

    PostDto getPostById(Integer postId);

    //get all posts by category

    List<PostDto> getPostsByCategory(Integer categoryId);

    //get all posts by user
    List<PostDto> getPostsByUser(Integer userId);

    //search posts
    List<PostDto> searchPosts(String keyword);

}
