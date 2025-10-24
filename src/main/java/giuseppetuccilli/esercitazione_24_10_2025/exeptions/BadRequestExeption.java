package giuseppetuccilli.esercitazione_24_10_2025.exeptions;

public class BadRequestExeption extends RuntimeException {
    public BadRequestExeption(String message) {
        super(message);
    }
}
