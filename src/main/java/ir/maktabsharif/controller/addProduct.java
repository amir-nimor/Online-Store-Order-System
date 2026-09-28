package ir.maktabsharif.controller;

import ir.maktabsharif.model.Product;
import ir.maktabsharif.service.product.productServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;


@WebServlet(name = "addProduct",value = "/addProduct")
public class addProduct extends HttpServlet {

    private productServiceImpl productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.productService = (productServiceImpl) getServletContext().getAttribute("productService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("./page/addProduct.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = (String) req.getParameter("product_name");
        BigDecimal price = new BigDecimal(req.getParameter("product_price"));
        Integer quantity = Integer.parseInt(req.getParameter("product_quantity"));
        String description = (String) req.getParameter("product_description");

        Product product = new Product(title,description,price,quantity);

        productService.save(product);
    }
}
