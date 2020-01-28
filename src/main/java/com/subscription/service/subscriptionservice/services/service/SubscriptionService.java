package com.subscription.service.subscriptionservice.services.service;

import org.springframework.stereotype.Service;

import com.subscription.service.subscriptionservice.model.Subscription;

@Service
public interface SubscriptionService {
public Subscription save(Subscription subscription);
}
