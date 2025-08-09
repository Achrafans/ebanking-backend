package net.achraf.ebankingbackend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.achraf.ebankingbackend.dtos.CustomerDTO;
import net.achraf.ebankingbackend.entities.Customer;
import net.achraf.ebankingbackend.exceptions.CustomerNotFoundException;
import net.achraf.ebankingbackend.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class CustomerRestController {
    private BankAccountService bankAccountService;

    @GetMapping("customers")
    public List<CustomerDTO> customers(){
        return bankAccountService.listCustomers();
    }

    @GetMapping("customers/{id}")
    public CustomerDTO getCustomer(@PathVariable(name = "id") Long id) throws CustomerNotFoundException {
        return bankAccountService.getCustomer(id);
    }

    @PostMapping("customers")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
       return bankAccountService.saveCustomer(customerDTO);
    }

    @DeleteMapping("customers/{customerId}")
    public void deleteCustomer(@PathVariable(name = "customerId") Long id){
        bankAccountService.deleteCustomer(id);
    }

    @PutMapping("customers/{customerId}")
    public CustomerDTO updateCustomer(@PathVariable(name = "customerId") Long customerId,@RequestBody CustomerDTO customerDTO){
        return bankAccountService.updateCustomer(customerDTO);

    }
}
