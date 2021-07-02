package com.example.course1.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.course1.entities.User;
import com.example.course1.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String...args) throws Exception{
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

		
		//Na operação savaAll, eu vou passar uma lista de objectos e ele salva essa lista no banco de dados  
		userRepository.saveAll(Arrays.asList(u1,u2));
		
	}

}



/*Para falar para o Spring que esta é uma classe de configuração vou ter que colocar aqui uma anotação.
 
   Depois para especificar que esta tamebm é uma classe especifica para o perfil de testes vou ter que colocar uma anottion.
   
   Esta classe de configuração vai servir para nós poularmos o nosso banco de dados com alguns objectos;
   */


