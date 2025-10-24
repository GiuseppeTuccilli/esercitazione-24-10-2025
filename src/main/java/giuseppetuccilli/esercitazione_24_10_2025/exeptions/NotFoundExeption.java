package giuseppetuccilli.esercitazione_24_10_2025.exeptions;

public class NotFoundExeption extends RuntimeException {
    public NotFoundExeption(long id) {
        super("la risorsa con id " + id + " non è presente nel database");
    }

    public NotFoundExeption(String email) {
        super("\"la risorsa con email " + email + " non è presente nel database\"");
    }
}
