package com.aman.blogapp.controllers;

import com.aman.blogapp.payload.PostDto;
import com.aman.blogapp.services.PostService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")

public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
                                              @PathVariable Integer categoryId){
        PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
    }

    @GetMapping("category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getCategoryPost(@PathVariable Integer categoryId){
        List<PostDto>postDtos =this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);

    }

    @GetMapping("user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getUserPost(@PathVariable Integer userId){
        List<PostDto> postDtos=this.postService.getPostsByUser(userId);
        return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);
    }


}
