package ir.maktabsharif.controller;

import ir.maktabsharif.model.Product;
import ir.maktabsharif.model.User;
import ir.maktabsharif.service.product.productServiceImpl;
import ir.maktabsharif.service.user.userServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "payment",value = "/payment")
public class payment extends HttpServlet {

    private userServiceImpl userService;
    private productServiceImpl productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.userService = (userServiceImpl) getServletContext().getAttribute("userService");
        this.productService = (productServiceImpl) getServletContext().getAttribute("productService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);


        List<Product>  products = (List<Product>) session.getAttribute("productList");

        for (Product p : products){
            p.setQuantity(p.getQuantity() -1);
            productService.update(p);
        }


        Double finalPrice = Double.parseDouble(req.getParameter("finalPrice"));
        Integer userId = Integer.parseInt(req.getParameter("userId"));
        User user = userService.findById(userId);

        user.setProducts(products);

        user.setBalance(user.getBalance().subtract(new BigDecimal(finalPrice)));

        userService.update(user);

        req.getRequestDispatcher("./pageHelp/paymentSucssesfuly.jsp").forward(req,resp);


    }
}
