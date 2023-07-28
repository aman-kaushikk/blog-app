package com.aman.blogapp.repositories;

import com.aman.blogapp.entities.Category;
import com.aman.blogapp.entities.Post;
import com.aman.blogapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
