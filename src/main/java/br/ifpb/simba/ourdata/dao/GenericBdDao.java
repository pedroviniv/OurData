/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.simba.ourdata.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Wensttay
 * @param <T>
 * @param <I>
 */
public abstract class GenericBdDao{
    
    private String properties_path;
    private String user;
    private String url;
    private String password;
    private String driver;
    private Connection connection;

    public GenericBdDao(String properties_path) {
        this.properties_path = properties_path;
    }
    
    public void conectar() throws URISyntaxException, IOException, SQLException, ClassNotFoundException {
        if (getConnection() != null && !getConnection().isClosed()) {
            return;
        }
        Properties prop = new Properties();
        prop.load(new FileInputStream(getClass().getResource(properties_path).toURI().getPath()));

        user = prop.getProperty("user");
        url = prop.getProperty("url");
        password = prop.getProperty("password");
        driver = prop.getProperty("driver");

        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);
    }

    public void desconectar() {
        try {
            if (getConnection() != null && !getConnection().isClosed()) {
                connection.close();
            }
        } catch (URISyntaxException | IOException | SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() throws URISyntaxException, IOException, SQLException, ClassNotFoundException {
        return connection;
    }
}
