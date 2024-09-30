package vn.loh.services.impl;

import vn.loh.dao.ICategoryDao;
import vn.loh.dao.impl.CategoryDaoImpl;
import vn.loh.models.CategoryModel;
import vn.loh.services.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    ICategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<CategoryModel> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public CategoryModel findByID(int id) {
        return categoryDao.findByID(id);
    }

    @Override
    public void insert(CategoryModel category) {
        categoryDao.insert(category);
    }

    @Override
    public void update(CategoryModel category) {
        CategoryModel categoryModel = categoryDao.findByID(category.getId());
        if (categoryModel != null) {
            categoryDao.update(category);
        }
    }

    @Override
    public void delete(int id) {
        CategoryModel categoryModel = categoryDao.findByID(id);
        if (categoryModel != null) {
            categoryDao.delete(id);
        }
    }

    @Override
    public List<CategoryModel> findByName(String name) {
        return categoryDao.findByName(name);
    }
}
