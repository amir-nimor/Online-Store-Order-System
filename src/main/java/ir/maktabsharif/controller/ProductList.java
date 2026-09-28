package ir.maktabsharif.controller;

import ir.maktabsharif.model.Product;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ir.maktabsharif.service.product.productServiceImpl;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "productList",value = "/productList")
public class ProductList extends HttpServlet {

    private productServiceImpl productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.productService = (productServiceImpl) getServletContext().getAttribute("productService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = productService.findAll();

        req.setAttribute("products",productList);

        req.getRequestDispatcher("./page/productList.jsp").forward(req,resp);
    }
}
