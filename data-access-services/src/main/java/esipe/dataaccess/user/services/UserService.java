package esipe.dataaccess.user.services;

import esipe.dataaccess.user.entities.UserEntity;
import esipe.dataaccess.user.models.UserDto;
import esipe.dataaccess.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService implements IUserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<UserDto> getAll() {
		return userRepository.findAll()
			.stream()
			.map(
				u -> UserDto.builder()
				.id(String.valueOf(u.getId()))
				.firstName(u.getFirstName())
				.lastName(u.getLastName())
						.address(u.getAddress())
						.phone(u.getPhone())
				.build()
			)
			.collect(Collectors.toList());
	}

	@Override
	public Optional<UserDto> getUserById(String id) {
		UserEntity userEntity = userRepository.findOne(Long.parseLong(id));
		return (userEntity != null) ?
			Optional.of(
				UserDto.builder()
					.id(String.valueOf(userEntity.getId()))
					.firstName(userEntity.getFirstName())
					.lastName(userEntity.getLastName())
						.address(userEntity.getAddress())
						.phone(userEntity.getPhone())
					.build()
			)
			: Optional.empty();
	}

	@Override
	public UserDto create(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(userDto.getFirstName());
		userEntity.setLastName(userDto.getLastName());
		userEntity.setAddress(userDto.getAddress());
		userEntity.setPhone(userDto.getPhone());

		UserEntity userEntity1 = userRepository.save(userEntity);
		return UserDto.builder()
			.id(String.valueOf(userEntity1.getId()))
			.firstName(userEntity1.getFirstName())
			.lastName(userEntity1.getLastName())
				.address(userEntity1.getAddress())
				.phone(userEntity1.getPhone())
			.build();
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}

	@Override
	public void update(Long id, UserDto userDto) {

		Optional<UserDto> userBdd = this.getUserById(id.toString());

		UserEntity userEntity = new UserEntity();
		userEntity.setId(id);
		userEntity.setFirstName(userBdd.get().getFirstName());
		userEntity.setLastName(userBdd.get().getLastName());
		userEntity.setAddress(userDto.getAddress());
		userEntity.setPhone(userDto.getPhone());

		userRepository.save(userEntity);
	}
}
