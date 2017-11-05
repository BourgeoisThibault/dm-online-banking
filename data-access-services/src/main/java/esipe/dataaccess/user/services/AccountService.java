package esipe.dataaccess.user.services;

import esipe.dataaccess.user.entities.AccountEntity;
import esipe.dataaccess.user.models.AccountDto;
import esipe.dataaccess.user.models.UserDto;
import esipe.dataaccess.user.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author BOURGEOIS Thibault
 * Date     05/11/2017
 * Time     02:14
 */
@Service
public class AccountService implements IAccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDto> getAll() {
        return accountRepository.findAll()
                .stream()
                .map(
                        u -> AccountDto.builder()
                                .id(String.valueOf(u.getId()))
                                .type_account(u.getType_account())
                                .solde(u.getSolde())
                                .userEntity(u.getUserEntity())
                                .build()
                )
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AccountDto> getAccountById(String id) {
        AccountEntity accountEntity = accountRepository.findOne(Long.parseLong(id));
        return (accountEntity != null) ?
                Optional.of(
                        AccountDto.builder()
                                .id(String.valueOf(accountEntity.getId()))
                                .solde(accountEntity.getSolde())
                                .type_account(accountEntity.getType_account())
                                .userEntity(accountEntity.getUserEntity())
                                .build()
                )
                : Optional.empty();
    }

    @Override
    public AccountDto create(AccountDto accountDto) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setSolde(accountDto.getSolde());
        accountEntity.setType_account(accountDto.getType_account());
        accountEntity.setUserEntity(accountDto.getUserEntity());

        AccountEntity accountEntity1 = accountRepository.save(accountEntity);
        return AccountDto.builder()
                .id(String.valueOf(accountEntity1.getId()))
                .type_account(accountEntity1.getType_account())
                .solde(accountEntity1.getSolde())
                .userEntity(accountEntity1.getUserEntity())
                .build();
    }

    @Override
    public void delete(Long id) {
        accountRepository.delete(id);
    }

    @Override
    public void update(Long id, AccountDto accountDto) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(id);
        accountEntity.setSolde(accountDto.getSolde());
        accountEntity.setType_account(accountDto.getType_account());
        accountEntity.setUserEntity(accountDto.getUserEntity());

        accountRepository.save(accountEntity);
    }
}
