/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CompraDAO;
import br.edu.ifsul.util.Util;
import br.rdu.ifsul.cliente.Compra;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ROBSON
 */
@Named(value = "controleCompra")
@SessionScoped
public class ControleCompra implements Serializable{
    private Compra objeto;
    @EJB
    private CompraDAO dao;
    private Boolean editando;
    
    

    public ControleCompra() {
        editando = false;
    }
    
    public String listar(){
        editando = false;
        return "/privado/listar?faces-redirect=true";
    }
    
     public void novo(){
        objeto = new Compra();
        objeto.setId(0);
        editando = true;
    } 
     
     public void alterar(Compra obj){
        try{
            objeto = obj;
            editando = true;
        }catch (Exception e){
            Util.mensagemErro("Error ao carregar objeto: "+
                    Util.getMensagemErro(e));
        }
    }
     
 
    public void excluir(Integer id){
        try{
            dao.remover(id);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        }catch (Exception e){
            Util.mensagemErro("Error ao remover objeto: "+
                    Util.getMensagemErro(e));
        }
    }
     
    
    public void salvar(){
        objeto.setCepOrigem(objeto.getCepOrigem().replace("-", ""));
        objeto.setCepDestino(objeto.getCepDestino().replace("-", ""));
        try{
            if (objeto.getId() == 0){
                dao.inserir(objeto);
            }else{
                dao.alterar(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
            editando=false;
        }catch(Exception e){
            Util.mensagemErro("Error ao persistir objeto: "+
                    Util.getMensagemErro(e));
        }
    }

    public Compra getObjeto() {
        return objeto;
    }

    public void setObjeto(Compra objeto) {
        this.objeto = objeto;
    }

    public CompraDAO getDao() {
        return dao;
    }

    public void setDao(CompraDAO dao) {
        this.dao = dao;
    }

    public Boolean getEditando() {
        return editando;
    }

    public void setEditando(Boolean editando) {
        this.editando = editando;
    }
    
    
}
