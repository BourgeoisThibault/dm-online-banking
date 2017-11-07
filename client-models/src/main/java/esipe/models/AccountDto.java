package esipe.models;

import lombok.Data;
import lombok.ToString;

/**
 * @author BOURGEOIS Thibault
 * Date     05/11/2017
 * Time     17:01
 */
@Data
@ToString
public class AccountDto {
    private Long id;
    private UserDto userDto;
    private String accountType;
    private double solde;
}