package giuseppetuccilli.esercitazione_24_10_2025.Prenotazione;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepo preRepo;
}
