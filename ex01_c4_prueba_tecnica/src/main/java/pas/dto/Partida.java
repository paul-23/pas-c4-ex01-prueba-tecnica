package pas.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="partidas")

public class Partida {
	
		//Atributos de videojuego
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id_partida;
		
		@Column(name = "nombre_partida")
		private String nombre_partida;
		
		@ManyToOne
	    @JoinColumn(name="id_usuario_creador")
	    private Usuario usuario;
		
		@ManyToOne
	    @JoinColumn(name="id_videojuego")
	    private Videojuego videojuego;
		
		@OneToMany
		@JoinColumn(name="usuario_uep_fk")
		private List<UsuariosPartida> usuarios_en_partida;
		
		@OneToMany
		@JoinColumn(name="partida_mensajes_fk")
		private List<Mensaje> mensaje;

		// Constructores
		
		Partida(){
			
		}

		public Partida(Long id_partida, String nombre_partida, Usuario usuario, Videojuego videojuego) {
			this.id_partida = id_partida;
			this.nombre_partida = nombre_partida;
			this.usuario = usuario;
			this.videojuego = videojuego;
		}

		// Getters
		
		public Long getId_partida() {
			return id_partida;
		}

		public String getNombre_partida() {
			return nombre_partida;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public Videojuego getVideojuego() {
			return videojuego;
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

		public void setId_partida(Long id_partida) {
			this.id_partida = id_partida;
		}

		public void setNombre_partida(String nombre_partida) {
			this.nombre_partida = nombre_partida;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public void setVideojuego(Videojuego videojuego) {
			this.videojuego = videojuego;
		}

		public void setUsuarios_en_partida(List<UsuariosPartida> usuarios_en_partida) {
			this.usuarios_en_partida = usuarios_en_partida;
		}

		public void setMensaje(List<Mensaje> mensaje) {
			this.mensaje = mensaje;
		}

}
