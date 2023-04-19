package pas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pas.dao.IPartidaDAO;
import pas.dto.Partida;

@Service
public class PartidaService {

	@Autowired
	IPartidaDAO iPartidaDAO;

	public List<Partida> listarPartidas() {
		return iPartidaDAO.findAll();
	}

	public Partida guardarPartida(Partida partida) {
		return iPartidaDAO.save(partida);
	}

	public Partida partidaXID(Long id) {
		return iPartidaDAO.findById(id).get();
	}

	public Partida actualiarPartida(Partida partida) {
		return iPartidaDAO.save(partida);
	}

	public void eliminarPartida(Long id) {
		iPartidaDAO.deleteById(id);
	}

}
