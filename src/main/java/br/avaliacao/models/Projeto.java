/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.avaliacao.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Projeto")
public class Projeto
{
    @Id
    private Integer cdProjeto;
    
    private String nmProjeto;

    @ManyToOne(fetch=FetchType.EAGER)
    private Usuario usuario;
    /**
     * @return the cdProjeto
     */
    public Integer getCdProjeto()
    {
        return cdProjeto;
    }

    /**
     * @param cdProjeto the cdProjeto to set
     */
    public void setCdProjeto(Integer cdProjeto)
    {
        this.cdProjeto = cdProjeto;
    }

    /**
     * @return the nmProjeto
     */
    public String getNmProjeto()
    {
        return nmProjeto;
    }

    /**
     * @param nmProjeto the nmProjeto to set
     */
    public void setNmProjeto(String nmProjeto)
    {
        this.nmProjeto = nmProjeto;
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
}
