package giuseppetuccilli.esercitazione_24_10_2025.Utente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Long> {
    Optional<Utente> findByEmail(String email);

    boolean existsByEmail(String email);
}
