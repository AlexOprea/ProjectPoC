package atm.poc.ProjectPoC.api;

import atm.poc.ProjectPoC.exception.AccountNotFound;
import atm.poc.ProjectPoC.model.AccountDTO;
import atm.poc.ProjectPoC.service.AccountService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AccountControllerTest {

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    @Test
    public void testAccountFound() throws AccountNotFound {
        when(accountService.displayAccountInfo("Test")).thenReturn(createAccountDTO());
        AccountDTO actual = accountController.getAccountInfo("Test");
        assertNotNull(actual);
    }

    private AccountDTO createAccountDTO() {
        return new AccountDTO(1,"Test",0d,0d,0d);
    }

    @Test
    public void testAccountNotFound() throws AccountNotFound {
        when(accountService.displayAccountInfo("Test")).thenThrow(new AccountNotFound("Test"));
        assertThrows(AccountNotFound.class,()->accountController.getAccountInfo("Test"));
    }



}
