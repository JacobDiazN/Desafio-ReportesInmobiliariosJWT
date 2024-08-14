package cl.praxis.ReportesInmobiliarios.model.service;

import cl.praxis.ReportesInmobiliarios.model.entities.Propiedad;
import cl.praxis.ReportesInmobiliarios.model.repository.PropiedadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropiedadServiceImpl implements PropiedadService {

    private final PropiedadRepository propiedadRepository;

    public PropiedadServiceImpl(PropiedadRepository propiedadRepository) {
        this.propiedadRepository = propiedadRepository;
    }

    @Override
    public List<Propiedad> findAll() {
        return propiedadRepository.findAll();
    }

    @Override
    public Propiedad findOne(int id) {
        return propiedadRepository.findById(id).orElse(null);
    }

    @Override
    public Propiedad update(Propiedad p) {
        return propiedadRepository.save(p);
    }

    @Override
    public Propiedad create(Propiedad p) {
        return propiedadRepository.save(p);
    }

    @Override
    public boolean delete(int id) {
        boolean exist = propiedadRepository.existsById(id);
        if(exist){
            propiedadRepository.deleteById(id);
        }
        return exist;
    }
}
