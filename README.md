# consent-admingui
Consent-admingui modulet, der tidligere lå i _consent_ projektet.

Fra _consent_ projektet: Denne IdP kan sættes mellem service providers (SPs) og en identity provider (IdP) med det formål at håndtere brugersamtykke.

## Test
I _consent-webgui_ projektet findes et docker compose setup i mappen _consent-compose_ hvorfra hele consent flowet kan testes.

## Konfiguration

| Environment variable | Beskrivelse                                                                                                     | Påkrævet |
|----------------------|-----------------------------------------------------------------------------------------------------------------|----------|
| CONSENTSERVICE_URL   | Url til consent-service.                                                                                        | Ja       |
| CONTEXT              | Context path.                                                                                                   | Ja       |
| SERVER_PORT          | Server port. Defaulter til 8080.                                                                                | Nej      |
| LOG_LEVEL            | Log Level til applikation log. Defaulter til INFO.                                                              | Nej      |
| LOG_LEVEL_FRAMEWORK  | Log level til framework. Defaulter to INFO.                                                                     | Nej      |
| CORRELATION_ID       | HTTP header til at få correlation id fra. Benyttes til at korrelere log-beskeder. Defaulter til "x-request-id". | Nej      |
| SERVICE_ID           | Service id til log-beskeder. Defaulter til "consent-admingui".                                                  | Nej      |
