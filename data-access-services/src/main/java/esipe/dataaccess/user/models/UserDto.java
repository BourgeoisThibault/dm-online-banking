package esipe.dataaccess.user.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Pattern;

/**
 * @author Gokan EKINCI
 */
@Data
@Builder
@ToString
public class UserDto {
	@Pattern(regexp = "[0-9]{1,}")
	private String id;
	private String lastName;
	private String firstName;
	private String address;
	private String phone;
}
