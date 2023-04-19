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

public class Mensaje {
	
		//Atributos de videojuego
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id_mensaje;
		
		@Column(name = "contenido_mensaje")
		private String contenido_mensaje;
		
		@ManyToOne
	    @JoinColumn(name="id_partida")
	    private Partida partida;
		
		@ManyToOne
	    @JoinColumn(name="id_usuario_emisor")
	    private Usuario usuario;

		// Constructores
		
		Mensaje(){
			
		}

		public Mensaje(Long id_mensaje, String contenido_mensaje, Partida partida, Usuario usuario) {
			this.id_mensaje = id_mensaje;
			this.contenido_mensaje = contenido_mensaje;
			this.partida = partida;
			this.usuario = usuario;
		}
		
		// Getters

		public Long getId_mensaje() {
			return id_mensaje;
		}

		public String getContenido_mensaje() {
			return contenido_mensaje;
		}

		public Partida getPartida() {
			return partida;
		}

		public Usuario getUsuario() {
			return usuario;
		}
		
		// Setters

		public void setId_mensaje(Long id_mensaje) {
			this.id_mensaje = id_mensaje;
		}

		public void setContenido_mensaje(String contenido_mensaje) {
			this.contenido_mensaje = contenido_mensaje;
		}

		public void setPartida(Partida partida) {
			this.partida = partida;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
		
}
