package me.changwook.AirBnb.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name="email",unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "real_name", nullable = false)
    private String realName;

    @Builder
    public User(String email, String password, String address, String realName) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.realName = realName;
    }

}
