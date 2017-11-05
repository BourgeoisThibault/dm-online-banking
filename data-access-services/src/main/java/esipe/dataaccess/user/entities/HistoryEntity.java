package esipe.dataaccess.user.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author BOURGEOIS Thibault
 * Date     05/11/2017
 * Time     23:35
 */
@Data
@Entity(name = "history")
public class HistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AccountEntity accountEntity;

    @Column(name = "put_transaction")
    private Boolean putTransaction;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "date_transaction")
    private Timestamp dateTransaction;
}
