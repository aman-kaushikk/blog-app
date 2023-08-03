package com.aman.blogapp.services;


import com.aman.blogapp.payload.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Integer postId);

	void deleteComment(Integer commentId);

}
