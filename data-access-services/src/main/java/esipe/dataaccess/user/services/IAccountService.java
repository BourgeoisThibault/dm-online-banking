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
    List<AccountDto> getAll();
    Optional<AccountDto> getAccountById(String id);
    AccountDto create(AccountDto accountDto);
    void delete(Long id);
    void update(Long id, AccountDto accountDto);
}
