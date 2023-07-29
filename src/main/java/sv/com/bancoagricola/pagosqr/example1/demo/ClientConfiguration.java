package sv.com.bancoagricola.pagosqr.example1.demo;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sv.com.bancoagricola.pagosqr.example1.demo.model.Client;
import sv.com.bancoagricola.pagosqr.example1.demo.repository.ClientRepository;

@Configuration
public class ClientConfiguration {

	private final ClientRepository clientRepository;
	
	@Autowired
	public ClientConfiguration(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	@Bean
	CommandLineRunner commandLineRunner(ClientRepository clientRepository) {
		return args -> {
			Client franco = new Client("franco", "franco@gmail.com", LocalDate.of(1982,Month.NOVEMBER, 22));
			Client pepe = new Client("pepe", "pepe@gmail.com", LocalDate.of(1987,Month.NOVEMBER, 22));
			Client juanita = new Client("juanita", "juanita@gmail.com", LocalDate.of(1997,Month.NOVEMBER, 22));
			clientRepository.saveAll(List.of(franco, pepe, juanita) );
		};
		
	}
}
