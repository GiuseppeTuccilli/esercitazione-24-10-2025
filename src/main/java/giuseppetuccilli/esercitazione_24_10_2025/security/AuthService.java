package giuseppetuccilli.esercitazione_24_10_2025.security;

import giuseppetuccilli.esercitazione_24_10_2025.Utente.Utente;
import giuseppetuccilli.esercitazione_24_10_2025.Utente.UtenteService;
import giuseppetuccilli.esercitazione_24_10_2025.exeptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UtenteService utServ;
    @Autowired
    private JWTTools jwtTools;

    public String checkAndGenerate(LoginDTO body) {
        Utente found = utServ.findByEmail(body.email());
        if (body.password().equals(found.getPassword())) {
            return jwtTools.creaToken(found);
        } else {
            throw new UnauthorizedException("credenziali non corrette");
        }
    }
}
