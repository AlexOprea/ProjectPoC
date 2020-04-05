package atm.poc.ProjectPoC.api;

import atm.poc.ProjectPoC.exception.AccountNotFound;
import atm.poc.ProjectPoC.model.Account;
import atm.poc.ProjectPoC.model.AccountDTO;
import atm.poc.ProjectPoC.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("atm/accounts")
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private AccountService accountService;

    @GetMapping(path = "{name}")
    public AccountDTO getAccountInfo(@PathVariable("name") String name) throws AccountNotFound {
        return accountService.displayAccountInfo(name);
    }
}
