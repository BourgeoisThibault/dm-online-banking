package esipe.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author BOURGEOIS Thibault
 * Date     05/11/2017
 * Time     22:17
 */
@Data
@Builder
@ToString
public class AccountTransaction {
    private Long idAccount;
    private Boolean putMoney;
    private Double amount;
}
