package ir.maktabsharif.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebFilter(urlPatterns = {
        "/Profile",
        "/productList"
})
public class AuthFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendError(404);
            return;
        }
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        Cookie[] cookies = request.getCookies();

        String token = null;

        for (Cookie c : cookies) {
            if (c.getName().equals("Token")) {
                token = c.getValue();
            }
        }

        try {
            if (token != null) {
                if (token.contains(username) && token.contains(password)){
                    filterChain.doFilter(request,response);
                }
            }else {
                response.sendError(404);
            }
        }catch (NullPointerException e){
            response.sendError(404);
        }

    }
}
