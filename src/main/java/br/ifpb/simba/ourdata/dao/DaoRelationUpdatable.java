/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.simba.ourdata.dao;

/**
 *
 * @author Wensttay
 */
public interface DaoRelationUpdatable <T,I> {
    boolean update(T obj, I id);
    void insertOrUpdate(T obj, I id);
    boolean exist(T obj, I id);
}
