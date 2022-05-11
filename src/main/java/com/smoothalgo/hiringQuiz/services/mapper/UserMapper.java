package com.smoothalgo.hiringQuiz.services.mapper;

import com.smoothalgo.hiringQuiz.dto.UserDTO;
import com.smoothalgo.hiringQuiz.entities.User;


public class UserMapper implements EntityMapper<UserDTO, User> {

    @Override
    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setVerificationCode(dto.getVerificationCode());
        user.setEnabled(dto.isEnabled());

        return user;
    }

    @Override
    public UserDTO toDto(User entity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(entity.getId());
        userDTO.setUsername(entity.getUsername());
        userDTO.setEmail(entity.getEmail());
        userDTO.setPassword(entity.getPassword());
        userDTO.setRole(entity.getRole());
        userDTO.setVerificationCode(entity.getVerificationCode());
        userDTO.setEnabled(entity.isEnabled());

        return userDTO;
    }


}
