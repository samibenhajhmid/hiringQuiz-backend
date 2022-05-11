package com.smoothalgo.hiringQuiz.services.implemtation;

import com.smoothalgo.hiringQuiz.dao.UserRepository;
import com.smoothalgo.hiringQuiz.dto.UserDTO;

import com.smoothalgo.hiringQuiz.entities.ConfirmationToken;
import com.smoothalgo.hiringQuiz.entities.User;
import com.smoothalgo.hiringQuiz.enumerations.Role;
import com.smoothalgo.hiringQuiz.services.IConfirmationTokenService;
import com.smoothalgo.hiringQuiz.services.IUserService;

import com.smoothalgo.hiringQuiz.services.mapper.UserMapper;
import lombok.AllArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;
    UserMapper userMapper = new UserMapper();
    private final Logger log = LoggerFactory.getLogger(QuizServiceImpl.class);
    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ConfirmationTokenService confirmationTokenService;



    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        log.debug("Request to save User : {}", userDTO);
        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        log.debug("Request to delete User : {}", id);
        userRepository.deleteById(id);

    }

    @Override
    public Optional<UserDTO> findUser(Long id) {

        return userRepository.findById(id)
                .map(userMapper::toDto);
    }


    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO = new ArrayList<>();

        for (User user : users) {
            usersDTO.add(userMapper.toDto(user));

        }
        return usersDTO;
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        User user = new User();
        user = userRepository.findByEmail(email).get();
        UserDTO userDTO = new UserDTO();
        userDTO = userMapper.toDto(user);
        return userDTO;

    }

    @Override
    public UserDTO findUserByEmailAndPassword(String email, String password) {
        User user = new User();
        user = userRepository.findByEmailAndPassword(email, password);
        UserDTO userDTO = new UserDTO();
        userDTO = userMapper.toDto(user);
        return userDTO;
    }

    @Override
    public List<UserDTO> findUserByRole(Role role) {
        List<User> users = userRepository.findByRole(role);
        List<UserDTO> usersDTO = new ArrayList<>();

        for (User user : users) {
            usersDTO.add(userMapper.toDto(user));

        }
        return usersDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }


    public String signUpUser(User user) {
        boolean userExists = userRepository
                .findByEmail(user.getEmail())
                .isPresent();

        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(user.getPassword());

        user.setPassword(encodedPassword);

        userRepository.save(user);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);

//        TODO: SEND EMAIL

        return token;
    }

    public int enableAppUser(String email) {
        return userRepository.enableUser(email);
    }

}
