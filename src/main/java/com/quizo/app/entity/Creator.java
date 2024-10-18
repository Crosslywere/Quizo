package com.quizo.app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CREATORS")
public class Creator implements UserDetails {

	@Id
	@GeneratedValue
	private Long id;

	private String email;

	private String password;

	// Used to generate a short link to any exam they create
	// Therefore this value should be unique and not nullable
	// There probably shouldn't be spaces in the nickname
	private String nickname;

	@Builder.Default
	private List<Role> roles = List.of(Role.CREATOR);

	@OneToMany(orphanRemoval = true)
	private List<Quiz> quizzes;

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return UserDetails.super.isEnabled();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.name())).toList();
	}

	@Override
	public String getUsername() {
		return email;
	}

}
