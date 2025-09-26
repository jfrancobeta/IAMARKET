package com.jfranco.aimercado.mercadoai.controllers.Solucion;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionDetailsDTO;
import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionUpdateDTO;
import com.jfranco.aimercado.mercadoai.service.Soluciones.ISolucionesService;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
    public ResponseEntity<?> GetAll( 
        @RequestParam(required = false) String search,
        @RequestParam(required = false) String categoria,
        @RequestParam(required = false) String estado,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {
        try{
            PageRequest pageable = PageRequest.of(page, size);
            return ResponseEntity.ok(solucionesService.getAllSoluciones(search, categoria, estado, pageable));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error al listar soluciones: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetById(@PathVariable Long id) {
        try{
            SolucionDetailsDTO solucion = solucionesService.getSolucionById(id);
            if(solucion != null){
                return ResponseEntity.ok(solucion);
            }else{
                return ResponseEntity.badRequest().body("Solución no encontrada");
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error al obtener la solución");
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> guardar(@RequestBody SolucionCreateDTO solucion) {
        try{
            return ResponseEntity.ok(solucionesService.saveSolucion(solucion));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error al guardar la solución");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody SolucionUpdateDTO solucion) {
        try{
            return ResponseEntity.ok(solucionesService.updateSolucion(id, solucion));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error al editar la solución");
        }
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            solucionesService.eliminarSolucion(id);
            return ResponseEntity.ok(Collections.singletonMap("message", "Solución eliminada"));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error al eliminar la solución");
        }
    }
}
