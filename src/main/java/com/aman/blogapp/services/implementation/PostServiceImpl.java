package com.aman.blogapp.services.implementation;

import com.aman.blogapp.entities.Category;
import com.aman.blogapp.entities.Post;
import com.aman.blogapp.entities.User;
import com.aman.blogapp.exceptions.ResourceNotFoundException;
import com.aman.blogapp.payload.PostDto;
import com.aman.blogapp.repositories.CategoryRepo;
import com.aman.blogapp.repositories.PostRepo;
import com.aman.blogapp.repositories.UserRepo;
import com.aman.blogapp.services.PostService;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User ", "User id", userId));

        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "category id ", categoryId));

        Post post = this.modelMapper.map(postDto, Post.class);

        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = this.postRepo.save(post);

        return this.modelMapper.map(newPost, PostDto.class);

    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
        List<Post> posts = this.postRepo.findByCategory(category);

        List<PostDto> postDtos= posts.stream().map(post->this.modelMapper.map(post,PostDto.class)).toList();
        return postDtos;
    }
    @Override
    public List<PostDto> getPostsByUser(Integer userId) {
        User user=userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
        List<Post> posts= postRepo.findByUser(user);
        List<PostDto> postDtos=posts.stream().map(post -> this.modelMapper.map(post,PostDto.class)).toList();
        return postDtos;
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return null;
    }
}
