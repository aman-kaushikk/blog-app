package com.aman.blogapp.payload;

import com.aman.blogapp.entities.Category;
import com.aman.blogapp.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

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
}
