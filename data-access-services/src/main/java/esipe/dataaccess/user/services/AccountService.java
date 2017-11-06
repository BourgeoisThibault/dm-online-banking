package esipe.dataaccess.user.services;

import esipe.dataaccess.user.entities.AccountEntity;
import esipe.dataaccess.user.entities.AccountTypeEntity;
import esipe.dataaccess.user.entities.UserEntity;
import esipe.dataaccess.user.repositories.AccountTypeRepository;
import esipe.models.*;
import esipe.dataaccess.user.repositories.AccountRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
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
    private final HistoryService historyService;
    private final UserService userService;
    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository,
                          HistoryService historyService,
                          UserService userService,
                          AccountTypeRepository accountTypeRepository) {
        this.accountRepository = accountRepository;
        this.historyService = historyService;
        this.userService = userService;
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountDto> getAllAccountOfUser(Long id) throws Exception {

        try {
            UserDto userDto = userService.getUserById(id);

            List<AccountEntity> accountEntityList = accountRepository.findAllByUserEntity(mapper.map(userDto, UserEntity.class));

            List<AccountDto> accountDtoList = new ArrayList<AccountDto>();
            for(int i=0 ; i<accountEntityList.size() ; i++) {
                accountDtoList.add(mapper.map(accountEntityList.get(i), AccountDto.class));
                accountDtoList.get(i).setUserDto(mapper.map(accountEntityList.get(i).getUserEntity(), UserDto.class));
                accountDtoList.get(i).setAccountType(accountEntityList.get(i).getAccountTypeEntity().getType());
            }

            return accountDtoList;
        } catch (Exception e) {
            throw new Exception("User inconnu");
        }
    }

    @Override
    public AccountDto getAccountById(Long id) {
        AccountEntity accountEntity = accountRepository.findOne(id);
        AccountDto accountDto = mapper.map(accountEntity,AccountDto.class);
        accountDto.setUserDto(mapper.map(accountEntity.getUserEntity(), UserDto.class));
        return accountDto;
    }

    @Override
    public AccountDto create(AccountDto accountDto) throws Exception {

        if(!alreadyHaveAccount(accountDto))
            throw new Exception("Dispose déja de ce type de compte");

        if(!toOldForAccount(accountDto))
            throw new Exception("User trop vieux");

        AccountEntity accountEntityToPush = mapper.map(accountDto,AccountEntity.class);
        accountEntityToPush.setUserEntity(mapper.map(accountDto.getUserDto(),UserEntity.class));
        AccountTypeEntity accountTypeEntity = new AccountTypeEntity();
        accountTypeEntity.setType(accountDto.getAccountType());
        accountEntityToPush.setAccountTypeEntity(accountTypeEntity);

        AccountEntity newAccountEntity = accountRepository.save(accountEntityToPush);

        AccountDto newAccountDto = mapper.map(newAccountEntity,AccountDto.class);
        accountDto.setUserDto(mapper.map(newAccountEntity.getUserEntity(), UserDto.class));

        return newAccountDto;
    }

    @Override
    public void updateAccount(AccountTransaction accountTransaction) throws Exception {

        AccountEntity accountEntity = accountRepository.findOne(accountTransaction.getIdAccount());

        if(accountEntity.getId() != null) {
            HistoryDto historyDto = new HistoryDto();
            historyDto.setAmount(accountTransaction.getAmount());
            historyDto.setAccountDto(mapper.map(accountEntity,AccountDto.class));
            historyDto.setDateTransaction(new Timestamp(System.currentTimeMillis()));
            Double newSolde;
            if(accountTransaction.getPutMoney()) {
                historyDto.setPutTransaction(true);
                newSolde = accountEntity.getSolde() + accountTransaction.getAmount();
            } else {
                historyDto.setPutTransaction(false);
                if(historyService.allowGetTransaction(accountTransaction.getIdAccount(),accountTransaction.getAmount())) {
                    newSolde = accountEntity.getSolde() - accountTransaction.getAmount();
                } else {
                    throw new Exception("Dépassement des 800€ hebdomadaire");
                }
            }
            accountEntity.setSolde(newSolde);
            accountRepository.save(accountEntity);

            historyService.create(historyDto);
        } else {
            throw new Exception("Compte introuvable");
        }
    }

    private Boolean alreadyHaveAccount(AccountDto accountDto) {

        List<AccountEntity> accountEntityList = accountRepository.findAllByUserEntity(mapper.map(accountDto.getUserDto(), UserEntity.class));

        for(int i=0 ; i<accountEntityList.size() ; i++) {
            if(accountEntityList.get(i).getAccountTypeEntity().getType().equals(accountDto.getAccountType()))
                return false;
        }

        return true;
    }

    private Boolean toOldForAccount(AccountDto accountDto) throws Exception {

        try {
            UserDto userDto = userService.getUserById(accountDto.getUserDto().getId());
            Calendar curr = Calendar.getInstance();
            Calendar birth = Calendar.getInstance();
            birth.setTime(userDto.getBirth());
            int yeardiff = curr.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
            curr.add(Calendar.YEAR,-yeardiff);
            if(birth.after(curr))
                yeardiff = yeardiff - 1;

            AccountTypeEntity accountTypeEntity = accountTypeRepository.findByType(accountDto.getAccountType());

            if(yeardiff > accountTypeEntity.getMinAge())
                return false;

        } catch (Exception e) {
            throw new Exception("User inconnu");
        }

        return true;
    }

}
