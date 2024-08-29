package ci.digitalacademy.monetab.services.Impl;

import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.repository.UserRepository;
import ci.digitalacademy.monetab.services.UserService;
import ci.digitalacademy.monetab.services.dto.UserDTO;
import ci.digitalacademy.monetab.services.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO save(UserDTO userDTO) {
        log.debug("Request to save user: {}", userDTO);
        User user = UserMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return UserMapper.toUserDTO(user);
    }

    /*
    @Override
    public User update(User user) {
        Optional<User> userOptional = findOne(user.getId());
        if (userOptional.isPresent()) {
            User userToUpdate = userOptional.get();
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setPseudo(user.getPseudo());
            return save(userToUpdate);

        } else {
            throw new IllegalArgumentException();
        }
    } */

    @Override

    public UserDTO update(UserDTO userDTO) {
        log.debug("Request to update user: {}", userDTO);
        User user = UserMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return findOne(userDTO.getId()).map(existingUser ->{
            existingUser.setPseudo(userDTO.getPseudo());
            existingUser.setPassword(userDTO.getPassword());
            existingUser.setCreationDate(userDTO.getCreationDate());
            return save(existingUser);
        }).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public Optional<UserDTO> findOne(Long id) {
        log.debug("Request to one User: {}", id);
        return userRepository.findById(id).map(UserMapper::toUserDTO);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> findAll() {
        log.debug("Request to get all Users");
        return userRepository.findAll().stream().map(user -> {
            return UserMapper.toUserDTO(user);
        }).toList();
    }
}
