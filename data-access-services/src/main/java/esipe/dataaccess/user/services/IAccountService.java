package esipe.dataaccess.user.services;

import esipe.dataaccess.user.entities.AccountEntity;
import esipe.models.*;

import java.util.List;
import java.util.Optional;

/**
 * @author BOURGEOIS Thibault
 * Date     05/11/2017
 * Time     02:13
 */
public interface IAccountService {
    List<AccountDto> getAllAccountOfUser(Long id) throws Exception;
    AccountDto getAccountById(Long id);
    AccountDto create(AccountDto accountDto) throws Exception;
    void updateAccount(AccountTransaction accountTransaction) throws Exception;
}
