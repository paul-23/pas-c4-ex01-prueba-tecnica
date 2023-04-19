package pas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pas.dao.IMensajeDAO;
import pas.dto.Mensaje;

@Service
public class MensajeService {

	@Autowired
	IMensajeDAO iMensajeDAO;

	public List<Mensaje> listarMensajes() {
		return iMensajeDAO.findAll();
	}
	
	public Mensaje guardarMensajes(Mensaje mensaje) {
		return iMensajeDAO.save(mensaje);
	}

	public Mensaje mensajesXID(Long id) {
		return iMensajeDAO.findById(id).get();
	}

	public Mensaje actualiarMensaje(Mensaje mensaje) {
		return iMensajeDAO.save(mensaje);
	}

	public void eliminarMensaje(Long id) {
		iMensajeDAO.deleteById(id);
	}

}
