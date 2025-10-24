package giuseppetuccilli.esercitazione_24_10_2025.exeptions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
