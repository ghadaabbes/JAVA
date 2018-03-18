/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
@Table(name = "patisserie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patisserie.findAll", query = "SELECT p FROM Patisserie p")
    , @NamedQuery(name = "Patisserie.findByIdPatisserie", query = "SELECT p FROM Patisserie p WHERE p.idPatisserie = :idPatisserie")
    , @NamedQuery(name = "Patisserie.findByNom", query = "SELECT p FROM Patisserie p WHERE p.nom = :nom")
    , @NamedQuery(name = "Patisserie.findByAdresse", query = "SELECT p FROM Patisserie p WHERE p.adresse = :adresse")
    , @NamedQuery(name = "Patisserie.findByDescription", query = "SELECT p FROM Patisserie p WHERE p.description = :description")
    , @NamedQuery(name = "Patisserie.findByNomImage", query = "SELECT p FROM Patisserie p WHERE p.nomImage = :nomImage")
    , @NamedQuery(name = "Patisserie.findByNote", query = "SELECT p FROM Patisserie p WHERE p.note = :note")})
public class Patisserie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPatisserie")
    private Integer idPatisserie;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "nomImage")
    private String nomImage;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "note")
    private BigDecimal note;
    @OneToMany(mappedBy = "patisserieId")
    private Collection<Categorie> categorieCollection;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private FosUser user;
    @OneToMany(mappedBy = "patisserieId")
    private Collection<Evaluation> evaluationCollection;
    @OneToMany(mappedBy = "patisserieId")
    private Collection<Reclamation> reclamationCollection;
    @OneToMany(mappedBy = "patisserieId")
    private Collection<Promotion> promotionCollection;

    public Patisserie() {
    }

    public Patisserie(Integer idPatisserie) {
        this.idPatisserie = idPatisserie;
    }

    public Patisserie(Integer idPatisserie, String nom, String adresse, String description, String nomImage, BigDecimal note) {
        this.idPatisserie = idPatisserie;
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        this.nomImage = nomImage;
        this.note = note;
    }

    public Integer getIdPatisserie() {
        return idPatisserie;
    }

    public void setIdPatisserie(Integer idPatisserie) {
        this.idPatisserie = idPatisserie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNomImage() {
        return nomImage;
    }

    public void setNomImage(String nomImage) {
        this.nomImage = nomImage;
    }

    public BigDecimal getNote() {
        return note;
    }

    public void setNote(BigDecimal note) {
        this.note = note;
    }

    @XmlTransient
    public Collection<Categorie> getCategorieCollection() {
        return categorieCollection;
    }

    public void setCategorieCollection(Collection<Categorie> categorieCollection) {
        this.categorieCollection = categorieCollection;
    }

    public FosUser getUser() {
        return user;
    }

    public void setUser(FosUser user) {
        this.user = user;
    }

    @XmlTransient
    public Collection<Evaluation> getEvaluationCollection() {
        return evaluationCollection;
    }

    public void setEvaluationCollection(Collection<Evaluation> evaluationCollection) {
        this.evaluationCollection = evaluationCollection;
    }

    @XmlTransient
    public Collection<Reclamation> getReclamationCollection() {
        return reclamationCollection;
    }

    public void setReclamationCollection(Collection<Reclamation> reclamationCollection) {
        this.reclamationCollection = reclamationCollection;
    }

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
        hash += (idPatisserie != null ? idPatisserie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patisserie)) {
            return false;
        }
        Patisserie other = (Patisserie) object;
        if ((this.idPatisserie == null && other.idPatisserie != null) || (this.idPatisserie != null && !this.idPatisserie.equals(other.idPatisserie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Patisserie[ idPatisserie=" + idPatisserie + " ]";
    }
    
}
