package esipe.dataaccess.user.repositories;

import esipe.dataaccess.user.entities.HistoryEntity;
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
    List<HistoryEntity> findAllByAccountEntity_Id(Long id);
    List<HistoryEntity> findAllByAccountEntity_IdAndDateTransactionAfter(Long id, Timestamp timestamp);
}
