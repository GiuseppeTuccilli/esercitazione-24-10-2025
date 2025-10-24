package giuseppetuccilli.esercitazione_24_10_2025.Evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {
    @Autowired
    private EventoRepo evRepo;
}
