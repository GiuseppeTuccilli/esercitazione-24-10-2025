package giuseppetuccilli.esercitazione_24_10_2025.Utente;

import giuseppetuccilli.esercitazione_24_10_2025.Evento.Evento;
import giuseppetuccilli.esercitazione_24_10_2025.Evento.EventoDTO;
import giuseppetuccilli.esercitazione_24_10_2025.Evento.EventoService;
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
}
