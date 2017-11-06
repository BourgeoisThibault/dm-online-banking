package esipe.dataaccess.user.services;

import esipe.dataaccess.user.entities.UserEntity;
import esipe.models.*;
import esipe.dataaccess.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.dozer.DozerBeanMapper;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService implements IUserService {

	DozerBeanMapper mapper = new DozerBeanMapper();

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
						u -> mapper.map(u, UserDto.class)
				)
				.collect(Collectors.toList());
	}

	@Override
	public UserDto getUserById(Long id) throws Exception {
		UserEntity userEntity = userRepository.findOne(id);

		if(userEntity == null)
			throw new Exception("User inconnu");

		return mapper.map(userEntity, UserDto.class);
	}

	@Override
	public UserDto create(UserDto userDto) {

		UserEntity userEntity = userRepository.save(mapper.map(userDto,UserEntity.class));

		return mapper.map(userEntity, UserDto.class);
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}

	@Override
	public void update(Long id, UserDto userDto) throws Exception {

		UserEntity userEntity = userRepository.findOne(id);

		if(userEntity != null) {

			if(userDto.getAddress() != null)
				userEntity.setAddress(userDto.getAddress());

			if(userDto.getPhone() != null)
				userEntity.setPhone(userDto.getPhone());

			userRepository.save(userEntity);
		} else {
			throw new Exception("User inconnu");
		}
	}
}
