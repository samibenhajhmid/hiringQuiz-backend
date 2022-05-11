package com.smoothalgo.hiringQuiz.dto;


import com.smoothalgo.hiringQuiz.enumerations.Role;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @Id
    private Long id;
    @NonNull
    private String username;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private Role role;


    @Column(name = "verification_code", length = 64)
    private String verificationCode;

     @NonNull
    private boolean enabled;

}
