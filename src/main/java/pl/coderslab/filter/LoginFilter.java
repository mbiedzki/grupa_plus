package pl.coderslab.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(urlPatterns = {"/address/*", "/admin/*", "/company/*", "/contract/*", "/group/*",
        "/mainCover/*", "/product/*", "/rider/*", "/user/*"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        boolean loggedIn = (session != null) && (session.getAttribute("loggedUserType").equals("admin"));

        if (loggedIn) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect("/home");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}



