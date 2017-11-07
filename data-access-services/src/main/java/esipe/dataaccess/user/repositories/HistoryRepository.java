package esipe.dataaccess.user.repositories;

import esipe.dataaccess.user.entities.AccountEntity;
import esipe.dataaccess.user.entities.HistoryEntity;
import esipe.dataaccess.user.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     05/11/2017
 * Time     23:49
 */
public interface HistoryRepository extends CrudRepository<HistoryEntity, Long>{
    List<HistoryEntity> findAll();
    List<HistoryEntity> findAllByAccountEntity_UserEntity(UserEntity userEntity);
    List<HistoryEntity> findAllByAccountEntity_Id(Long id);
    List<HistoryEntity> findAllByAccountEntity_IdAndDateTransactionAfterAndPutTransaction(Long id, Timestamp timestamp, Boolean put);
}
