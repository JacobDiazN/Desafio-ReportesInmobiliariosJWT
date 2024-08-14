package cl.praxis.ReportesInmobiliarios.model.service;

import cl.praxis.ReportesInmobiliarios.model.entities.Propiedad;

import java.util.List;

public interface PropiedadService {
    List<Propiedad> findAll();
    Propiedad findOne(int id);
    Propiedad update(Propiedad p);
    Propiedad create(Propiedad p);
    boolean delete(int id);
}
