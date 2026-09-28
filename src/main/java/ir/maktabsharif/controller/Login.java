package ir.maktabsharif.controller;

import ir.maktabsharif.model.AddressUser;
import ir.maktabsharif.model.Rols;
import ir.maktabsharif.model.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.math.BigDecimal;

import ir.maktabsharif.service.user.userServiceImpl;


@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {

    private userServiceImpl userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.userService = (userServiceImpl) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("./page/Login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullname = req.getParameter("fullname");
        String phonenumber = req.getParameter("phonenumber");
        String city = req.getParameter("city");
        String street = req.getParameter("street");
        String postalcode = req.getParameter("zipcode");
        BigDecimal balance = BigDecimal.valueOf(Integer.parseInt(req.getParameter("balance")));

        Rols rols = Rols.USER;

        if (username.equals("admin")&&password.equals("admin")){
            rols = Rols.ADMIN;
        }

        User user = new User(fullname, phonenumber, new AddressUser(city, street, postalcode), balance, username, password);
        user.setRols(rols);

        HttpSession session = req.getSession();
        String Token = generatToken(username, password);

        session.setAttribute("username", username);
        session.setAttribute("password", password);
        session.setAttribute("Token", Token);
        session.setAttribute("fullname", fullname);
        session.setAttribute("phonenumber", phonenumber);
        session.setAttribute("city", city);
        session.setAttribute("street", street);
        session.setAttribute("postalcode", postalcode);
        session.setAttribute("rols", rols);
        session.setAttribute("balance", balance);


        Cookie cookie = new Cookie("Token", Token);

        resp.addCookie(cookie);

        userService.save(user);

        req.getRequestDispatcher("./pageHelp/LoginSuccessfully.jsp").forward(req, resp);


    }

    private String generatToken(String usename, String password) {
        return "TOKEN->" + usename + "=" + password;
    }
}
