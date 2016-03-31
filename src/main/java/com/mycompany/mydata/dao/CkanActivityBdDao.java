/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mydata.dao;

import eu.trentorise.opendata.jackan.model.CkanActivity;
import eu.trentorise.opendata.jackan.model.CkanGroup;
import eu.trentorise.opendata.jackan.model.CkanDataset;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

/**
 *
 * @author wensttay
 */
public class CkanActivityBdDao extends GenericBdDao<CkanActivity, String> {

    @Override
    public boolean insert(CkanActivity obj) {
        try {
            conectar();
            String sql = "INSERT INTO ACTIVITY values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, obj.getId());
            ps.setTimestamp(2, obj.getApprovedTimestamp());
            ps.setString(3, obj.getAuthor());
            ps.setString(4, obj.getMessage());
            ps.setString(5, String.valueOf(obj.getState()));
            ps.setTimestamp(6, obj.getTimestamp());

            List<String> auxListGroup = obj.getGroups();
            List<CkanDataset> auxListDataSet = obj.getPackages();

            if (auxListGroup == null) {
                auxListGroup = new ArrayList<>();
            }
            if (auxListDataSet == null) {
                auxListDataSet = new ArrayList<>();
            }

            for (String string : auxListGroup) {
                insertActivityGroup(obj.getId(), string);
            }

            for (CkanDataset ckanDataset : auxListDataSet) {
                insertActivityDataSet(obj.getId(), ckanDataset.getId());
            }

            return (ps.executeUpdate() != 0);
        } catch (PSQLException ex) {
            if (ex.getErrorCode() == 0) {
                System.out.println("Error: Já existe uma Activity com o ID: " + obj.getId());
            }else{
            	ex.printStackTrace();
            }
        } catch (URISyntaxException | IOException | SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            desconectar();
        }
        return false;
    }

    @Override
    public CkanActivity get(String obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CkanActivity> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean insertActivityGroup(String idActivity, String group) {

        try {
            conectar();
            String sql = "INSERT INTO ACTIVITY_GROUP values (?, ?)";
            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, idActivity);
            ps.setString(2, group);

            ps.executeUpdate();

            return true;
        }catch (URISyntaxException | IOException | SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return false;

    }

    private boolean insertActivityDataSet(String idActivity, String idDataSet) {

        try {
            conectar();
            String sql = "INSERT INTO ACTIVITY_DATASET values (?, ?)";
            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, idDataSet);
            ps.setString(2, idActivity);

            ps.executeUpdate();

            return true;
        }catch (URISyntaxException | IOException | SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return false;

    }
}
