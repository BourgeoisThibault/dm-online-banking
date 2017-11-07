package esipe.dataaccess.user.services;

import esipe.dataaccess.user.entities.AccountEntity;
import esipe.dataaccess.user.entities.HistoryEntity;
import esipe.dataaccess.user.entities.UserEntity;
import esipe.dataaccess.user.repositories.HistoryRepository;
import esipe.dataaccess.user.repositories.UserRepository;
import esipe.models.AccountDto;
import esipe.models.HistoryDto;
import esipe.models.UserDto;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     05/11/2017
 * Time     23:46
 */
@Service
public class HistoryService implements IHistoryService {

    DozerBeanMapper mapper = new DozerBeanMapper();

    private final HistoryRepository historyRepository;

    @Autowired
    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public List<HistoryDto> getAllByAccountId(Long id) {
        List<HistoryEntity> historyEntityList = historyRepository.findAllByAccountEntity_Id(id);

        List<HistoryDto> historyDtoList = new ArrayList<HistoryDto>();
        for(int i=0 ; i<historyEntityList.size() ; i++) {
            historyDtoList.add(mapper.map(historyEntityList.get(i), HistoryDto.class));
            historyDtoList.get(i).setAccountDto(mapper.map(historyEntityList.get(i).getAccountEntity(), AccountDto.class));
            historyDtoList.get(i).getAccountDto().setAccountType(historyEntityList.get(i).getAccountEntity().getAccountTypeEntity().getType());
            historyDtoList.get(i).getAccountDto().setUserDto(mapper.map(historyEntityList.get(i).getAccountEntity().getUserEntity(), UserDto.class));
        }
        return historyDtoList;
    }

    @Override
    public List<HistoryDto> getAllByUserId(UserDto userDto) {
        List<HistoryEntity> historyEntityList = historyRepository.findAllByAccountEntity_UserEntity(mapper.map(userDto,UserEntity.class));

        List<HistoryDto> historyDtoList = new ArrayList<HistoryDto>();
        for(int i=0 ; i<historyEntityList.size() ; i++) {
            historyDtoList.add(mapper.map(historyEntityList.get(i), HistoryDto.class));
            historyDtoList.get(i).setAccountDto(mapper.map(historyEntityList.get(i).getAccountEntity(), AccountDto.class));
            historyDtoList.get(i).getAccountDto().setAccountType(historyEntityList.get(i).getAccountEntity().getAccountTypeEntity().getType());
            historyDtoList.get(i).getAccountDto().setUserDto(mapper.map(historyEntityList.get(i).getAccountEntity().getUserEntity(), UserDto.class));
        }
        return historyDtoList;
    }

    @Override
    public void create(HistoryDto historyDto) {
        HistoryEntity historyEntity = mapper.map(historyDto,HistoryEntity.class);
        historyEntity.setAccountEntity(mapper.map(historyDto.getAccountDto(),AccountEntity.class));
        historyRepository.save(historyEntity);
    }

    @Override
    public Boolean allowGetTransaction(Long id, Double amount) {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        ZonedDateTime zonedDateTime = timestamp.toInstant().atZone(ZoneId.of("UTC"));
        timestamp = Timestamp.from(zonedDateTime.plus(-7, ChronoUnit.DAYS).toInstant());

        List<HistoryEntity> historyDtoList = historyRepository.findAllByAccountEntity_IdAndDateTransactionAfterAndPutTransaction(id,timestamp,false);

        Double calc = 0.0;
        for(HistoryEntity item : historyDtoList){
            calc += item.getAmount();
        }

        if((calc + amount) > 800) {
            return false;
        } else {
            return true;
        }
    }

}
