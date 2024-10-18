package com.quizo.app.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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
@Table(name = "PLAYERS")
public class Player implements UserDetails {

	@EmbeddedId
	private PlayerId id;

	private String password;

	@Builder.Default
	private boolean loggedIn = false;

	// Contact details
	private String firstname;

	private String lastname;

	private String email;

	private String phoneNumber;

	@ManyToMany
	private List<Question> questions;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(Role.PLAYER.name()));
	}

	@Override
	public String getUsername() {
		return id.getRegistrationDetail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !loggedIn;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return UserDetails.super.isEnabled();
	}

}
