package esipe.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author BOURGEOIS Thibault
 * Date     05/11/2017
 * Time     17:01
 */
@Data
@Builder
@ToString
public class AccountDto {
    private String id;
    private UserDto userDto;
    private String type_account;
    private double solde;
}