package dev.engripaye.backend.model;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    private String fullname;
    private String email;
    private String balance;

}
