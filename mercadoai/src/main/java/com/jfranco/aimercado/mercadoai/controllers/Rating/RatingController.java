package com.jfranco.aimercado.mercadoai.controllers.Rating;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jfranco.aimercado.mercadoai.dto.Rating.CompleteRatingDTO;
import com.jfranco.aimercado.mercadoai.dto.Rating.PendingRatingDTO;
import com.jfranco.aimercado.mercadoai.dto.Rating.RatingDTO;
import com.jfranco.aimercado.mercadoai.service.Calificacion.ICalificacionService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private ICalificacionService calificacionService;
    
    @PreAuthorize("hasAnyRole('ADMIN','COMPANY','DEVELOPER')")
    @PostMapping("/{id}/complete")
    public ResponseEntity<RatingDTO> completeRating(
            @PathVariable Long id,
            @RequestBody CompleteRatingDTO dto) {
        RatingDTO rating = calificacionService.completeRating(id, dto);
        return ResponseEntity.ok(rating);
    }

    // Get the next pending rating for the authenticated user
    @PreAuthorize("hasAnyRole('ADMIN','COMPANY','DEVELOPER')")
    @GetMapping("/pending")
    public ResponseEntity<List<PendingRatingDTO>> getPendingRating(@AuthenticationPrincipal String principal) {
        List<PendingRatingDTO> pending = calificacionService.getPendingRating(principal);
        return ResponseEntity.ok(pending);
    }

    @PreAuthorize("hasAnyRole('ADMIN','COMPANY','DEVELOPER')")
    @GetMapping("/received")
    public ResponseEntity<List<RatingDTO>> getRatingsReceived(@AuthenticationPrincipal String principal) {
        List<RatingDTO> ratings = calificacionService.getRatingRecived(principal);
        return ResponseEntity.ok(ratings);
    }

     // Get ratings given by the authenticated user
    @PreAuthorize("hasAnyRole('ADMIN','COMPANY','DEVELOPER')")
    @GetMapping("/given")
    public ResponseEntity<List<RatingDTO>> getRatingsGiven(@AuthenticationPrincipal String principal) {
        List<RatingDTO> ratings = calificacionService.getRatingGiven(principal);
        return ResponseEntity.ok(ratings);
    }   

    // Get ratings for a project
    @PreAuthorize("hasAnyRole('ADMIN','COMPANY','DEVELOPER')")
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<RatingDTO>> getRatingsByProject(@PathVariable Long projectId) {
        List<RatingDTO> ratings = calificacionService.getAllRatingsByProjectId(projectId);
        return ResponseEntity.ok(ratings);
    }
}
