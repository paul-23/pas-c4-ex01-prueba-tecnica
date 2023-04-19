package pas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pas.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long>{

}
