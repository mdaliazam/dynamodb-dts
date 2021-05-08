package com.bkash.ddb.dts.repository;

import com.bkash.ddb.dts.model.Subscription;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface SubscriptionRepository extends CrudRepository<Subscription, String> {
}
