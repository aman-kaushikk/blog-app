package com.aman.blogapp.repositories;

import com.aman.blogapp.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
