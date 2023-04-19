package pas.dto;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="usuarios")
public class Usuario  {
	
	//Atributos de usuario
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	
	@Column(name = "nombre_usuario")
	private String nombre_usuario;
	
	@Column(name = "correo_electronico")
	private String correo_electronico;
	
	@Column(name = "contrasena")
	private String contrasena;
	
    @OneToMany
    @JoinColumn(name="usuario_creador_partida_fk")
    private List<Partida> partida;
    
    @OneToMany
    @JoinColumn(name="usuario_uep_fk")
    private List<UsuariosPartida> usuarios_en_partida;
    
    @OneToMany
    @JoinColumn(name="usuario_emisor_mensajes_fk")
    private List<Mensaje> mensaje;
    
    // Constructores
	
	public Usuario() {
		
	}

	public Usuario(Long id_usuario, String nombre_usuario, String correo_electronico, String contrasena) {
		this.id_usuario = id_usuario;
		this.nombre_usuario = nombre_usuario;
		this.correo_electronico = correo_electronico;
		this.contrasena = contrasena;
	}
	
	// Getteres

	public Long getId_usuario() {
		return id_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public String getContrasena() {
		return contrasena;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Partida")
	public List<Partida> getPartida() {
		return partida;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Usuarios_en_partida")
	public List<UsuariosPartida> getUsuarios_en_partida() {
		return usuarios_en_partida;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Mensaje")
	public List<Mensaje> getMensaje() {
		return mensaje;
	}
	
	// Setters
	
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Partida")
	public void setPartida(List<Partida> partida) {
		this.partida = partida;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Usuarios_en_partida")
	public void setUsuarios_en_partida(List<UsuariosPartida> usuarios_en_partida) {
		this.usuarios_en_partida = usuarios_en_partida;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Mensaje")
	public void setMensaje(List<Mensaje> mensaje) {
		this.mensaje = mensaje;
	}

	
}
