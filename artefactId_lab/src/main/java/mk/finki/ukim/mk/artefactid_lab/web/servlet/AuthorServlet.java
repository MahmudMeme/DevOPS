package mk.finki.ukim.mk.artefactid_lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import mk.finki.ukim.mk.artefactid_lab.model.Author;
import mk.finki.ukim.mk.artefactid_lab.model.Book;
import mk.finki.ukim.mk.artefactid_lab.service.AuthorService;
import mk.finki.ukim.mk.artefactid_lab.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "authorServlet", urlPatterns = "/servlet/author")
@AllArgsConstructor
public class AuthorServlet extends HttpServlet {

    private final AuthorService authorService;
    private final BookService bookService;
    private final SpringTemplateEngine templateEngine;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange iWebExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(iWebExchange);

        context.setVariable("authors", authorService.listAuthors());
        templateEngine.process("authorList.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String inforadio=req.getParameter("infoID");
//        String authorIDElse=req.getParameter("authorId");
//        if (inforadio!=null) {//req.getParameter("infoID").isEmpty() || req.getParameter("infoID")==null
//            Author authorInfo = authorService.findById(Long.parseLong(req.getParameter("infoID")));
//
//            req.getSession().setAttribute("books",authorInfo.getBookList());
//            req.getSession().setAttribute("authorInfo",authorInfo);
//            resp.sendRedirect("/authorDetails");
//        } else {
//            Author author = authorService.findById(Long.parseLong(req.getParameter("authorId")));
//            req.getSession().setAttribute("selectedAuthor", author);
//            String Idbn = req.getSession().getAttribute("currentIsbn").toString();
//            Optional<Book> book = bookService.findBookById(Idbn);
//            req.getSession().setAttribute("currentBook", book.get());
//            bookService.addAuthorToBook(author.getId(), Idbn);
//            authorService.addBookToAuthor(author.getId(),Idbn);
//            resp.sendRedirect("/bookDetails");
//        }
    }
}
