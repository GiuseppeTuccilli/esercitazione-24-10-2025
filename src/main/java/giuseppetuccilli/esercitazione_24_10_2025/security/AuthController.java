package giuseppetuccilli.esercitazione_24_10_2025.security;

import giuseppetuccilli.esercitazione_24_10_2025.Utente.NewUtPayload;
import giuseppetuccilli.esercitazione_24_10_2025.Utente.Utente;
import giuseppetuccilli.esercitazione_24_10_2025.Utente.UtenteService;
import giuseppetuccilli.esercitazione_24_10_2025.exeptions.ValidazioneFallitaExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UtenteService utServ;
    @Autowired
    private AuthService authServ;

    @PostMapping("login")
    public LoginResDTO login(@RequestBody LoginDTO body) {
        return new LoginResDTO(authServ.checkAndGenerate(body));
    }

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public Utente postDipendente(@RequestBody @Validated NewUtPayload body, BindingResult valRes) {
        if (valRes.hasErrors()) {
            List<String> errList = new ArrayList<>();
            for (int i = 0; i < valRes.getFieldErrors().size(); i++) {
                errList.add(valRes.getFieldErrors().get(i).getDefaultMessage());
            }
            throw new ValidazioneFallitaExeption(errList);
        }
        return utServ.saveDipendente(body);

    }
}
