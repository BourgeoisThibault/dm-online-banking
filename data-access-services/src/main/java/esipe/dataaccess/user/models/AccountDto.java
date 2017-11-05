package esipe.dataaccess.user.models;

import esipe.dataaccess.user.entities.UserEntity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;

/**
 * @author BOURGEOIS Thibault
 * Date     05/11/2017
 * Time     01:48
 */
@Data
@Builder
@ToString
public class AccountDto {
    @Pattern(regexp = "[0-9]{1,}")
    private String id;
    private UserEntity userEntity;
    private String type_account;
    private double solde;
}
