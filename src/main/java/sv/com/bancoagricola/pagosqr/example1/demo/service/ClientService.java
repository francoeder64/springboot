package sv.com.bancoagricola.pagosqr.example1.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.bancoagricola.pagosqr.example1.demo.model.Client;
import sv.com.bancoagricola.pagosqr.example1.demo.repository.ClientRepository;

@Service
public class ClientService {

	private final ClientRepository clientRepository;
	private static final Logger logger = LogManager.getLogger(ClientService.class);

	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public List<Client> clients() {
		logger.info("clients");
		logger.info(clientRepository.findAll());
		return clientRepository.findAll();
	}

	public void registerNewClient(Client client) {
		Optional<Client> clientByEmail = clientRepository.findClientbyEmail(client.getEmail());
		if (clientByEmail.isPresent()) {
			logger.info("that email has been taken: {}", client.getEmail());
			throw new IllegalStateException("that email has been taken");
		}
		logger.info("save");
		clientRepository.save(client);
	}

	public void deleteClient(int clientId) {
		if (clientRepository.existsById(clientId)) {
			logger.info("delete");
			clientRepository.deleteById(clientId);
		} else {
			logger.info("we don't find a client in database with:{}", clientId);
			throw new IllegalStateException("we don't find a client in database with: " + clientId);
		}

	}

	@Transactional
	public void updateClient(int clientId, String clientName, String email) {
		Client clientById = clientRepository.findById(clientId)
				.orElseThrow(() -> new  IllegalStateException("Client doesn't exist"));
		if (clientName != null && 
			clientName.trim().length() > 0 && 
			!Objects.equals(clientById.getName(), clientName)) {
			clientById.setName(clientName);	
		}
		if (email != null && 
			email.trim().length() > 0 && 
			!Objects.equals(clientById.getEmail(), email)) {
			Optional<Client> clientOptional = clientRepository.findClientbyEmail(email);
			if (clientOptional.isPresent()) {
				throw new IllegalStateException("It's been taken");
			}
			clientById.setEmail(email);
		}
	}

}
