package com.aman.blogapp.services.implementation;

import com.aman.blogapp.entities.Category;
import com.aman.blogapp.exceptions.ResourceNotFoundException;
import com.aman.blogapp.payload.CategoryDto;
import com.aman.blogapp.repositories.CategoryRepo;
import com.aman.blogapp.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepo categoryRepo;

    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepo categoryRepo, ModelMapper modelMapper){
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category=modelMapper.map(categoryDto,Category.class);
        Category addedCat = this.categoryRepo.save(category);

        return this.modelMapper.map(addedCat, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category=this.categoryRepo.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category","CategoryId",categoryId));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());

        Category updatedCat = this.categoryRepo.save(category);

        return this.modelMapper.map(updatedCat, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category ", "category id", categoryId));
        this.categoryRepo.delete(cat);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));

        return this.modelMapper.map(cat, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = this.categoryRepo.findAll();
        return categories.stream().map(cat -> this.modelMapper.map(cat, CategoryDto.class))
                .toList();
    }
}
