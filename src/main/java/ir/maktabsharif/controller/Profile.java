package ir.maktabsharif.controller;

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

@WebServlet(name = "Profile", value = "/Profile")
public class Profile extends HttpServlet {


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
        String fullname = (String) session.getAttribute("fullname");
        String phonenumber = (String) session.getAttribute("phonenumber");
        String city = (String) session.getAttribute("city");
        String street = (String) session.getAttribute("street");
        String postalcode = (String) session.getAttribute("postalcode");
        BigDecimal balance = (BigDecimal) session.getAttribute("balance");



        req.setAttribute("username", username);
        req.setAttribute("password", password);
        req.setAttribute("fullname", fullname);
        req.setAttribute("phonenumber", phonenumber);
        req.setAttribute("city", city);
        req.setAttribute("street", street);
        req.setAttribute("postalcode", postalcode);
        req.setAttribute("balance", balance);

        req.getRequestDispatcher("./page/Profile.jsp").forward(req,resp);


    }
}
