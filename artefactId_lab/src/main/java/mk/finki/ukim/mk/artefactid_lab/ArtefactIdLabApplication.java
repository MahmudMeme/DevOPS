package mk.finki.ukim.mk.artefactid_lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScans;

@ServletComponentScan
@SpringBootApplication

public class ArtefactIdLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtefactIdLabApplication.class, args);
    }

}
