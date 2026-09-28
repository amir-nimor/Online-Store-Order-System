package ir.maktabsharif.controller.filter;

import ir.maktabsharif.model.Rols;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/admin")
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);

        if (session==null){
            response.sendError(404);
            return;
        }

        Rols rols = (Rols) session.getAttribute("rols");

        if (rols == Rols.ADMIN){
            filterChain.doFilter(request,response);
        }else {
            response.sendError(404);
        }

    }
}
