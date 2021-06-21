/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.avaliacao.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "Projeto_usuario_horas")
public class ProjetoUsuarioHoras implements Serializable
{

    @Id @GeneratedValue
    private Integer cdProjetoUsuarioHoras;
    
    private Double horas;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    
    @ManyToOne(fetch=FetchType.EAGER)
    private Usuario usuario;

    @ManyToOne(fetch=FetchType.EAGER)
    private Projeto projeto;

    /**
     * @return the cdProjetoUsuarioHoras
     */
    public Integer getCdProjetoUsuarioHoras()
    {
        return cdProjetoUsuarioHoras;
    }

    /**
     * @param cdProjetoUsuarioHoras the cdProjetoUsuarioHoras to set
     */
    public void setCdProjetoUsuarioHoras(Integer cdProjetoUsuarioHoras)
    {
        this.cdProjetoUsuarioHoras = cdProjetoUsuarioHoras;
    }

    /**
     * @return the horas
     */
    public Double getHoras()
    {
        return horas;
    }

    /**
     * @param horas the horas to set
     */
    public void setHoras(Double horas)
    {
        this.horas = horas;
    }

    /**
     * @return the data
     */
    public Date getData()
    {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data)
    {
        this.data = data;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario()
    {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    /**
     * @return the projeto
     */
    public Projeto getProjeto()
    {
        return projeto;
    }

    /**
     * @param projeto the projeto to set
     */
    public void setProjeto(Projeto projeto)
    {
        this.projeto = projeto;
    }
}