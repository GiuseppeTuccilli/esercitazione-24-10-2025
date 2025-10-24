package giuseppetuccilli.esercitazione_24_10_2025.Utente;

import giuseppetuccilli.esercitazione_24_10_2025.exeptions.BadRequestExeption;
import giuseppetuccilli.esercitazione_24_10_2025.exeptions.NotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepo utRepo;

    public Utente findById(long id) {
        Optional<Utente> found = utRepo.findById(id);
        if (found.isPresent()) {
            return found.get();
        } else {
            throw new NotFoundExeption(id);
        }
    }

    public Utente findByEmail(String email) {
        Optional<Utente> found = utRepo.findByEmail(email);
        if (found.isPresent()) {
            return found.get();
        } else {
            throw new NotFoundExeption(email);
        }
    }

    public Utente saveDipendente(NewUtPayload payload) {
        if (utRepo.existsByEmail(payload.email())) {
            throw new BadRequestExeption("l'email " + payload.email() + " è già in uso");
        }
        TipoUtente role;
        if (payload.ruolo().equals("u")) {
            role = TipoUtente.UTENTE_NORMALE;
        } else if (payload.ruolo().equals("o")) {
            role = TipoUtente.ORGANIZZATORE;
        } else {
            throw new BadRequestExeption("inserire u per utente, oppure o per organizzatore");
        }
        Utente newDip = new Utente(payload.nome(), payload.email(), payload.password(), role);
        utRepo.save(newDip);
        System.out.println("dipendente salvato");
        return newDip;
    }


}
