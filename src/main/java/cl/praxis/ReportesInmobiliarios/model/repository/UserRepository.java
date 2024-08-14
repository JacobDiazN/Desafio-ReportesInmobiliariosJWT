package cl.praxis.ReportesInmobiliarios.model.repository;

import cl.praxis.ReportesInmobiliarios.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
