package kg.megalab.unicornusers.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record KeycloakTokenResponse(
        @JsonProperty("access_token")
        String accessToken
) {
}
