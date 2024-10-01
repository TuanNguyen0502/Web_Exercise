package vn.loh.services.impl;

import vn.loh.dao.ICategoryDao;
import vn.loh.dao.impl.CategoryDaoImpl;
import vn.loh.models.CategoryModel;
import vn.loh.services.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    private ICategoryDao categoryDao = new CategoryDaoImpl();

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
        CategoryModel categoryModel = categoryDao.findByName(category.getName());
        if (categoryModel == null) {
            categoryDao.insert(category);
        }
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
    public CategoryModel findByName(String name) { return categoryDao.findByName(name);}

    @Override
    public void updateStatus(int id, int status) {
        CategoryModel categoryModel = categoryDao.findByID(id);
        if (categoryModel != null) {
            categoryDao.updateStatus(id, status);
        }
    }
}
