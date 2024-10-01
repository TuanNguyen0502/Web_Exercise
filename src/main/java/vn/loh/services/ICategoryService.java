package vn.loh.services;

import vn.loh.models.CategoryModel;

import java.util.List;

public interface ICategoryService {
    List<CategoryModel> findAll();
    CategoryModel findByID(int id);
    void insert(CategoryModel category);
    void update(CategoryModel category);
    void delete(int id);
    CategoryModel findByName(String name);
    void updateStatus(int id, int status);
}
