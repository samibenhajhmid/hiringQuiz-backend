package com.smoothalgo.hiringQuiz.controllers;

import com.smoothalgo.hiringQuiz.dto.SessionDTO;
import com.smoothalgo.hiringQuiz.entities.Session;
import com.smoothalgo.hiringQuiz.services.ISessionService;
import com.smoothalgo.hiringQuiz.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SessionController {
    @Autowired
    private ISessionService iSessionService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/sessions")
    public List<SessionDTO> findAll() {
        return iSessionService.findAllSession();
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/sessions/create")
    public SessionDTO addSession(@RequestBody SessionDTO sessionDTO) {
        Date date = new Date();
        sessionDTO.setCreationDate(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        sessionDTO.setSessionNote(1);
        return iSessionService.addSession(sessionDTO);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/sessions/{idSession}")
    public SessionDTO findSession(@PathVariable(name = "idSession") Long id) {
        return iSessionService.findSession(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/sessions/{id}")
    public void deleteSession(@PathVariable Long id) {
        iSessionService.deleteSession(id);
    }


}
