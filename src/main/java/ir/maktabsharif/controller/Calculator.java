package ir.maktabsharif.controller;

import ir.maktabsharif.model.Product;
import ir.maktabsharif.model.User;
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
import java.util.List;


@WebServlet(name = "calculate", value = "/calculate")
public class Calculator extends HttpServlet {

    private userServiceImpl userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.userService = (userServiceImpl) getServletContext().getAttribute("userService");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        User user  = userService.findByUsernameAndPassword(username,password);


        BigDecimal balance = user.getBalance();

        List<Product> products = (List<Product>) req.getAttribute("productOrder");

        BigDecimal totalPrice =
                (BigDecimal) products.stream()
                        .map(p -> p.getPrice())
                        .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal discount = new BigDecimal("0.9");

        BigDecimal finalPrice = totalPrice.multiply(discount);

        req.setAttribute("balance",balance);
        req.setAttribute("totalPrice",totalPrice);
        req.setAttribute("finalPrice",finalPrice);
        req.setAttribute("discount",discount);
        req.setAttribute("productList",products);
        req.setAttribute("userId",user.getId());


        if (finalPrice.compareTo(balance) > 0){
            resp.sendError(404);
            return;
        }

        req.getRequestDispatcher("./page/payment.jsp").forward(req,resp);
    }
}
