package giuseppetuccilli.esercitazione_24_10_2025.Utente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NewUtPayload(
        @NotBlank(message = "il nome è obbligatorio")
        @Size(min = 2, max = 30, message = "il nome deve avere dai 2 ai 30 caratteri")
        String nome,
        @NotBlank(message = "il cognome è obbligatorio")
        @Size(min = 2, max = 30, message = "la password deve avere dai 2 ai 30 caratteri")
        String password,
        @NotBlank(message = "l'email è obbligatoria")
        @Email(message = "l'email inserita non è nel formato corretto")
        String email,
        @NotBlank
        @Size(min = 1, max = 1, message = "i valori concessi sono 'u' (utente) oppure 'o' (organizzatore)")
        String ruolo

) {
}
