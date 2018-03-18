/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Siala
 */
@Entity
@Table(name = "promotion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p")
    , @NamedQuery(name = "Promotion.findById", query = "SELECT p FROM Promotion p WHERE p.id = :id")
    , @NamedQuery(name = "Promotion.findByDateDebutPromotion", query = "SELECT p FROM Promotion p WHERE p.dateDebutPromotion = :dateDebutPromotion")
    , @NamedQuery(name = "Promotion.findByDateFinPromotion", query = "SELECT p FROM Promotion p WHERE p.dateFinPromotion = :dateFinPromotion")
    , @NamedQuery(name = "Promotion.findByPourcentage", query = "SELECT p FROM Promotion p WHERE p.pourcentage = :pourcentage")})
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "date_debut_promotion")
    @Temporal(TemporalType.DATE)
    private Date dateDebutPromotion;
    @Basic(optional = false)
    @Column(name = "date_fin_promotion")
    @Temporal(TemporalType.DATE)
    private Date dateFinPromotion;
    @Basic(optional = false)
    @Column(name = "pourcentage")
    private int pourcentage;
    @JoinColumn(name = "patisserie_id", referencedColumnName = "idPatisserie")
    @ManyToOne
    private Patisserie patisserieId;
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    @OneToOne
    private Image imageId;
    @JoinColumn(name = "produit_id", referencedColumnName = "idProduit")
    @ManyToOne
    private Produit produitId;

    public Promotion() {
    }

    public Promotion(Integer id) {
        this.id = id;
    }

    public Promotion( Produit produitId,Date dateDebutPromotion, Date dateFinPromotion, int pourcentage) {
        this.produitId=produitId;
        this.dateDebutPromotion = dateDebutPromotion;
        this.dateFinPromotion = dateFinPromotion;
        this.pourcentage = pourcentage;
    }

    public Promotion(Date date1, Date datef, int s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDebutPromotion() {
        return dateDebutPromotion;
    }

    public void setDateDebutPromotion(Date dateDebutPromotion) {
        this.dateDebutPromotion = dateDebutPromotion;
    }

    public Date getDateFinPromotion() {
        return dateFinPromotion;
    }

    public void setDateFinPromotion(Date dateFinPromotion) {
        this.dateFinPromotion = dateFinPromotion;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public Patisserie getPatisserieId() {
        return patisserieId;
    }

    public void setPatisserieId(Patisserie patisserieId) {
        this.patisserieId = patisserieId;
    }

    public Image getImageId() {
        return imageId;
    }

    public void setImageId(Image imageId) {
        this.imageId = imageId;
    }

    public Produit getProduitId() {
        return produitId;
    }

    public void setProduitId(Produit produitId) {
        this.produitId = produitId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Promotion)) {
//            return false;
//        }
//        Promotion other = (Promotion) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "entites.Promotion[ id=" + id + " ]";
    }
    
}
