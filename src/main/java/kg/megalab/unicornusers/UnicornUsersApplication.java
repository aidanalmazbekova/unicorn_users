package kg.megalab.unicornusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UnicornUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnicornUsersApplication.class, args);
    }

}
