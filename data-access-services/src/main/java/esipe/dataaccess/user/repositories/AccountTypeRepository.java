package esipe.dataaccess.user.repositories;

import esipe.dataaccess.user.entities.AccountTypeEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author BOURGEOIS Thibault
 * Date     06/11/2017
 * Time     21:42
 */
public interface AccountTypeRepository extends CrudRepository<AccountTypeEntity, Long> {
    AccountTypeEntity findByType(String type);
}
