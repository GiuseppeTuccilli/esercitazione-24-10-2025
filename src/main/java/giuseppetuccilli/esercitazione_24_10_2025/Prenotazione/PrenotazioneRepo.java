package giuseppetuccilli.esercitazione_24_10_2025.Prenotazione;

import giuseppetuccilli.esercitazione_24_10_2025.Utente.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrenotazioneRepo extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByUtente(Utente utente);
}
