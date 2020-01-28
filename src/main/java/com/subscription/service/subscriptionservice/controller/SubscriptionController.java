package com.subscription.service.subscriptionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.subscription.service.subscriptionservice.model.Mail;
import com.subscription.service.subscriptionservice.model.Subscription;
import com.subscription.service.subscriptionservice.services.service.SubscriptionService;

@RestController
public class SubscriptionController {
	@Autowired
	SubscriptionService subscriptionService;

	@PostMapping(value = "/save")
	public void save(@RequestBody Subscription subscription) {
		Subscription savedSubscription=subscriptionService.save(subscription);
		if(savedSubscription!=null) {
			final String uri = "http://localhost:9090/email";
			Mail mail = new Mail();
			mail.setMailFrom("hotelhaldiram@gmail.com");
			mail.setMailTo(savedSubscription.getEmail());
			mail.setMailSubject("Spring Boot - Email Example");
			mail.setMailContent(" Email service using Spring Boot!!!\n\nThanks\nwww.demo.com");
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Mail> entity = new HttpEntity<>(mail, headers);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForObject(uri, entity, Mail.class);
			
		}
	}

}
