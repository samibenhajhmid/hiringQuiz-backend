package com.smoothalgo.hiringQuiz.dto;


import lombok.*;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientLoginDTO {
    @Id
    private Long id;
    @NonNull
    private String email;
    @NonNull
    private String password;
}
