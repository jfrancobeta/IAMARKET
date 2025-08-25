package com.jfranco.aimercado.mercadoai.controllers.Solucion;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jfranco.aimercado.mercadoai.model.Solucion;
import com.jfranco.aimercado.mercadoai.service.Soluciones.ISolucionesService;

import java.util.Optional;
//probando una cosa cambio en el main
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/soluciones")
public class SolucionesController {


    @Autowired
    private ISolucionesService solucionesService;
    @GetMapping("/")
    public ResponseEntity<?> Listar(@RequestParam String param) {
        return ResponseEntity.ok(solucionesService.getAllSoluciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ListarID(@PathVariable Long id) {
        return ResponseEntity.ok(solucionesService.getSolucionById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> guardar(@RequestBody Solucion solucion) {
        Solucion entity = solucionesService.saveSolucion(solucion);
        if (entity == null) {
            return ResponseEntity.badRequest().body("Error al guardar la solución");
        }
        return ResponseEntity.ok(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Solucion solucion) {
        Optional<Solucion> solOptional = Optional.of(solucionesService.getSolucionById(id));
        if (solOptional.isPresent()) {
            Solucion solucionbd = solOptional.get();
            solucionbd.setTitulo(solucion.getTitulo());
            solucionbd.setDescripcion(solucion.getDescripcion());
            solucionbd.setPrecio(solucion.getPrecio());
            solucionbd.setCategoria(solucion.getCategoria());
            solucionbd.setEntrega(solucion.getEntrega());
            return ResponseEntity.ok(solucionesService.saveSolucion(solucionbd));
        }
        return ResponseEntity.badRequest().body("Error al editar la solución");
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
    
        solucionesService.eliminarSolucion(id);
        return ResponseEntity.ok("Solución eliminada con éxito");
    }

    
    
    
    
}
