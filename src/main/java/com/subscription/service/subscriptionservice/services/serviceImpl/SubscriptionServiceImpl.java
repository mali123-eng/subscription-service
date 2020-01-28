package com.subscription.service.subscriptionservice.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subscription.service.subscriptionservice.model.Subscription;
import com.subscription.service.subscriptionservice.repository.SubscriptionRepository;
import com.subscription.service.subscriptionservice.services.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
@Autowired
SubscriptionRepository subscriptionRepository;
	@Override
	public Subscription save(Subscription subscription) {
		
		return subscriptionRepository.save(subscription);
	}

}
