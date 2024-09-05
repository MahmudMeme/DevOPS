package mk.finki.ukim.mk.artefactid_lab.web.controler;

import mk.finki.ukim.mk.artefactid_lab.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping
    private String getAllAuthors(Model model){
        model.addAttribute("bodyContent", "authorsList");
        model.addAttribute("authors",authorService.listAuthors());
        return "master-template";
    }
    @GetMapping("/details/{id}")
    public String detailsAuthor(@PathVariable Long id, Model model){
        model.addAttribute("author",authorService.findById(id));
        model.addAttribute("bodyContent", "authorDetailsC");
        return "master-template";
    }
}
