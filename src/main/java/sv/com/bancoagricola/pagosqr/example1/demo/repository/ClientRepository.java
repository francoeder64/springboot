package sv.com.bancoagricola.pagosqr.example1.demo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sv.com.bancoagricola.pagosqr.example1.demo.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	@Query("Select c from Client c where c.email = ?1")
	Optional<Client> findClientbyEmail (String email);
	
}
