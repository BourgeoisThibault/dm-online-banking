package esipe.dataaccess.user.services;

import esipe.dataaccess.user.entities.AccountEntity;
import esipe.dataaccess.user.entities.AccountTypeEntity;
import esipe.dataaccess.user.entities.HistoryEntity;
import esipe.dataaccess.user.entities.UserEntity;
import esipe.dataaccess.user.repositories.HistoryRepository;
import esipe.models.HistoryDto;
import esipe.models.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author BOURGEOIS Thibault
 * Date     07/11/2017
 * Time     17:56
 */
public class HistoryServiceTest {

    @InjectMocks
    HistoryService historyService;

    @Mock
    HistoryRepository historyRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        // Given
        List<HistoryEntity> historyEntityList = new ArrayList<HistoryEntity>();

        UserEntity userEntity = new UserEntity();
        userEntity.setId(Long.parseLong("1"));

        AccountTypeEntity accountTypeEntity = new AccountTypeEntity();
        accountTypeEntity.setType("Courant");

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(Long.parseLong("1"));
        accountEntity.setSolde(1234.4321);
        accountEntity.setAccountTypeEntity(accountTypeEntity);
        accountEntity.setUserEntity(userEntity);

        HistoryEntity historyEntity = new HistoryEntity();
        historyEntity.setAccountEntity(accountEntity);
        historyEntity.setAmount(12.12);
        historyEntity.setId(Long.parseLong("1"));
        historyEntity.setPutTransaction(true);
        historyEntity.setDateTransaction(new Timestamp(System.currentTimeMillis()));

        historyEntityList.add(historyEntity);
        historyEntityList.add(historyEntity);
        historyEntityList.add(historyEntity);

        when(historyRepository.findAllByAccountEntity_Id(anyLong())).thenReturn(historyEntityList);

        when(historyRepository.findAllByAccountEntity_IdAndDateTransactionAfterAndPutTransaction(Long.parseLong("10"),new Timestamp(System.currentTimeMillis()),true)).thenReturn(historyEntityList);

        when(historyRepository.findAllByAccountEntity_UserEntity(userEntity)).thenReturn(historyEntityList);
    }

    @Test
    public void getAllByAccountIdTest(){

        // When
        List<HistoryDto> historyDtoList = historyService.getAllByAccountId(anyLong());

        // Then
        assertTrue(historyDtoList.get(0).getAmount().equals(12.12));

    }

    @Test
    public void allowGetTransactionTestShouldFalse() {

        Boolean booleanReturn = historyService.allowGetTransaction(Long.parseLong("10"),2000.0);

        assertTrue(!booleanReturn);

    }

    @Test
    public void allowGetTransactionTestShouldTrue() {

        Boolean booleanReturn = historyService.allowGetTransaction(Long.parseLong("10"),1.0);

        assertTrue(booleanReturn);

    }

    @Test
    public void getAllByUserIdTest() {

        // When
        UserDto userDto = new UserDto();
        userDto.setId(Long.parseLong("1"));
        List<HistoryDto> historyDtoList = historyService.getAllByUserId(userDto);

        // Then
        assertTrue(historyDtoList.get(0).getAmount().equals(12.12));

    }

}