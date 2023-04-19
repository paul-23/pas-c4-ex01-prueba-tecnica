package pas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pas.dao.IVideojuegoDAO;
import pas.dto.Videojuego;

@Service
public class VideojuegoService {

	@Autowired
	IVideojuegoDAO iVideojuegoDAO;

	public List<Videojuego> listarVideojuego() {
		return iVideojuegoDAO.findAll();
	}

	public Videojuego guardarVideojuego(Videojuego videojuego) {
		return iVideojuegoDAO.save(videojuego);
	}

	public Videojuego videojuegoXID(Long id) {
		return iVideojuegoDAO.findById(id).get();
	}

	public Videojuego actualiarVideojuego(Videojuego videojuego) {
		return iVideojuegoDAO.save(videojuego);
	}

	public void eliminarVideojuego(Long id) {
		iVideojuegoDAO.deleteById(id);
	}

}
