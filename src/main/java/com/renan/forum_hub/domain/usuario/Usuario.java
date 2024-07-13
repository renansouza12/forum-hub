package com.renan.forum_hub.domain.usuario;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String login;
    private String password;

}
