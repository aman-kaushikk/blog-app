package com.aman.blogapp.controllers;

import com.aman.blogapp.payload.ApiResponse;
import com.aman.blogapp.payload.CategoryDto;
import com.aman.blogapp.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createdCategory=this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createdCategory,HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updteCategory(@Valid @RequestBody CategoryDto categoryDto,
                                                     @PathVariable Integer categoryId){
        CategoryDto updatedCategory=this.categoryService.updateCategory(categoryDto,categoryId);
        return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
    this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true),
                HttpStatus.OK);
    }

    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId) {

        CategoryDto categoryDto = this.categoryService.getCategory(catId);

        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);

    }

    // get all
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories() {
        List<CategoryDto> categories = this.categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }


}
