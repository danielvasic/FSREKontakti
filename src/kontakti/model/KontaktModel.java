/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontakti.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Daniel
 */
public class KontaktModel {
    SimpleIntegerProperty sifra = new SimpleIntegerProperty();
    SimpleStringProperty ime = new SimpleStringProperty();
    SimpleStringProperty prezime = new SimpleStringProperty();
    SimpleStringProperty email = new SimpleStringProperty();
    
    public KontaktModel (Integer sifra, String ime, String prezime, String email) {
        this.sifra = new SimpleIntegerProperty (sifra);
        this.ime = new SimpleStringProperty(ime);
        this.prezime = new SimpleStringProperty(prezime);
        this.email = new SimpleStringProperty(email);
    }
    
    public Integer getSifra () {
        return sifra.get();
    }
    
    public String getIme () {
        return ime.get();
    }
    
    public String getPrezime () {
        return prezime.get();
    }
    
    public String getEmail () {
        return email.get();
    }

    public void setIme(String ime) {
        this.ime = new SimpleStringProperty(ime);
    }

    public void setPrezime(String prezime) {
        this.prezime = new SimpleStringProperty(prezime);
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }
    
    
    
    public static ObservableList<KontaktModel> listaKontakata () {
        ObservableList<KontaktModel> lista = FXCollections.observableArrayList();
        
        ResultSet rs = Baza.DB.select("SELECT * FROM kontakt");
        
        try {
            while (rs.next()) {
                lista.add(new KontaktModel(rs.getInt("id"), rs.getString("ime"), rs.getString("prezime"), rs.getString("email")));
            }
        } catch (SQLException ex) {
            System.out.println("Nastala je greška prilikom iteriranja: " + ex.getMessage());
        }
        return lista;
    }
}

