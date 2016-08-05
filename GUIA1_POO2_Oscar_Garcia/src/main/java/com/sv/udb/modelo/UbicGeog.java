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
@Table(name = "ubic_geog", catalog = "regivisitas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UbicGeog.findAll", query = "SELECT u FROM UbicGeog u"),
    @NamedQuery(name = "UbicGeog.findByCodiUbicGeog", query = "SELECT u FROM UbicGeog u WHERE u.codiUbicGeog = :codiUbicGeog"),
    @NamedQuery(name = "UbicGeog.findByNombUbicGeog", query = "SELECT u FROM UbicGeog u WHERE u.nombUbicGeog = :nombUbicGeog"),
    @NamedQuery(name = "UbicGeog.findByFechAlta", query = "SELECT u FROM UbicGeog u WHERE u.fechAlta = :fechAlta"),
    @NamedQuery(name = "UbicGeog.findByFechBaja", query = "SELECT u FROM UbicGeog u WHERE u.fechBaja = :fechBaja")})
public class UbicGeog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODI_UBIC_GEOG", nullable = false)
    private Long codiUbicGeog;
    @Size(max = 200)
    @Column(name = "NOMB_UBIC_GEOG", length = 200)
    private String nombUbicGeog;
    @Column(name = "FECH_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechAlta;
    @Column(name = "FECH_BAJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechBaja;
    @Lob
    @Column(name = "ESTA")
    private byte[] esta;
    @OneToMany(mappedBy = "ubicGeog")
    private List<UnidOrga> unidOrgaList;
    @OneToMany(mappedBy = "ubicGeog")
    private List<UbicGeog> ubicGeogList;
    @JoinColumn(name = "CODI_UBIC_GEOG_SUPE", referencedColumnName = "CODI_UBIC_GEOG")
    @ManyToOne
    private UbicGeog ubicGeog;

    public UbicGeog() {
    }

    public UbicGeog(Long codiUbicGeog, String nombUbicGeog, Date fechAlta, Date fechBaja, byte[] esta, List<UnidOrga> unidOrgaList, List<UbicGeog> ubicGeogList, UbicGeog ubicGeog) {
        this.codiUbicGeog = codiUbicGeog;
        this.nombUbicGeog = nombUbicGeog;
        this.fechAlta = fechAlta;
        this.fechBaja = fechBaja;
        this.esta = esta;
        this.unidOrgaList = unidOrgaList;
        this.ubicGeogList = ubicGeogList;
        this.ubicGeog = ubicGeog;
    }
    
    public Long getCodiUbicGeog() {
        return codiUbicGeog;
    }

    public void setCodiUbicGeog(Long codiUbicGeog) {
        this.codiUbicGeog = codiUbicGeog;
    }

    public String getNombUbicGeog() {
        return nombUbicGeog;
    }

    public void setNombUbicGeog(String nombUbicGeog) {
        this.nombUbicGeog = nombUbicGeog;
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

    @XmlTransient
    public List<UnidOrga> getUnidOrgaList() {
        return unidOrgaList;
    }

    public void setUnidOrgaList(List<UnidOrga> unidOrgaList) {
        this.unidOrgaList = unidOrgaList;
    }

    @XmlTransient
    public List<UbicGeog> getUbicGeogList() {
        return ubicGeogList;
    }

    public void setUbicGeogList(List<UbicGeog> ubicGeogList) {
        this.ubicGeogList = ubicGeogList;
    }

    public UbicGeog getUbicGeog() {
        return ubicGeog;
    }

    public void setUbicGeog(UbicGeog ubicGeog) {
        this.ubicGeog = ubicGeog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiUbicGeog != null ? codiUbicGeog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UbicGeog)) {
            return false;
        }
        UbicGeog other = (UbicGeog) object;
        if ((this.codiUbicGeog == null && other.codiUbicGeog != null) || (this.codiUbicGeog != null && !this.codiUbicGeog.equals(other.codiUbicGeog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.UbicGeog[ codiUbicGeog=" + codiUbicGeog + " ]";
    }
    
}
