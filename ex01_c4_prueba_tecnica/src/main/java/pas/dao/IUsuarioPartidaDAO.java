package pas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pas.dto.UsuariosPartida;

public interface IUsuarioPartidaDAO extends JpaRepository<UsuariosPartida, Long>{

}
