/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.simba.ourdata.dao;


/**
 *
 * @author kieckegard
 */
public interface Dao<T, I> {

    boolean insert(T obj);
    boolean update(T obj);
    boolean isExist(I id);  
    void insertOrUpdate(T obj);
    
}
