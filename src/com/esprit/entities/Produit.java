/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entities;

import com.esprit.services.ServicePromotion;
import com.esprit.utils.DataSource;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Siala
 */
@Entity
@Table(name = "produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p")
    , @NamedQuery(name = "Produit.findByIdProduit", query = "SELECT p FROM Produit p WHERE p.idProduit = :idProduit")
    , @NamedQuery(name = "Produit.findByNom", query = "SELECT p FROM Produit p WHERE p.nom = :nom")
    , @NamedQuery(name = "Produit.findByPrix", query = "SELECT p FROM Produit p WHERE p.prix = :prix")
    , @NamedQuery(name = "Produit.findByStock", query = "SELECT p FROM Produit p WHERE p.stock = :stock")
    , @NamedQuery(name = "Produit.findByNomImage", query = "SELECT p FROM Produit p WHERE p.nomImage = :nomImage")})
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;

    public static void fillCombo(DataSource  cnx,ObservableList<Produit> list) {
       String req="Select nom FROM Produit INNER JOIN Promotion ON Promotion.idProduit = Produit.idProduit;";
      try{
            PreparedStatement ps=cnx.getConnection().prepareStatement(req);
      ps.executeQuery();
      while(ps.executeQuery().next()){
//          Produit_.idProduit.addItems(ps.executeQuery().getString('nom'));
      }
      }
      catch( SQLException ex){
          Logger.getLogger(ServicePromotion.class.getName()).log(Level.SEVERE,null,ex);
      }
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProduit")
    private Integer idProduit;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "prix")
    private double prix;
    @Basic(optional = false)
    @Column(name = "stock")
    private String stock;
    @Basic(optional = false)
    @Column(name = "nomImage")
    private String nomImage;
    @JoinColumn(name = "Categorie_id", referencedColumnName = "id_Categorie")
    @ManyToOne
    private Categorie categorieid;
    @OneToMany(mappedBy = "produitId")
    private Collection<Wishlist> wishlistCollection;
    @OneToMany(mappedBy = "produit")
//    private Collection<LigneCommande> ligneCommandeCollection;
//    @OneToMany(mappedBy = "produitId")
    private Collection<Promotion> promotionCollection;

    public Produit() {
    }

    public Produit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public Produit(String nom) {
        this.nom = nom;
    }

    public Produit(Integer idProduit, String nom, double prix, String stock, String nomImage) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.nomImage = nomImage;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getNomImage() {
        return nomImage;
    }

    public void setNomImage(String nomImage) {
        this.nomImage = nomImage;
    }

    public Categorie getCategorieid() {
        return categorieid;
    }

    public void setCategorieid(Categorie categorieid) {
        this.categorieid = categorieid;
    }

    @XmlTransient
    public Collection<Wishlist> getWishlistCollection() {
        return wishlistCollection;
    }

    public void setWishlistCollection(Collection<Wishlist> wishlistCollection) {
        this.wishlistCollection = wishlistCollection;
    }

//    @XmlTransient
//    public Collection<LigneCommande> getLigneCommandeCollection() {
//        return ligneCommandeCollection;
//    }

//    public void setLigneCommandeCollection(Collection<LigneCommande> ligneCommandeCollection) {
//        this.ligneCommandeCollection = ligneCommandeCollection;
//    }

    @XmlTransient
    public Collection<Promotion> getPromotionCollection() {
        return promotionCollection;
    }

    public void setPromotionCollection(Collection<Promotion> promotionCollection) {
        this.promotionCollection = promotionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduit != null ? idProduit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.idProduit == null && other.idProduit != null) || (this.idProduit != null && !this.idProduit.equals(other.idProduit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Produit[ idProduit=" + idProduit + " ]";
    }
    
}
