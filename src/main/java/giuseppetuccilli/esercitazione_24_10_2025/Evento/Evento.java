package giuseppetuccilli.esercitazione_24_10_2025.Evento;

import giuseppetuccilli.esercitazione_24_10_2025.Utente.Utente;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "eventi")
@Getter
@Setter
@NoArgsConstructor
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String descrizione;
    private LocalDate data;
    private String luogo;
    private int numeroPosti;

    @ManyToOne
    @JoinColumn(name = "id_organizzatore")
    private Utente organizzatore;

    public Evento(Utente organizzatore, String desc, LocalDate data, String luogo, int posti) {
        this.organizzatore = organizzatore;
        this.data = data;
        this.descrizione = desc;
        this.luogo = luogo;
        this.numeroPosti = posti;
    }
}
