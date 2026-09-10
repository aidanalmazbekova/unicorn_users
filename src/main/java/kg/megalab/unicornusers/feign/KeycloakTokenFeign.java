package kg.megalab.unicornusers.feign;

import kg.megalab.unicornusers.model.KeycloakTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "keycloakTokenFeign", url = "${keycloak.base-url}")
public interface KeycloakTokenFeign {

    @PostMapping(value = "/realms/${keycloak.realm}/protocol/openid-connect/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    KeycloakTokenResponse getToken(@RequestBody MultiValueMap<String, String> form);

}
