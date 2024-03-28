package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.KafkaProducerService;

@RestController
@RequestMapping("/docker")
public class DockerController {

	private final KafkaProducerService kafkaProducerService;

	public DockerController(KafkaProducerService kafkaProducerService) {
		this.kafkaProducerService = kafkaProducerService;
	}


	@GetMapping("/{serviceName}")	
	public String sendMessage(@PathVariable("serviceName") String serviceName) {
		kafkaProducerService.sendMessage(serviceName);
		return "Ok";
		
	}
}
