package pas.dto;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="usuarios_en_partidas")

public class UsuariosPartida {
	
		//Atributos de videojuego
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id_usuario_partida;
		
		@ManyToOne
	    @JoinColumn(name="id_usuario")
	    private Usuario usuario;
		
		@ManyToOne
	    @JoinColumn(name="id_partida")
	    private Partida partida;

		// Constructores
		
		UsuariosPartida(){
			
		}

		public UsuariosPartida(Long id_usuario_partida, Usuario usuario, Partida partida) {
			this.id_usuario_partida = id_usuario_partida;
			this.usuario = usuario;
			this.partida = partida;
		}
		
		// Getters

		public Long getId_usuario_partida() {
			return id_usuario_partida;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public Partida getPartida() {
			return partida;
		}
		
		// Setters

		public void setId_usuario_partida(Long id_usuario_partida) {
			this.id_usuario_partida = id_usuario_partida;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public void setPartida(Partida partida) {
			this.partida = partida;
		}
		
		

}
