package esipe.dataaccess.user.repositories;

import esipe.dataaccess.user.entities.AccountEntity;
import esipe.dataaccess.user.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     05/11/2017
 * Time     02:12
 */
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
    List<AccountEntity> findAll();
    List<AccountEntity> findAllByUserEntity(Long id);
    List<AccountEntity> findAllByUserEntity(UserEntity userEntity);
}
