package com.example.course1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course1.entities.Order;
import com.example.course1.repositories.OrderRepository;


//O componente regista a classe sendo um componente do Spring e vai poder ser injectado assim automaticamente com o autowired na classe userResource 
//@Component
//Mas em vez de utilizarmos o @ componente iremos utilizar o @Service
@Service	
public class OrderService {

	
	
	/*vou criar 2 operações que é ir buscar todos os usuarios e a outra buscar um user por ID
	 
	  Mas para isso vou precisar de ter uma dependencia  para o meu OrderRepository
	 */
	@Autowired
	private OrderRepository repository;
	
	
	//Aqui terá um metodo do tipo Order que será uma lista para retornar todos os meus users
	public List<Order>findAll(){
		return repository.findAll();
		//Repassamos a chamada para o repository. findAll e depois lá no OrderResource vou ter que implementar o metodo do meu findAll 
		
		
		}
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
