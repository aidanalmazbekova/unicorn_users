package kg.megalab.unicornusers.controller;

import kg.megalab.unicornusers.model.CreateUserDto;
import kg.megalab.unicornusers.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.ok().build();
    }

}
