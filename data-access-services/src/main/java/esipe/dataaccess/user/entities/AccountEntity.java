package esipe.dataaccess.user.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * @author BOURGEOIS Thibault
 * Date     05/11/2017
 * Time     01:49
 */
@Data
@Entity(name = "account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserEntity userEntity;

    @Column(name = "type_account")
    private String type_account;

    @Column(name = "solde")
    private double solde;
}
