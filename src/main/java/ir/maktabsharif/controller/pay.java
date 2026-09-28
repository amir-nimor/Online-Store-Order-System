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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "pay",value = "/pay")
public class pay extends HttpServlet {

    private productServiceImpl productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.productService = (productServiceImpl) getServletContext().getAttribute("productService");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] productList = req.getParameterValues("ProductId");

        List<Long> ids = new ArrayList<>();

        for (String p : productList){
            ids.add(Long.valueOf(p));
        }

        List<Product> products = new ArrayList<>();
        for (Long i : ids){
            products.add(productService.findById(i));
        }

        req.setAttribute("productOrder",products);
        req.getRequestDispatcher("./calculate").forward(req,resp);
    }
}
