package esipe.dataaccess.user.services;

import esipe.dataaccess.user.entities.AccountEntity;
import esipe.dataaccess.user.entities.UserEntity;
import esipe.models.*;
import esipe.dataaccess.user.repositories.AccountRepository;
import org.dozer.DozerBeanMapper;
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

    DozerBeanMapper mapper = new DozerBeanMapper();

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
                        u -> mapper.map(u, AccountDto.class)
                )
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AccountDto> getAccountById(String id) {
        AccountEntity accountEntity = accountRepository.findOne(Long.parseLong(id));
        return (accountEntity != null) ?
                Optional.of(
                        mapper.map(accountEntity, AccountDto.class)
                )
                : Optional.empty();
    }

    @Override
    public AccountDto create(AccountDto accountDto) {

        AccountEntity accountEntity1 = accountRepository.save(mapper.map(accountDto,AccountEntity.class));

        return mapper.map(accountEntity1, AccountDto.class);
    }

    @Override
    public void delete(Long id) {
        accountRepository.delete(id);
    }

    @Override
    public void update(Long id, AccountDto accountDto) {

    }
}
