package com.example.course1.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course1.entities.Order;
import com.example.course1.service.OrderService;

@RestController
@RequestMapping(value ="/orders") //Este será o nome do meu recurso
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){ //O tipo d minha resposta vai ser a minha classe Order;
		
		List<Order>list= service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj= service.findById(id);
				return ResponseEntity.ok().body(obj);
	}

}







/*Notas mportantes:
 
 1- Para falarmos que esta classe é um recurso web, e que é implementada por um controlador "REST" vamos ter que colocar uma annotaion 
    em cima da classe;
    
 2 - Vou ter que dar tambem um nome para o meu recurso e tambem colocar o valor que será o caminho para o meu recurso que estará relacionada com a entidade Order;                         
 
 
 3- Para testar se está funcionando mesmo o recurso "Orders" eu irei criar um metodo que será um "ENDPOINT" para acessar os Utilizadores;
 
 
 4- Para indicar que o metodo "public ResponseEntity<Order> findAll() vai ser um metodo que responde a requesição do tipo get do HTTP vou ter que colocar em cima do metodo um Annotaion do tipo GetMapping 
 
 
  */
 