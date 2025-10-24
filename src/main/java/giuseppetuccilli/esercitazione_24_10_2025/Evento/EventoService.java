package giuseppetuccilli.esercitazione_24_10_2025.Evento;

import giuseppetuccilli.esercitazione_24_10_2025.Utente.TipoUtente;
import giuseppetuccilli.esercitazione_24_10_2025.Utente.Utente;
import giuseppetuccilli.esercitazione_24_10_2025.Utente.UtenteService;
import giuseppetuccilli.esercitazione_24_10_2025.exeptions.BadRequestExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class EventoService {
    @Autowired
    private EventoRepo evRepo;
    @Autowired
    private UtenteService utServ;

    private LocalDate getData(String data) {
        String dataString = "";
        if (data.length() > 10) {
            dataString = data.substring(0, 10);
        } else if (data.length() == 10) {
            dataString = data;
        } else {
            throw new BadRequestExeption("data non valida");
        }
        try {
            String[] dataArray = dataString.split("-");
            int anno = Integer.parseInt(dataArray[0]);
            int mese = Integer.parseInt(dataArray[1]);
            int giorno = Integer.parseInt(dataArray[2]);
            LocalDate dataloc = LocalDate.of(anno, mese, giorno);
            return dataloc;
        } catch (Exception ex) {
            throw new BadRequestExeption("data non valida");
        }
    }

    public Evento saveEvento(EventoDTO evento, long orgId) {
        LocalDate data = getData(evento.data());
        if (data.isBefore(LocalDate.now())) {
            throw new BadRequestExeption("non puoi organizzare un evento in data passata");
        }
        Utente organizzatore = utServ.findById(orgId);
        if (organizzatore.getRuolo() == TipoUtente.UTENTE_NORMALE) {
            throw new BadRequestExeption("solo gli organizzatori possono salvare gli eventi");
        }
        Optional<Evento> fondByDate = evRepo.findByData(data);
        Optional<Evento> fondByLuogo = evRepo.findByLuogo(evento.luogo());
        if (fondByLuogo.isPresent() && fondByDate.isPresent()) {
            if (fondByLuogo.equals(fondByDate)) {
                throw new BadRequestExeption("non puoi salvare due eventi con stessi luogo e data");
            }
        }
        Evento ev = new Evento(organizzatore, evento.descrizione(), data, evento.luogo(), evento.numeroPosti());
        evRepo.save(ev);
        System.out.println("evento salvato");
        return ev;
    }
}
