package giuseppetuccilli.esercitazione_24_10_2025.exeptions;

import java.util.List;

public record ErrorListPayload(String message, List<String> erList) {
}
