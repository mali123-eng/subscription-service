package com.subscription.service.subscriptionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subscription.service.subscriptionservice.model.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
