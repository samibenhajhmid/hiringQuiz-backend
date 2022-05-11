package com.smoothalgo.hiringQuiz.controllers;


import com.smoothalgo.hiringQuiz.dto.CandidateLoginDTO;
import com.smoothalgo.hiringQuiz.dto.UserDTO;
import com.smoothalgo.hiringQuiz.entities.User;
import com.smoothalgo.hiringQuiz.enumerations.Role;
import com.smoothalgo.hiringQuiz.services.IAssessmentService;
import com.smoothalgo.hiringQuiz.services.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IAssessmentService iAssessmentService;

    private final Logger log = LoggerFactory.getLogger(QuizController.class);

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users")
    public List<UserDTO> findAll() {
        log.debug("REST request to get all quizzes");
        return iUserService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/users/signup")
    public UserDTO createUser(@RequestBody UserDTO userDTO) throws Exception {
        return iUserService.saveUser(userDTO);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/clientLogin")
    public UserDTO loginUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();
        String tempPass = user.getPassword();
        UserDTO userObj = null;
        if (tempEmail != null && tempPass != null) {
            userObj = iUserService.findUserByEmailAndPassword(tempEmail, tempPass);
        }
        if (userObj == null) {
            throw new Exception("bad credentials");
        }
        return userObj;


    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users/{idUser}")
    public User findUser(@PathVariable(name = "idUser") Long id) {
        return null;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        iUserService.deleteUser(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/users/update/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        return iUserService.saveUser(userDTO);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/candidates")
    public List<UserDTO> findAllCandidates() {
        return iUserService.findUserByRole(Role.USER);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/assessmentTakerLogin")
    public CandidateLoginDTO loginCandidate(@RequestBody CandidateLoginDTO candidateLoginDTO) throws Exception {
        String tempEmail = candidateLoginDTO.getEmail();
        String tempPass = candidateLoginDTO.getPassword();
        String assessmentCode = iAssessmentService.findByAssessmentCode(candidateLoginDTO.getAssessmentCode())
                .getAssessmentCode();
        UserDTO userObj = null;
        if (tempEmail != null && tempPass != null) {
            userObj = iUserService.findUserByEmailAndPassword(tempEmail, tempPass);
        }
        if (userObj == null) {
            throw new Exception("bad credentials");
        }
        if ((userObj.getRole() != Role.USER)) {
            throw new Exception("only candidate can login");
        }
        if (assessmentCode == null) {
            throw new Exception("invalid Assessment Code");
        }
        candidateLoginDTO.setId(userObj.getId());
        candidateLoginDTO.setEmail(userObj.getEmail());
        candidateLoginDTO.setPassword(userObj.getPassword());

        return candidateLoginDTO;
    }




}