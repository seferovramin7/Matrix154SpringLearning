package az.ematrix.matrix154springlearning.mapper;

import az.ematrix.matrix154springlearning.dao.UserDAO;
import az.ematrix.matrix154springlearning.dto.UserDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO daoToDto(UserDAO dao);

    UserDAO dtoToDao(UserDTO dto);

    List<UserDTO> convertDAOListToDTOList(List<UserDAO> daoList);

    List<UserDAO> convertDTOListToDAOList(List<UserDTO> dtoList);
}


