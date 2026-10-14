package service;

public class NotificationService {

    public enum Esito{
        OK("OK") {
            @Override
            public boolean validatePayload(String message) {
                return message != null;
            }
        },
        KO("KO") {
            @Override
            public boolean validatePayload(String message) {
                return message != null;
            }
        },
        NOT_FOUND("NOT_FOUND") {
            @Override
            public boolean validatePayload(String message) {
                return message != null;
            }
        },
        ERROR("ERROR") {
            @Override
            public boolean validatePayload(String message) {
                return message != null;
            }
        };

        private String message;

        Esito(String message) {
            this.message = message;
        }

        // Metodo astratto per forzare la validazione specifica per ciascun canale
        public abstract boolean validatePayload(String message);
    }


    public void ritornaMessaggio(Esito esito, String message){
        if (esito == null) {
            throw new IllegalArgumentException("Il canale di notifica non può essere null.");
        }
        if (!esito.validatePayload(message)) {
            throw new IllegalArgumentException(
                    String.format("Payload non valido per il canale %s", message)
            );
        }
        System.out.println(message);
    }


}
