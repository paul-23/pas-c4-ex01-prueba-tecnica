package pas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pas.dto.Mensaje;

public interface IMensajeDAO extends JpaRepository<Mensaje, Long>{

}
