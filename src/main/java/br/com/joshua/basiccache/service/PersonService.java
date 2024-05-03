package br.com.joshua.basiccache.service;

import java.util.List;

import br.com.joshua.basiccache.dto.PersonResponse;

public interface PersonService {

	List<PersonResponse> listAllPerson();
	
}
