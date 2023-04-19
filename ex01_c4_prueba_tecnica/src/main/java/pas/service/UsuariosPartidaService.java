package pas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pas.dao.IUsuarioDAO;
import pas.dto.Usuario;

@Service
public class UsuariosPartidaService {

	@Autowired
	IUsuarioDAO iUsuarioDAO;

	public List<Usuario> listarUsuarios() {
		return iUsuarioDAO.findAll();
	}

	public Usuario guardarUsuario(Usuario usuario) {
		return iUsuarioDAO.save(usuario);
	}

	public Usuario usuarioXID(Long id) {
		return iUsuarioDAO.findById(id).get();
	}

	public Usuario actualiarUsuario(Usuario usuario) {
		return iUsuarioDAO.save(usuario);
	}

	public void eliminarUsuario(Long id) {
		iUsuarioDAO.deleteById(id);
	}

}
