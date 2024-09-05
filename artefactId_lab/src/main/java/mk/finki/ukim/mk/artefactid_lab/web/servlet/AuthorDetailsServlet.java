package mk.finki.ukim.mk.artefactid_lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import mk.finki.ukim.mk.artefactid_lab.service.AuthorService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "authorDetails",urlPatterns = "/servlet/authorDetails")
@AllArgsConstructor
public class AuthorDetailsServlet extends HttpServlet {

    private final AuthorService authorService;
    private final SpringTemplateEngine templateEngine;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange iWebExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(iWebExchange);
        //context.setVariable("id",authorService.)
        templateEngine.process("authorInfo.html",context,resp.getWriter());
    }

}
