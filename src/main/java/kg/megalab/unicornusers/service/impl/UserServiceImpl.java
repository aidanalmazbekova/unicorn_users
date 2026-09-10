package kg.megalab.unicornusers.service.impl;

import kg.megalab.unicornusers.feign.KeycloakFeign;
import kg.megalab.unicornusers.feign.KeycloakTokenFeign;
import kg.megalab.unicornusers.model.CreateUserDto;
import kg.megalab.unicornusers.model.KeycloakUserRequest;
import kg.megalab.unicornusers.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final KeycloakTokenFeign tokenFeign;
    private final KeycloakFeign keycloakFeign;

    @Value("${keycloak.client-id}")
    private String clientId;

    @Value("${keycloak.client-secret}")
    private String clientSecret;

    public UserServiceImpl(KeycloakTokenFeign tokenFeign, KeycloakFeign keycloakFeign) {
        this.tokenFeign = tokenFeign;
        this.keycloakFeign = keycloakFeign;
    }

    @Override
    public void createUser(CreateUserDto userDto) {

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("grant_type", "client_credentials");
        form.add("client_id", clientId);
        form.add("client_secret", clientSecret);

        var tokenResponse = tokenFeign.getToken(form);
        var credential = new KeycloakUserRequest.Credential("password", userDto.password(), false);
        var keycloakUser = new KeycloakUserRequest(userDto.username(), userDto.email(), userDto.firstName(), userDto.lastName(), true, List.of(credential));
        keycloakFeign.createUser("Bearer " + tokenResponse.accessToken(), keycloakUser);
    }

}
