package com.aman.blogapp.payload;

import com.aman.blogapp.entities.Category;
import com.aman.blogapp.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private Integer postId;

    private String title;

    private String content;

    private String imageName;

    private Date addedDate;

    private Category category;

    private User user;
    private Set<CommentDto> comments=new HashSet<>();
}
