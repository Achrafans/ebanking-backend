package net.achraf.ebankingbackend.repositories;

import net.achraf.ebankingbackend.entities.Customer;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository  extends JpaRepository<Customer, Long> {
    List<Customer> findByNameContains(String name);
}
