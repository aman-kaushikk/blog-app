package com.aman.blogapp.repositories;

import com.aman.blogapp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
