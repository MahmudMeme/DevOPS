package mk.finki.ukim.mk.artefactid_lab.model.exception;

public class NotFundSomethingException extends RuntimeException{
    public NotFundSomethingException() {
        super("greska vo baranje vo baza");
    }
}
