package com.jfranco.aimercado.mercadoai.dto.Auth;


import java.util.List;

import com.jfranco.aimercado.mercadoai.model.Role;
//dto form
public class RegistroRequest {
    private String username;
    private String email;
    private String password;
    private Integer userType; // 0: Compañía, 1: Desarrollador
    private String nombre;
    private String descripcion;
    private Long pais;
    private List<Role> roles;

    // Campos específicos para desarrollador
    private List<Long> habilidades;
    private Integer experiencia;
    private String portafolioURL;

    // Campos específicos para compañía
    private String nombreCompania;
    private Long industria;
    private String website;
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Long> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Long> habilidades) {
        this.habilidades = habilidades;
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Integer experiencia) {
        this.experiencia = experiencia;
    }

    public String getPortafolioURL() {
        return portafolioURL;
    }

    public void setPortafolioURL(String portafolioURL) {
        this.portafolioURL = portafolioURL;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public Long getIndustria() {
        return industria;
    }

    public void setIndustria(Long industria) {
        this.industria = industria;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Long getPais() {
        return pais;
    }

    public void setPais(Long pais) {
        this.pais = pais;
    }
}
