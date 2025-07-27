package net.achraf.ebankingbackend.services;

import net.achraf.ebankingbackend.dtos.CustomerDTO;
import net.achraf.ebankingbackend.entities.BankAccount;
import net.achraf.ebankingbackend.entities.CurrentAccount;
import net.achraf.ebankingbackend.entities.Customer;
import net.achraf.ebankingbackend.entities.SavingAccount;
import net.achraf.ebankingbackend.exceptions.BalanceNotSufficientException;
import net.achraf.ebankingbackend.exceptions.BankAccountNotFoundException;
import net.achraf.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingAccount saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;

    List<CustomerDTO> listCustomers();
    BankAccount getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

    List<BankAccount> bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    void deleteCustomer(Long customerId);

    CustomerDTO updateCustomer(CustomerDTO customerDTO);
}
