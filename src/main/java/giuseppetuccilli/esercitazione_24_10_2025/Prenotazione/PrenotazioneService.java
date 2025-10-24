package giuseppetuccilli.esercitazione_24_10_2025.Prenotazione;

import giuseppetuccilli.esercitazione_24_10_2025.Evento.Evento;
import giuseppetuccilli.esercitazione_24_10_2025.Evento.EventoService;
import giuseppetuccilli.esercitazione_24_10_2025.Utente.Utente;
import giuseppetuccilli.esercitazione_24_10_2025.Utente.UtenteService;
import giuseppetuccilli.esercitazione_24_10_2025.exeptions.BadRequestExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepo preRepo;
    @Autowired
    private UtenteService utServ;
    @Autowired
    private EventoService evServ;

    public Prenotazione savePrenotazione(PrenotazioneDTO pren, Long utId) {

        Utente utFound = utServ.findById(utId);
        Evento evFound = evServ.findById(pren.idEvento());
        List<Prenotazione> preList = preRepo.findByUtente(utFound);
        if (!preList.isEmpty()) {
            for (int i = 0; i < preList.size(); i++) {
                if (preList.get(i).getEvento().getData().equals(evFound.getData())) {
                    throw new BadRequestExeption("hai già una prenotazione per quella data");
                }
            }
        }
        Prenotazione p = new Prenotazione(evFound, utFound);
        preRepo.save(p);
        System.out.println("prenotazione salvata");
        return p;
    }
}
