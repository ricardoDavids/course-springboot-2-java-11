package com.example.course1.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course1.entities.User;

@RestController
@RequestMapping(value ="/users") //Este será o nome do meu recurso
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){ //O tipo d minha resposta vai ser a minha classe User;
		
		User u = new User(1L,"Maria", "maria@gmail.com","999999", "12345");
		return ResponseEntity.ok().body(u);
	}

}







/*Notas mportantes:
 
 1- Para falarmos que esta classe é um recurso web, e que é implementada por um controlador "REST" vamos ter que colocar uma annotaion 
    em cima da classe;
    
 2 - Vou ter que dar tambem um nome para o meu recurso e tambem colocar o valor que será o caminho para o meu recurso que estará relacionada com a entidade User;                         
 
 
 3- Para testar se está funcionando mesmo o recurso "Users" eu irei criar um metodo que será um "ENDPOINT" para acessar os Utilizadores;
 
 
 4- Para indicar que o metodo "public ResponseEntity<User> findAll() vai ser um metodo que responde a requesição do tipo get do HTTP vou ter que colocar em cima do metodo um Annotaion do tipo GetMapping 
 
 
  */
 