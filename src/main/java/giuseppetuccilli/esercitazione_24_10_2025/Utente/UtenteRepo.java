package giuseppetuccilli.esercitazione_24_10_2025.Utente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Long> {
}
