package com.bkash.ddb.dts.controller;

import com.bkash.ddb.dts.model.Subscription;
import com.bkash.ddb.dts.repository.SubscriptionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private SubscriptionRepository repository;

    public SubscriptionController(SubscriptionRepository subscriptionRepository) {
        this.repository = subscriptionRepository;
    }

    @GetMapping
    public Subscription createAndGet() {
//        Subscription subscription = new Subscription("Azam", "Dhanmondi");

        List<Subscription> subscriptions = new ArrayList<>(){{
            add(new Subscription("Mohammad", "Jigatoal"));
            add(new Subscription("Sanjida", "Dhanmondi"));
            add(new Subscription("Salina", "Dhaka"));
        }};

        subscriptions.stream().forEach(subscription -> this.repository.save(subscription));

        return subscriptions.get(0);
    }
}
