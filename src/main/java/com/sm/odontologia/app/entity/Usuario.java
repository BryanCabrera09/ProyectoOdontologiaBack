package com.sm.odontologia.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@Table(name = "usuarios")
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	private String username;
	private String password;
	private String nombre;
	private String apellido;
	private boolean enabled = true;
	private String correo;
	private String numcelular;
	/*@Column(name = "fechanac")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_nac;*/

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
	@JsonIgnore
	private Set<UsuarioRol> usuarioRoles = new HashSet<>();

	public Usuario() {

	}

	public Usuario(String username, String password, String nombre, String apellido, boolean enabled, String correo) {
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.enabled = enabled;
	}

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