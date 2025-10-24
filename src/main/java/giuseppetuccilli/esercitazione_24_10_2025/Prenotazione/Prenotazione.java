package giuseppetuccilli.esercitazione_24_10_2025.Prenotazione;

import giuseppetuccilli.esercitazione_24_10_2025.Evento.Evento;
import giuseppetuccilli.esercitazione_24_10_2025.Utente.Utente;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prenotazioni")
@NoArgsConstructor
@Getter
@Setter
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;

    public Prenotazione(Evento evento, Utente utente) {
        this.evento = evento;
        this.utente = utente;
    }


}
