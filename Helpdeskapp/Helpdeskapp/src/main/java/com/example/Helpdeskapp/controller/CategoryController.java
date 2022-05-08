package com.example.Helpdeskapp.controller;

import com.example.Helpdeskapp.model.CategoryModel;
import com.example.Helpdeskapp.service.CategoryServiceImpl;
import com.example.Helpdeskapp.service.CategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")

@RestController
@RequestMapping("/api/v1")
public class CategoryController {
    public CategoryServiceInterface categoryService;
    @Autowired
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryModel>> getAllCategories(){
        List<CategoryModel> categories= categoryService.findAllCategory();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryModel> getCategoryById(@PathVariable Long id){
        CategoryModel category =categoryService.findCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);

    }
    @PostMapping("/categories")
    public ResponseEntity<CategoryModel> createTicket(@RequestBody CategoryModel categoryModel){
        CategoryModel category=categoryService.AddCategory(categoryModel);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }
    @PutMapping("/categories/{id}")

    public ResponseEntity<CategoryModel> updateCategory(@PathVariable Long id, @RequestBody CategoryModel categoryDetails){
        CategoryModel C1=categoryService.updateCategory(id,categoryDetails);
        return   new ResponseEntity<>(C1,HttpStatus.OK);
    }
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteCategory(@PathVariable Long id){
        Map<String,Boolean> response=categoryService.deleteCategory(id);
        return  ResponseEntity.ok(response);
    }
}
