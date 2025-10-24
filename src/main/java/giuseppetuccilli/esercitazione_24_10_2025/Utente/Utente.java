package giuseppetuccilli.esercitazione_24_10_2025.Utente;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "utenti")
@NoArgsConstructor
@Getter
@Setter
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String nome;
    private String email;
    private String password;
    @Enumerated
    private TipoUtente ruolo;

    public Utente(String nome, String email, String password, TipoUtente ruolo) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.ruolo = ruolo;
    }


}
