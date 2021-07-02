package com.example.course1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course1.entities.User;
import com.example.course1.repositories.UserRepository;


//O componente regista a classe sendo um componente do Spring e vai poder ser injectado assim automaticamente com o autowired na classe userResource 
//@Component
//Mas em vez de utilizarmos o @ componente iremos utilizar o @Service
@Service	
public class UserService {

	
	
	/*vou criar 2 operações que é ir buscar todos os usuarios e a outra buscar um user por ID
	 
	  Mas para isso vou precisar de ter uma dependencia  para o meu UserRepository
	 */
	@Autowired
	private UserRepository repository;
	
	
	//Aqui terá um metodo do tipo User que será uma lista para retornar todos os meus users
	public List<User>findAll(){
		return repository.findAll();
		//Repassamos a chamada para o repository. findAll e depois lá no UserResource vou ter que implementar o metodo do meu findAll 
		
		
		}
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
