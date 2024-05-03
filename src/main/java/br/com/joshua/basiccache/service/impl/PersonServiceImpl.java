package br.com.joshua.basiccache.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.joshua.basiccache.dto.PersonResponse;
import br.com.joshua.basiccache.service.PersonService;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PersonServiceImpl implements PersonService {

	@Cacheable("persons")
	@Override
	public List<PersonResponse> listAllPerson() {
		log.info("listAllPerson - buscando...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<PersonResponse> persons = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            PersonResponse person = PersonResponse.builder()
                .id(i)
                .name("Name " + i)
                .email("email" + i + "@example.com")
                .build();
            persons.add(person);
        }
		return persons;
	}

}
