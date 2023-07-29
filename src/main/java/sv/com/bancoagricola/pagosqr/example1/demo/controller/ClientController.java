package sv.com.bancoagricola.pagosqr.example1.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sv.com.bancoagricola.pagosqr.example1.demo.model.Client;
import sv.com.bancoagricola.pagosqr.example1.demo.service.ClientService;

@RestController
@RequestMapping(path = "api/v1/clients")
public class ClientController {

	private final ClientService clientService;
	private static final Logger logger = LogManager.getLogger(ClientController.class);

	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@GetMapping
	public List<Client> home() {
		logger.info("we're going to add some logs, just in case");
		return clientService.clients();
	}

	@PostMapping
	public void registerNewClient(@RequestBody Client client) {
		logger.info("we're saving a new client: {}", client.getName());
		clientService.registerNewClient(client);
	}

	@DeleteMapping(path = "{clientId}")
	public void deleteClient(@PathVariable("clientId") int clientId) {
		logger.info("we're deleting a client: {}", clientId);
		clientService.deleteClient(clientId);
	}
	
	@PutMapping(path = "{clientId}")
	public void updateClient (
			@PathVariable("clientId") int clientId,
			@RequestParam(required = false) String clientName,
			@RequestParam(required = false) String email
			) {
		logger.info("we're updating a client: {}", clientId);
		clientService.updateClient(clientId, clientName, email);
	}
	
//	@GetMapping
//	public String home () {
//		return "This is a first page";
//	}

//	@GetMapping
//	public List <String> home () {
//		return List.of("one","two","three");
//	}
}
