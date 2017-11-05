package esipe.clientmanagement.user.models;

import lombok.Data;
import lombok.ToString;

/**
 * @author Gokan EKINCI
 */
@Data
@ToString
public class UserDto {
	private Long id;
	private String lastName;
	private String firstName;
	private String address;
	private String phone;

}
