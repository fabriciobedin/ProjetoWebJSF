/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fabricio
 */
@Stateless
public class CompraprodutoFacade extends AbstractFacade<Compraproduto> {

    @PersistenceContext(unitName = "ProjetoWebJSFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompraprodutoFacade() {
        super(Compraproduto.class);
    }
    
}
