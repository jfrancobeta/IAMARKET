package com.jfranco.aimercado.mercadoai.dto.Proyecto;

import java.math.BigDecimal;

public class ProyectoStatsDTO {

    private long activeCount;
    private long completedCount;
    private BigDecimal totalRevenue;
    private double avgProgress;

    public ProyectoStatsDTO() {
    }

    public ProyectoStatsDTO(long activeCount, long completedCount, BigDecimal totalRevenue, double avgProgress) {
        this.activeCount = activeCount;
        this.completedCount = completedCount;
        this.totalRevenue = totalRevenue;
        this.avgProgress = avgProgress;
    }

    public long getActiveCount() {
        return activeCount;
    }

    public void setActiveCount(long activeCount) {
        this.activeCount = activeCount;
    }

    public long getCompletedCount() {
        return completedCount;
    }

    public void setCompletedCount(long completedCount) {
        this.completedCount = completedCount;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public double getAvgProgress() {
        return avgProgress;
    }

    public void setAvgProgress(double avgProgress) {
        this.avgProgress = avgProgress;
    }
}