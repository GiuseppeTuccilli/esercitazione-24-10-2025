package giuseppetuccilli.esercitazione_24_10_2025.Utente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepo utRepo;
}
