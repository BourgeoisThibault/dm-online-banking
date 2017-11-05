package esipe.dataaccess.user.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * @author BOURGEOIS Thibault
 * Date     05/11/2017
 * Time     22:41
 */
@Data
@Entity(name = "type_account")
public class AccountTypeEntity {
    @Id
    private String type;
}
