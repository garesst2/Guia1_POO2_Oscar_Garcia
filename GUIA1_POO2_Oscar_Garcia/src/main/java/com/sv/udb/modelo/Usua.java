/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "usua", catalog = "regivisitas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usua.findAll", query = "SELECT u FROM Usua u"),
    @NamedQuery(name = "Usua.findByCodiUsua", query = "SELECT u FROM Usua u WHERE u.codiUsua = :codiUsua"),
    @NamedQuery(name = "Usua.findByAcceUsua", query = "SELECT u FROM Usua u WHERE u.acceUsua = :acceUsua"),
    @NamedQuery(name = "Usua.findByContUsua", query = "SELECT u FROM Usua u WHERE u.contUsua = :contUsua"),
    @NamedQuery(name = "Usua.findByFechCambClavUsua", query = "SELECT u FROM Usua u WHERE u.fechCambClavUsua = :fechCambClavUsua"),
    @NamedQuery(name = "Usua.findByFechAlta", query = "SELECT u FROM Usua u WHERE u.fechAlta = :fechAlta"),
    @NamedQuery(name = "Usua.findByFechBaja", query = "SELECT u FROM Usua u WHERE u.fechBaja = :fechBaja")})
public class Usua implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODI_USUA", nullable = false)
    private Long codiUsua;
    @Size(max = 255)
    @Column(name = "ACCE_USUA", length = 255)
    private String acceUsua;
    @Size(max = 255)
    @Column(name = "CONT_USUA", length = 255)
    private String contUsua;
    @Column(name = "FECH_CAMB_CLAV_USUA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechCambClavUsua;
    @Column(name = "FECH_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechAlta;
    @Column(name = "FECH_BAJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechBaja;
    @Lob
    @Column(name = "ESTA")
    private byte[] esta;
    @JoinColumn(name = "CODI_PERS", referencedColumnName = "CODI_PERS")
    @ManyToOne
    private Pers pers;
    @OneToMany(mappedBy = "usua")
    private List<Visi> visiList;

    public Usua() {
    }

    public Usua(Long codiUsua) {
        this.codiUsua = codiUsua;
    }

    public Long getCodiUsua() {
        return codiUsua;
    }

    public void setCodiUsua(Long codiUsua) {
        this.codiUsua = codiUsua;
    }

    public String getAcceUsua() {
        return acceUsua;
    }

    public void setAcceUsua(String acceUsua) {
        this.acceUsua = acceUsua;
    }

    public String getContUsua() {
        return contUsua;
    }

    public void setContUsua(String contUsua) {
        this.contUsua = contUsua;
    }

    public Date getFechCambClavUsua() {
        return fechCambClavUsua;
    }

    public void setFechCambClavUsua(Date fechCambClavUsua) {
        this.fechCambClavUsua = fechCambClavUsua;
    }

    public Date getFechAlta() {
        return fechAlta;
    }

    public void setFechAlta(Date fechAlta) {
        this.fechAlta = fechAlta;
    }

    public Date getFechBaja() {
        return fechBaja;
    }

    public void setFechBaja(Date fechBaja) {
        this.fechBaja = fechBaja;
    }

    public byte[] getEsta() {
        return esta;
    }

    public void setEsta(byte[] esta) {
        this.esta = esta;
    }

    public Pers getPers() {
        return pers;
    }

    public void setPers(Pers pers) {
        this.pers = pers;
    }

    @XmlTransient
    public List<Visi> getVisiList() {
        return visiList;
    }

    public void setVisiList(List<Visi> visiList) {
        this.visiList = visiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiUsua != null ? codiUsua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usua)) {
            return false;
        }
        Usua other = (Usua) object;
        if ((this.codiUsua == null && other.codiUsua != null) || (this.codiUsua != null && !this.codiUsua.equals(other.codiUsua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Usua[ codiUsua=" + codiUsua + " ]";
    }
    
}
