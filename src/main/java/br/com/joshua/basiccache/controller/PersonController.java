package br.com.joshua.basiccache.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joshua.basiccache.dto.PersonResponse;
import br.com.joshua.basiccache.service.PersonService;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/persons")
@Log4j2
public class PersonController {
	
	private final PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping("/list")
	public ResponseEntity<?> listAllPerson() {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		 LocalDateTime inicio = LocalDateTime.now();
		 log.info("Início listAllPerson controller: {}",inicio.format(formatter));
		 List<PersonResponse> persons = personService.listAllPerson();		 
		 LocalDateTime fim = LocalDateTime.now();
		 log.info("Fim listAllPerson controller: {}", fim.format(formatter));
		 return ResponseEntity.ok().body(persons);
	}
	
}
