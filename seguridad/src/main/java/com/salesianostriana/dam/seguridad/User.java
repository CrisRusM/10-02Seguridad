package com.salesianostriana.dam.seguridad;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user_entity")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor @AllArgsConstructor
@Builder
public class User implements UserDetails{

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Builder.Default
    private boolean enabled = true;

    @Builder.Default
    private String role = "USER";


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Set.of(new SimpleGrantedAuthority("ROLE_"+ this.role));
    }
}
