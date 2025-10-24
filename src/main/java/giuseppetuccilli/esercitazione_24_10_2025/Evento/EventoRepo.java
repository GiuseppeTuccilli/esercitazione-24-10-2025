package giuseppetuccilli.esercitazione_24_10_2025.Evento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventoRepo extends JpaRepository<Evento, Long> {
    List<Evento> findByData(LocalDate data);

    List<Evento> findByLuogo(String luogo);


}
