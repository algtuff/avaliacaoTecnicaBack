/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.avaliacao.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "TIPO_USUARIO")
public class TipoUsuario
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer cdTipoUsuario;
    
    private String dsTipo;

    /**
     * @return the cdTipoUsuario
     */
    public Integer getCdTipoUsuario()
    {
        return cdTipoUsuario;
    }

    /**
     * @param cdTipoUsuario the cdTipoUsuario to set
     */
    public void setCdTipoUsuario(Integer cdTipoUsuario)
    {
        this.cdTipoUsuario = cdTipoUsuario;
    }

    /**
     * @return the dsTipo
     */
    public String getDsTipo()
    {
        return dsTipo;
    }

    /**
     * @param dsTipo the dsTipo to set
     */
    public void setDsTipo(String dsTipo)
    {
        this.dsTipo = dsTipo;
    }
}
