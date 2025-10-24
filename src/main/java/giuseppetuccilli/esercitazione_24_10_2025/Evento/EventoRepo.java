package giuseppetuccilli.esercitazione_24_10_2025.Evento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface EventoRepo extends JpaRepository<Evento, Long> {
    Optional<Evento> findByData(LocalDate data);

    Optional<Evento> findByLuogo(String luogo);


}
