package net.achraf.ebankingbackend.web;

import net.achraf.ebankingbackend.dtos.AccountHistoryDTO;
import net.achraf.ebankingbackend.dtos.AccountOperationDTO;
import net.achraf.ebankingbackend.dtos.BankAccountDTO;
import net.achraf.ebankingbackend.exceptions.BankAccountNotFoundException;
import net.achraf.ebankingbackend.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BankAccountRestController {
    private BankAccountService bankAccountService;

    public BankAccountRestController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("accounts/{id}")
    public BankAccountDTO getBankAccountById(@PathVariable String id) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(id);
    }

    @GetMapping("accounts")
    public List<BankAccountDTO> listAccounts()  {
        return bankAccountService.bankAccountList();
    }

    @GetMapping("accounts/{accountId}/operations")
    public List<AccountOperationDTO> getHistory(@PathVariable String accountId){
        return bankAccountService.accountHistory(accountId);
    }

    @GetMapping("accounts/{accountId}/pageOperations")
    public AccountHistoryDTO getAccountHistory(
            @PathVariable String accountId,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) throws BankAccountNotFoundException {
        return bankAccountService.getAccountHistory(accountId, page, size);
    }


}
