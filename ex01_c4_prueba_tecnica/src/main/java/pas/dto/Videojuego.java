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
@Table(name="videojuegos")

public class Videojuego {
	
		//Atributos de videojuego
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id_videojuego;
		
		@Column(name = "nombre_videojuego")
		private String nombre_videojuego;
		
		@OneToMany
	    @JoinColumn(name="videojuego_partida_fk")
	    private List<Partida> partida;

		// Constructores
		
		public Videojuego() {
			
		}
		
		public Videojuego(Long id_videojuego, String nombre_videojuego) {
			this.id_videojuego = id_videojuego;
			this.nombre_videojuego = nombre_videojuego;
		}
		
		// Getters
		
		public Long getId_videojuego() {
			return id_videojuego;
		}

		public String getNombre_videojuego() {
			return nombre_videojuego;
		}

		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Partida")
		public List<Partida> getPartida() {
			return partida;
		}
		
		// Setters

		public void setId_videojuego(Long id_videojuego) {
			this.id_videojuego = id_videojuego;
		}

		public void setNombre_videojuego(String nombre_videojuego) {
			this.nombre_videojuego = nombre_videojuego;
		}

		public void setPartida(List<Partida> partida) {
			this.partida = partida;
		}
		
		

		

}
