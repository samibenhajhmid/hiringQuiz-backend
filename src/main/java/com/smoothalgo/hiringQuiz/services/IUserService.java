package com.smoothalgo.hiringQuiz.services;


import com.smoothalgo.hiringQuiz.dto.UserDTO;
import com.smoothalgo.hiringQuiz.entities.User;
import com.smoothalgo.hiringQuiz.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

public interface IUserService extends UserDetailsService {

    public UserDTO saveUser(UserDTO userDTO);

    public void deleteUser(Long id);

    public Optional<UserDTO> findUser(Long id);

    public List<UserDTO> findAll();

    public UserDTO findUserByEmail(String email);

    public UserDTO findUserByEmailAndPassword(String email, String password);

    public List<UserDTO> findUserByRole(Role role);
}
