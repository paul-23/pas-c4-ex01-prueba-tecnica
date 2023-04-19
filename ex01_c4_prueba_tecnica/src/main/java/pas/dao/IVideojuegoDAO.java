package pas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pas.dto.Videojuego;

public interface IVideojuegoDAO extends JpaRepository<Videojuego, Long>{

}
