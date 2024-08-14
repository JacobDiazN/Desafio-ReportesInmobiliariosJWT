package cl.praxis.ReportesInmobiliarios.model.repository;

import cl.praxis.ReportesInmobiliarios.model.entities.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropiedadRepository extends JpaRepository<Propiedad, Integer> {}
