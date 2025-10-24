package giuseppetuccilli.esercitazione_24_10_2025.Utente;

import giuseppetuccilli.esercitazione_24_10_2025.Evento.Evento;
import giuseppetuccilli.esercitazione_24_10_2025.Evento.EventoDTO;
import giuseppetuccilli.esercitazione_24_10_2025.Evento.EventoService;
import giuseppetuccilli.esercitazione_24_10_2025.Prenotazione.DeletePrenDTO;
import giuseppetuccilli.esercitazione_24_10_2025.Prenotazione.Prenotazione;
import giuseppetuccilli.esercitazione_24_10_2025.Prenotazione.PrenotazioneDTO;
import giuseppetuccilli.esercitazione_24_10_2025.Prenotazione.PrenotazioneService;
import giuseppetuccilli.esercitazione_24_10_2025.exeptions.BadRequestExeption;
import giuseppetuccilli.esercitazione_24_10_2025.exeptions.ValidazioneFallitaExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/utenti")
public class UtenteController {
    @Autowired
    private EventoService evServ;
    @Autowired
    private PrenotazioneService preServ;
    @Autowired
    private UtenteService utServ;

    //endpoint nuovo viaggio
    @PostMapping("/{utId}/organizza")
    public Evento nuovoEvento(@PathVariable long utId, @RequestBody @Validated EventoDTO body, BindingResult valRes) {
        if (valRes.hasErrors()) {
            List<String> errList = new ArrayList<>();
            for (int i = 0; i < valRes.getFieldErrors().size(); i++) {
                errList.add(valRes.getFieldErrors().get(i).getDefaultMessage());
            }
            throw new ValidazioneFallitaExeption(errList);
        }
        return evServ.saveEvento(body, utId);
    }

    //modifica evento
    @PutMapping("/{utId}/modifica/{evId}")
    public Evento modEvento(@PathVariable long utId, @RequestBody @Validated EventoDTO body, BindingResult valRes, @PathVariable long evId) {
        if (valRes.hasErrors()) {
            List<String> errList = new ArrayList<>();
            for (int i = 0; i < valRes.getFieldErrors().size(); i++) {
                errList.add(valRes.getFieldErrors().get(i).getDefaultMessage());
            }
            throw new ValidazioneFallitaExeption(errList);
        }
        return evServ.editEvento(body, utId, evId);
    }

    @PostMapping("/{utId}/prenota")
    public Prenotazione nuovaPrenotazione(@PathVariable long utId, @RequestBody PrenotazioneDTO body) {
        return preServ.savePrenotazione(body, utId);
    }

    //eliminazione prenotazioni
    @DeleteMapping("/{utId}/elimina")
    public void deletePrenotazione(@PathVariable long utId, @RequestBody DeletePrenDTO body) {
        Utente ut = utServ.findById(utId);
        if (!(ut.getRuolo() == TipoUtente.UTENTE_NORMALE)) {
            throw new BadRequestExeption("solo gli utenti normali possono eliminare le prenotazioni");
        }
        preServ.deletePrenotazione(body.id());
    }
}
