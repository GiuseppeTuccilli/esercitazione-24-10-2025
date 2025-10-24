package giuseppetuccilli.esercitazione_24_10_2025.Prenotazione;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepo extends JpaRepository<Prenotazione, Long> {
}
