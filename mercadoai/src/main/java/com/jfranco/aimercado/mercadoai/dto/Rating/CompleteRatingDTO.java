package com.jfranco.aimercado.mercadoai.dto.Rating;

public class CompleteRatingDTO {
    private int calificacion;
    private String comentario;

    public CompleteRatingDTO() {
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
