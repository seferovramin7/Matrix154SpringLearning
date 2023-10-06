package az.ematrix.matrix154springlearning.service;

import az.ematrix.matrix154springlearning.dao.UserDAO;
import az.ematrix.matrix154springlearning.dto.UserDTO;
import az.ematrix.matrix154springlearning.mapper.UserMapper;
import az.ematrix.matrix154springlearning.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper = UserMapper.INSTANCE;
    private final UserRepository userRepository;


    public UserDTO findUserById(Long id) {
        UserDAO userDAO = userRepository.findById(id).orElse(null);
        return userMapper.daoToDto(userDAO);
    }

    public List<UserDTO> findAllUsers() {
        List<UserDAO> userDAOList = userRepository.findAll();
        return userMapper.convertDAOListToDTOList(userDAOList);
    }

    public void createUser(UserDTO userDTO) {
        UserDAO userDAO = userMapper.dtoToDao(userDTO);
        userRepository.save(userDAO);
    }

    public void updateUser(Long id, UserDTO userDTO) {
        UserDAO existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            userDTO.setId(id);
            UserDAO updatedUser = userMapper.dtoToDao(userDTO);
            userRepository.save(updatedUser);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

