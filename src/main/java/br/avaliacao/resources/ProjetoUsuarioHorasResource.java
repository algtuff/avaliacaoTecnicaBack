/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.avaliacao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.avaliacao.models.ProjetoUsuarioHoras;
import br.avaliacao.models.Usuario;
import br.avaliacao.repository.ProjetoUsuarioHorasRepository;
import br.avaliacao.repository.UsuarioRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author andre
 */
@RestController
@RequestMapping(value="/avaliacaoTecnicaBack")
@CrossOrigin(origins = "*")
public class ProjetoUsuarioHorasResource
{
    @Autowired
    ProjetoUsuarioHorasRepository projetoUsuarioHorasRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/apontarHoras")
    public ProjetoUsuarioHoras apontarHoras(@RequestBody ProjetoUsuarioHoras projetoUsuarioHoras){
        return projetoUsuarioHorasRepository.save(projetoUsuarioHoras);
    }

    @GetMapping("/projetoUsuarioHoras")
    public List<ProjetoUsuarioHoras> projetoUsuarioHoras(){
        return projetoUsuarioHorasRepository.findAll();
    }
    
    @GetMapping("/projetoUsuarioHoras/usuario/{cdUsuario}/projeto/{cdProjeto}")
    public List<ProjetoUsuarioHoras> listHoras(@PathVariable(value="cdUsuario") Integer cdUsuario, @PathVariable(value="cdProjeto") Integer cdProjeto){
        Usuario usuario = usuarioRepository.findById(cdUsuario).get();
        if(1==usuario.getTipoUsuario().getCdTipoUsuario()){
            return projetoUsuarioHorasRepository.listaProjetoUsuarioHoras(cdProjeto);
        }
        else{
            return projetoUsuarioHorasRepository.listaProjetoUsuarioHoras(cdUsuario,cdProjeto);
        }
    }

    @GetMapping("/totalDeHoras/projeto/{cdProjeto}")
    public TotalHorasDto listHoras(@PathVariable(value="cdProjeto") Integer cdProjeto){
        TotalHorasDto dto = new TotalHorasDto();
        dto.setTotal(projetoUsuarioHorasRepository.totalHoras(cdProjeto));
        return dto;
    }
    
    class TotalHorasDto{
        private Double total;

        /**
         * @return the total
         */
        public Double getTotal()
        {
            return total;
        }

        /**
         * @param total the total to set
         */
        public void setTotal(Double total)
        {
            this.total = total;
        }
    }

}
