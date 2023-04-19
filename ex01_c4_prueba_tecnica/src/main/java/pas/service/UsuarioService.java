package pas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pas.dao.IUsuarioPartidaDAO;
import pas.dto.UsuariosPartida;

@Service
public class UsuarioService {

	@Autowired
	IUsuarioPartidaDAO iUsuarioPartidaDAO;

	public List<UsuariosPartida> listarUsuariosPartida() {
		return iUsuarioPartidaDAO.findAll();
	}

	public UsuariosPartida guardarUsuarioPartida(UsuariosPartida usuariosPartida) {
		return iUsuarioPartidaDAO.save(usuariosPartida);
	}

	public UsuariosPartida usuarioPartidaXID(Long id) {
		return iUsuarioPartidaDAO.findById(id).get();
	}

	public UsuariosPartida actualiarUsuarioPartida(UsuariosPartida usuariosPartida) {
		return iUsuarioPartidaDAO.save(usuariosPartida);
	}

	public void eliminarUsuarioPartida(Long id) {
		iUsuarioPartidaDAO.deleteById(id);
	}

}
