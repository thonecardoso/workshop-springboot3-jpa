package com.thonecardoso.course.config;

import com.thonecardoso.course.entities.Order;
import com.thonecardoso.course.entities.User;
import com.thonecardoso.course.entities.enums.OrderStatus;
import com.thonecardoso.course.repositories.OrderRepository;
import com.thonecardoso.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        var u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        var u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        var o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        var o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        var o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(List.of(u1, u2));
        orderRepository.saveAll((List.of(o1, o2, o3)));
    }
}
