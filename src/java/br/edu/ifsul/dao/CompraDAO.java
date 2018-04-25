/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.rdu.ifsul.cliente.Compra;
import br.rdu.ifsul.cliente.ServicoCompraService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author ROBSON
 */
@Stateless
public class CompraDAO implements Serializable{
    
    private ServicoCompraService cliente;

    public CompraDAO() {
        cliente = new ServicoCompraService();
    }
    
    public List<Compra> getListaCompras(){
        return cliente.getServicoCompraPort().listaCompras();
    }
    
    public void inserir(Compra obj){
        cliente.getServicoCompraPort().inserir(obj);
    }
    
    public void alterar(Compra obj){
        cliente.getServicoCompraPort().alterar(obj);
    }    
    
    public void remover(Integer id){
        cliente.getServicoCompraPort().remover(id);
    }

    public ServicoCompraService getCliente() {
        return cliente;
    }

    public void setCliente(ServicoCompraService cliente) {
        this.cliente = cliente;
    }
    
    
}
