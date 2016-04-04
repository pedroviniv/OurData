/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.simba.ourdata.dao.ckan.relation;

import br.ifpb.simba.ourdata.dao.GenericRelationBdDao;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author wensttay
 */
public class ResourceOthersBdDao extends GenericRelationBdDao<Map<String,Object>, String>{

    @Override
    public boolean insert(Map<String, Object> obj, String id) {
                
        try {
            conectar();
            String sql;
            PreparedStatement ps;

            for (Map.Entry<String, Object> entry : obj.entrySet()) {
                sql = "INSERT INTO RESOURCE_OTHER values (?, ?, ?)";
                ps = getConnection().prepareStatement(sql);
                ps.setString(1, entry.getKey());
                ps.setString(2, entry.getValue().toString());
                ps.setString(3, id);
                ps.executeUpdate();
            }
            return true;

        } catch (URISyntaxException | IOException | SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
            
        return false;
    }
 
}