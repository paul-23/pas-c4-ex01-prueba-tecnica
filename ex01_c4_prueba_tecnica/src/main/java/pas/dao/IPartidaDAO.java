package pas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pas.dto.Partida;

public interface IPartidaDAO extends JpaRepository<Partida, Long>{

}
