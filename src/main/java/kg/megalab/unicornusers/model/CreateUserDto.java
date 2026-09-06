package kg.megalab.unicornusers.model;

public record CreateUserDto(
        String userName,
        String password,
        String email,
        String firstName,
        String lastName
) {
}
