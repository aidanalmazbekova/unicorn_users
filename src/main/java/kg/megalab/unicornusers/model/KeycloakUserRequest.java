package kg.megalab.unicornusers.model;

import java.util.List;

public record KeycloakUserRequest(
        String username,
        String email,
        String firstName,
        String lastName,
        boolean enabled,
        List<Credential> credentials
) {
    public record Credential(
            String type,
            String value,
            boolean temporary
    ) {
    }
}
