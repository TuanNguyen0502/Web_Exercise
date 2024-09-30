package vn.loh.controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.loh.models.CategoryModel;
import vn.loh.services.ICategoryService;
import vn.loh.services.impl.CategoryServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/categories", "/admin/category/add", "/admin/category/edit",
        "/admin/category/update", "/admin/category/delete", "/admin/category/search"})
public class CategoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public ICategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        if (url.contains("categories")) {
            showCategories(req, resp);
        } else if (url.contains("add")) {
            req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
        } else if (url.contains("category/edit")) {
            // Get id from url
            int id = Integer.parseInt(req.getParameter("id"));
            // Get data from database
            CategoryModel category = categoryService.findByID(id);
            // Set data to form
            req.setAttribute("category", category);
            req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        if (url.contains("add")) {
            addCategory(req, resp);
        } else if (url.contains("category/edit")) {
            editCategory(req, resp);
        }
    }

    private void editCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get data from form
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String image = "https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/t/e/text_ng_n_7__2_102.png";
        int status = Integer.parseInt(req.getParameter("status"));
        // Insert data to database
        CategoryModel category = new CategoryModel();
        category.setId(id);
        category.setName(name);
        category.setImage(image);
        category.setStatus(status);
        categoryService.update(category);

        showCategories(req, resp);
    }

    private void addCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get data from form
        String name = req.getParameter("name");
        String image = "https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/t/e/text_ng_n_7__2_102.png";
        int status = Integer.parseInt(req.getParameter("status"));
        // Insert data to database
        CategoryModel category = new CategoryModel();
        category.setName(name);
        category.setImage(image);
        category.setStatus(status);
        categoryService.insert(category);

        showCategories(req, resp);
    }

    private void showCategories(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CategoryModel> categories = categoryService.findAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/views/admin/categories.jsp").forward(req, resp);
    }
}
