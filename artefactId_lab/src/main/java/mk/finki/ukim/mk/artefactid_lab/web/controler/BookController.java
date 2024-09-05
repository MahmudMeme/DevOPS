package mk.finki.ukim.mk.artefactid_lab.web.controler;

import mk.finki.ukim.mk.artefactid_lab.model.Author;
import mk.finki.ukim.mk.artefactid_lab.model.Book;
import mk.finki.ukim.mk.artefactid_lab.model.BookStore;
import mk.finki.ukim.mk.artefactid_lab.model.Review;
import mk.finki.ukim.mk.artefactid_lab.service.AuthorService;
import mk.finki.ukim.mk.artefactid_lab.service.BookService;
import mk.finki.ukim.mk.artefactid_lab.service.BookStoreService;
import mk.finki.ukim.mk.artefactid_lab.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final BookStoreService bookStoreService;
    private final ReviewService reviewService;

    public BookController(BookService bookService,
                          AuthorService authorService,
                          BookStoreService bookStoreService,
                          ReviewService reviewService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.bookStoreService = bookStoreService;
        this.reviewService = reviewService;
    }

    @GetMapping
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.listBooks());
        model.addAttribute("bodyContent", "books");
        //return "test";
        return "master-template";
    }

    @GetMapping("/details/{id}")
    public String detailsBooks(@PathVariable Long id, Model model) {
        Optional<Book> book = bookService.findBookById(id);
        if (book.isPresent()) {
            model.addAttribute("currentBook", book.get());
            model.addAttribute("bodyContent", "bookDetailsC");
            return "master-template";
        }
        return "test";
    }

    @PostMapping("/add-author/{id}")
    public String addAuthorToBook(@PathVariable Long id, Model model) {
        List<Author> authorList = authorService.listAuthors();
        Optional<Book> book = bookService.findBookById(id);

        model.addAttribute("currentBooks", book.get());
        model.addAttribute("authorList", authorList);
        model.addAttribute("bodyContent", "add-author");

        return "master-template";
    }

    @PostMapping("/add")
    public String save(@RequestParam(required = false) String error, @RequestParam Long id, @RequestParam Long authorId) {
        bookService.addAuthorToBook(id, id);
        authorService.addBookToAuthor(authorId, authorId);
        return "redirect:/books";
    }

    @GetMapping("/edit-form/{id}")
    public String editBookPage(@PathVariable Long id, Model model) {
        List<Author> authorList = authorService.listAuthors();
        Optional<Book> book = bookService.findBookById(id);
        List<BookStore> bookStores = bookStoreService.findAll();
        model.addAttribute("currentBook", book.get());
        model.addAttribute("authorList", authorList);
        model.addAttribute("BookStoreList", bookStores);
        model.addAttribute("bodyContent", "edit-book");
        return "master-template";
    }

    @PostMapping("/editBook")
    public String saveEdited(@RequestParam(required = false) String error,
                             @RequestParam Long id,
                             @RequestParam String title,
                             @RequestParam String genre,
                             @RequestParam Integer year,
                             @RequestParam Long bookStore,
                             @RequestParam Long authorId) {
//        Optional<Book> book = bookService.findBookById(id);
//        Author author = authorService.findById(id);
//        BookStore bookStore1 = bookStoreService.findById(bookStore).get();
        bookService.editBook(id, title, genre, year, bookStore, authorId);
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@RequestParam(required = false) String error, @PathVariable Long id) {
        bookService.deleteByIsbn(id);
        return "redirect:/books";
    }

    @GetMapping("/addNewBook")
    public String addNewBook(@RequestParam(required = false) String error, Model model) {
        List<Author> authorList = authorService.listAuthors();
        List<BookStore> bookStores = bookStoreService.findAll();
        model.addAttribute("authorList", authorList);
        model.addAttribute("BookStoreList", bookStores);
        model.addAttribute("bodyContent", "add-book");
        return "master-template";
    }

    @PostMapping("/addBook")
    public String addBook(@RequestParam(required = false) String error,
                          // @RequestParam Long id,
                          @RequestParam String title,
                          @RequestParam String genre,
                          @RequestParam Integer year,
                          @RequestParam Long bookStore,
                          @RequestParam Long authorId) {
        bookService.addBook(title, genre, year, bookStore, authorId);

        return "redirect:/books";
    }

    @PostMapping("/copy/{id}")
    public String copyBook(@RequestParam(required = false) String error,
                           @PathVariable Long id) {
        //Optional<Book> book = bookService.findBookById(id);

        bookService.copyBook(id);
        return "redirect:/books";
    }

    @GetMapping("/addReview/{id}")
    public String addReview(@RequestParam(required = false) String error,
                            @PathVariable Long id, Model model) {
        Book book = bookService.findBookById(id).get();
        model.addAttribute("book", book);
        model.addAttribute("bodyContent", "add-review");
        return "master-template";
    }

    @PostMapping("/addReviewSave")
    public String saveAddedReview(@RequestParam(required = false) String error,
                                  @RequestParam Long id,
                                  @RequestParam Integer score,
                                  @RequestParam String description,
                                  @RequestParam LocalDateTime timestamp) {

        Book book = bookService.findBookById(id).get();
        reviewService.saveReview(score, description, book, timestamp);
        return "redirect:/books";
    }

    @GetMapping("/searchReviews/{id}")
    public String findBetween(@RequestParam(required = false) String error,
                              //@PathVariable Long id,
                              @RequestParam LocalDateTime timeFrom,
                              @RequestParam LocalDateTime timeTo,
                              Model model) {
       // Book book = bookService.findBookById(id).get();
        List<Review> reviews = reviewService.findAllByDateCreatedBetween(timeFrom, timeTo);
        model.addAttribute("reviews", reviews);
        model.addAttribute("bodyContent", "sortedReviews");
        return "master-template";

    }
}
