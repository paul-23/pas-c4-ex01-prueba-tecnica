package pas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pas.dto.Videojuego;
import pas.service.VideojuegoService;

@RestController
@RequestMapping("/api")
public class VideojuegoController {

	@Autowired
	VideojuegoService videojuegoService;

	@GetMapping("/videojuegos")
	public List<Videojuego> listarVideojuego() {
		return videojuegoService.listarVideojuego();
	}

	@GetMapping("/videojuegos/{id}")
	public Videojuego videojuegoXID(@PathVariable(name = "id") Long id) {

		Videojuego videojuegoXID = new Videojuego();
		videojuegoXID = videojuegoService.videojuegoXID(id);
		return videojuegoXID;
	}

	@PostMapping("/videojuegos")
	public Videojuego guardarVideojuego(@RequestBody Videojuego videojuego) {
		return videojuegoService.guardarVideojuego(videojuego);
	}

	@PutMapping("/videojuegos/{id}")
	public Videojuego actualiarVideojuego(@PathVariable(name = "id") Long id, @RequestBody Videojuego videojuego) {
		Videojuego videojuegoSeleccionado = new Videojuego();
		Videojuego videojuegoActualizado = new Videojuego();

		videojuegoSeleccionado = videojuegoService.videojuegoXID(id);

		videojuegoSeleccionado.setNombre_videojuego(videojuego.getNombre_videojuego());

		videojuegoActualizado = videojuegoService.actualiarVideojuego(videojuegoSeleccionado);
		return videojuegoActualizado;
	}

	@DeleteMapping("/videojuego/{id}")
	public void eliminarVideojuego(@PathVariable(name = "id") Long id) {
		videojuegoService.eliminarVideojuego(id);
	}

}
