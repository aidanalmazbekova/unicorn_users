package kg.megalab.unicornusers.model;

public record CreateUserDto(
        String username,
        String password,
        String email,
        String firstName,
        String lastName
) {
}
