package esipe.dataaccess.user.services;

import esipe.dataaccess.user.entities.AccountEntity;
import esipe.dataaccess.user.entities.AccountTypeEntity;
import esipe.dataaccess.user.entities.HistoryEntity;
import esipe.dataaccess.user.entities.UserEntity;
import esipe.dataaccess.user.repositories.AccountRepository;
import esipe.dataaccess.user.repositories.HistoryRepository;
import esipe.dataaccess.user.repositories.UserRepository;
import esipe.models.AccountDto;
import esipe.models.HistoryDto;
import esipe.models.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sun.rmi.runtime.Log;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * @author BOURGEOIS Thibault
 * Date     07/11/2017
 * Time     20:26
 */
public class AccountServiceTest {

    @InjectMocks
    AccountService accountService;

    @Mock
    AccountRepository accountRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        // Given
        List<AccountEntity> accountEntityList = new ArrayList<AccountEntity>();

        UserEntity userEntity = new UserEntity();
        userEntity.setId(Long.parseLong("1"));

        AccountTypeEntity accountTypeEntity = new AccountTypeEntity();
        accountTypeEntity.setType("Courant");

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(Long.parseLong("1"));
        accountEntity.setSolde(1234.4321);
        accountEntity.setAccountTypeEntity(accountTypeEntity);
        accountEntity.setUserEntity(userEntity);

        accountEntityList.add(accountEntity);
        accountEntityList.add(accountEntity);
        accountEntityList.add(accountEntity);

        UserDto userDto = new UserDto();
        userDto.setId(Long.parseLong("1"));

        when(accountRepository.findAll()).thenReturn(accountEntityList);

        when(accountRepository.findOne(Long.parseLong("1"))).thenReturn(accountEntity);

    }

    @Test
    public void getAccountById() throws Exception {

        AccountDto accountDto = accountService.getAccountById(Long.parseLong("1"));

        assertTrue(accountDto.getSolde() == 1234.4321);

    }

}