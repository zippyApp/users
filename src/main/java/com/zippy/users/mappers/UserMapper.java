package com.zippy.users.mappers;

import com.zippy.users.dto.UserDTO;
import com.zippy.users.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DocumentMapper.class, ReferenceMapper.class})
public interface UserMapper {
    UserDTO UserToUserDTO(User user);
    User UserDTOtoUser(UserDTO userDTO);
}
