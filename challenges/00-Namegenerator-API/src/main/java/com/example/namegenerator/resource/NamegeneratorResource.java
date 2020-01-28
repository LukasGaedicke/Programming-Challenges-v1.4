package com.example.namegenerator.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.namegenerator.service.NameService;

@RestController
@RequestMapping("/namegenerator")
public class NamegeneratorResource {

	@Autowired
	private NameService nameservice;

	@GetMapping
	public ResponseEntity generateOneName() {
		return ResponseEntity.ok(nameservice.generateName(1));
	}

	@GetMapping("/{quantity}")
	public ResponseEntity generateNames(@PathVariable int quantity) {
		return ResponseEntity.ok(nameservice.generateName(quantity));
	}
}
