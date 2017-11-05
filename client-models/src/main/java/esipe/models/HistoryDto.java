package esipe.models;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @author BOURGEOIS Thibault
 * Date     05/11/2017
 * Time     23:38
 */
@Data
@ToString
public class HistoryDto {
    private Long id;
    private AccountDto accountEntity;
    private Boolean putTransaction;
    private Double amount;
    private Timestamp dateTransaction;
}
