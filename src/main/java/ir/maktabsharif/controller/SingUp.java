package ir.maktabsharif.controller;

import ir.maktabsharif.exception.HibernateException;
import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.model.User;
import ir.maktabsharif.service.user.userServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "signUp", value = "/singUp")
public class SingUp extends HttpServlet {

    private userServiceImpl userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.userService = (userServiceImpl) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Cookie[] cookies = req.getCookies();

        String token = null;

        String username = null;
        String password = null;

        for (Cookie c : cookies) {
            if (c.getName().equals("Token")) {
                token = c.getValue();
            }
        }


        if (token != null) {
            //AI
            //=================================
            String content = token.substring(7);
            int equalsIndex = content.indexOf('=');
            if (equalsIndex != -1) {
                username = content.substring(0, equalsIndex);
                password = content.substring(equalsIndex + 1);
            }else {
                req.getRequestDispatcher("./Login").forward(req, resp);
            }

            //=================================
        }else {
            req.getRequestDispatcher("./Login").forward(req, resp);
        }

        try {
            if (username != null && password != null) {
                User user = userService.findByUsernameAndPassword(username,password);
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                session.setAttribute("Token", token);
                session.setAttribute("fullname", user.getFullName());
                session.setAttribute("phonenumber", user.getPhoneNumber());
                session.setAttribute("city", user.getAddressUser().getCity());
                session.setAttribute("street", user.getAddressUser().getStreet());
                session.setAttribute("postalcode", user.getAddressUser().getPostalCode());
                session.setAttribute("balance", user.getBalance());
                req.getRequestDispatcher("./pageHelp/SingUpSuccessfully.jsp").forward(req, resp);
            }else {
                req.getRequestDispatcher("./Login").forward(req, resp);
            }
        }catch (RepositoryException e){
            req.getRequestDispatcher("./Login").forward(req, resp);
        }


    }
}
