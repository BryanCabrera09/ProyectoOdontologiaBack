package com.sm.odontologia.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;

	@Column(name = "username", length = 25, nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	private boolean enabled = true;

	@OneToOne
	@JoinColumn(name = "id_persona")
	private Persona persona;

	@OneToOne
	@JoinColumn(name = "rolId")
	private Rol rol;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
	private Set<UsuarioRol> usuarioRoles = new HashSet<>();

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> autoridades = new HashSet<>();
		this.usuarioRoles.forEach(usuarioRol -> {
			autoridades.add(new Authority(usuarioRol.getRol().getRolNombre()));
		});
		return autoridades;
	}
}