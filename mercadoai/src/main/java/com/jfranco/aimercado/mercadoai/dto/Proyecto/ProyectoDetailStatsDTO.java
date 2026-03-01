package com.jfranco.aimercado.mercadoai.dto.Proyecto;

public class ProyectoDetailStatsDTO {
    private int hitosCompletados;
    private int totalHitos;
    private int entregablesPendientes;
    private int entregablesEnRevision;
    private int diasRestantes;
    private double progreso;

    public ProyectoDetailStatsDTO() {}

    public ProyectoDetailStatsDTO(int hitosCompletados, int totalHitos, int entregablesPendientes, int entregablesEnRevision, int diasRestantes, double progreso) {
        this.hitosCompletados = hitosCompletados;
        this.totalHitos = totalHitos;
        this.entregablesPendientes = entregablesPendientes;
        this.entregablesEnRevision = entregablesEnRevision;
        this.diasRestantes = diasRestantes;
        this.progreso = progreso;
    }

    public int getHitosCompletados() { return hitosCompletados; }
    public void setHitosCompletados(int hitosCompletados) { this.hitosCompletados = hitosCompletados; }
    public int getTotalHitos() { return totalHitos; }
    public void setTotalHitos(int totalHitos) { this.totalHitos = totalHitos; }
    public int getEntregablesPendientes() { return entregablesPendientes; }
    public void setEntregablesPendientes(int entregablesPendientes) { this.entregablesPendientes = entregablesPendientes; }
    public int getEntregablesEnRevision() { return entregablesEnRevision; }
    public void setEntregablesEnRevision(int entregablesEnRevision) { this.entregablesEnRevision = entregablesEnRevision; }
    public int getDiasRestantes() { return diasRestantes; }
    public void setDiasRestantes(int diasRestantes) { this.diasRestantes = diasRestantes; }
    public double getProgreso() { return progreso; }
    public void setProgreso(double progreso) { this.progreso = progreso; }
}