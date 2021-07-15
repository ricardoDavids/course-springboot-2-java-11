package com.example.course1.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course1.entities.User;
import com.example.course1.service.UserService;

@RestController
@RequestMapping(value ="/users") //Este será o nome do meu recurso
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping // --> Isto quer dizer que iremos fazer uma requsição do tipo get
	public ResponseEntity<List<User>> findAll(){ //O tipo d minha resposta vai ser a minha classe User;
		
		List<User>list= service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") // Isto quer dizer que a minha requisição vai aceitar um "ID" dentro URL
	public ResponseEntity<User> findById(@PathVariable Long id){ 
		User obj= service.findById(id);
				return ResponseEntity.ok().body(obj);
	}

	//Notas: ResponseEntity<User>, aqui será do tipo user porque agora vai retornar apenas um User; 
	//Notas: findById(@PathVariable Long id) --> Este findById vai receber o parametro de URL @GetMapping(value = "/{id}")
}







/*Notas mportantes:
 
 1- Para falarmos que esta classe é um recurso web, e que é implementada por um controlador "REST" vamos ter que colocar uma annotaion 
    em cima da classe;
    
 2 - Vou ter que dar tambem um nome para o meu recurso e tambem colocar o valor que será o caminho para o meu recurso que estará relacionada com a entidade User;                         
 
 
 3- Para testar se está funcionando mesmo o recurso "Users" eu irei criar um metodo que será um "ENDPOINT" para acessar os Utilizadores;
 
 
 4- Para indicar que o metodo "public ResponseEntity<User> findAll() vai ser um metodo que responde a requesição do tipo get do HTTP vou ter que colocar em cima do metodo um Annotaion do tipo GetMapping 
 
 
  */
 