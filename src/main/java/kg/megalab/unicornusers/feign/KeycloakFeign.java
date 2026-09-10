package kg.megalab.unicornusers.feign;

import kg.megalab.unicornusers.model.KeycloakUserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "keycloakAdminFeign", url = "${keycloak.base-url}")
public interface KeycloakFeign {

    @PostMapping("/admin/realms/${keycloak.realm}/users")
    ResponseEntity<Void> createUser(@RequestHeader("Authorization") String authorization, @RequestBody KeycloakUserRequest user);

}
