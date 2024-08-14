package cl.praxis.ReportesInmobiliarios.controller;

import cl.praxis.ReportesInmobiliarios.model.entities.Propiedad;
import cl.praxis.ReportesInmobiliarios.model.service.PropiedadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propiedades")
public class PropiedadRestController {

    private final PropiedadService service;

    public PropiedadRestController(PropiedadService service) {
        this.service = service;
    }

    private HttpStatus status = HttpStatus.OK;

    @GetMapping
    public ResponseEntity<List<Propiedad>> findAll(){
        List<Propiedad> actors = service.findAll();
        if(actors == null || actors.isEmpty()){
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(actors, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propiedad> findOne(@PathVariable("id") int id){
        Propiedad propiedad = service.findOne(id);
        if(propiedad == null){
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(propiedad, status);
    }

    @PostMapping
    public ResponseEntity<Propiedad> create(@RequestBody Propiedad p){
        Propiedad propiedad = service.create(p);
        if(propiedad == null){
            status = HttpStatus.CONFLICT;
        }else{
            status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(propiedad, status);
    }

    @PutMapping
    public ResponseEntity<Propiedad> update(@RequestBody Propiedad p){
        Propiedad propiedad = service.update(p);
        if(propiedad == null){
            status = HttpStatus.CONFLICT;
        }else{
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(propiedad, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean deleted = service.delete(id);

        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }
}
