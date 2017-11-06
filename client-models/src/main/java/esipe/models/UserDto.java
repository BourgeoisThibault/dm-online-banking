package esipe.models;

import lombok.Data;
import lombok.ToString;

import java.sql.Date;

/**
 * @author BOURGEOIS Thibault
 * Date     05/11/2017
 * Time     16:54
 */
@Data
@ToString
public class UserDto {
    private Long id;
    private String lastName;
    private String firstName;
    private String address;
    private String phone;
    private Date birth;
}