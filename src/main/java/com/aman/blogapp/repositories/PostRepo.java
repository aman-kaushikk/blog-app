package com.aman.blogapp.repositories;

import com.aman.blogapp.entities.Category;
import com.aman.blogapp.entities.Post;
import com.aman.blogapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    @Query("select a from Post a where a.title like :key")
    List<Post> searchByTitle(@Param("key") String title);
//    List<Post> findByTitleContaining(String title);
}
