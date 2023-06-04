package com.example.ecommerce_online.model.entity;

import com.example.ecommerce_online.model.enums.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "first_name", nullable = false, length = 50)
    String firstName;
    @Column(name = "last_name", nullable = false, length = 50)
    String lastName;
    @Column(unique = true, length = 50, nullable = false)
    String email;
    @Column(name = "phone_number", length = 15)
    String phoneNumber;
    String address;
    @Column(name = "payment_details")
    String paymentDetails;
    @Enumerated(EnumType.STRING)
    Role role;
    @Column(unique = true)
    String login;
    String password;
    @Column(name = "active", columnDefinition = "boolean default false")
    Boolean isActive;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.toString()));
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
