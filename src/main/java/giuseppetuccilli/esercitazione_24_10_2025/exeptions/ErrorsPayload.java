package giuseppetuccilli.esercitazione_24_10_2025.exeptions;

import java.time.LocalDate;

public record ErrorsPayload(String message, LocalDate data) {
}
