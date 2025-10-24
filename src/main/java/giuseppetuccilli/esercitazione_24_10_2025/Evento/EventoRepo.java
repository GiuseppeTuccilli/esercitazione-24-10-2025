package giuseppetuccilli.esercitazione_24_10_2025.Evento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepo extends JpaRepository<Evento, Long> {
}
