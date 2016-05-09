/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.simba.ourdata.geo;

import java.sql.Timestamp;
import java.util.Objects;
import org.postgis.PGgeometry;

/**
 *
 * @author kieckegard
 */
public class KeyWord {
    
    private int repeatNumber = 0;
    private int rowsNumber;
    private int columNumber;
    private String columValue;
    private Timestamp metadataCreated;
    private String idResource;
    private Place place;

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KeyWord other = (KeyWord) obj;
        if (this.columNumber != other.columNumber) {
            return false;
        }
        if (!Objects.equals(this.columValue, other.columValue)) {
            return false;
        }
        if (!Objects.equals(this.idResource, other.idResource)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        return "KeyWord{" + "repeatNumber=" + repeatNumber + ", rowsNumber=" + rowsNumber + ", columNumber=" + columNumber + ", columValue=" + columValue + ", metadataCreated=" + metadataCreated + ", idResource=" + idResource + ", place=\n" + place.toString() + '}';
    }
    
    public int getRepeatNumber() {
        return repeatNumber;
    }

    public void setRepeatNumber(int repeatNumber) {
        this.repeatNumber = repeatNumber;
    }

    public int getRowsNumber() {
        return rowsNumber;
    }

    public void setRowsNumber(int rowsNumber) {
        this.rowsNumber = rowsNumber;
    }

    public int getColumNumber() {
        return columNumber;
    }

    public void setColumNumber(int columNumber) {
        this.columNumber = columNumber;
    }

    public String getColumValue() {
        return columValue;
    }

    public void setColumValue(String columValue) {
        this.columValue = columValue;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Timestamp getMetadataCreated() {
        return metadataCreated;
    }

    public void setMetadataCreated(Timestamp metadataCreated) {
        this.metadataCreated = metadataCreated;
    }

    public String getIdResource() {
        return idResource;
    }

    public void setIdResource(String idResource) {
        this.idResource = idResource;
    }
    
    
}
