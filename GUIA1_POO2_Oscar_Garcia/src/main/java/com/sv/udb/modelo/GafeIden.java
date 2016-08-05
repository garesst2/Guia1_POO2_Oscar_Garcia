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
@Table(name = "gafe_iden", catalog = "regivisitas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GafeIden.findAll", query = "SELECT g FROM GafeIden g"),
    @NamedQuery(name = "GafeIden.findByCodiGafeIden", query = "SELECT g FROM GafeIden g WHERE g.codiGafeIden = :codiGafeIden"),
    @NamedQuery(name = "GafeIden.findByNombGafeIden", query = "SELECT g FROM GafeIden g WHERE g.nombGafeIden = :nombGafeIden"),
    @NamedQuery(name = "GafeIden.findByNumeTipoGafe", query = "SELECT g FROM GafeIden g WHERE g.numeTipoGafe = :numeTipoGafe"),
    @NamedQuery(name = "GafeIden.findByFechAlta", query = "SELECT g FROM GafeIden g WHERE g.fechAlta = :fechAlta"),
    @NamedQuery(name = "GafeIden.findByFechBaja", query = "SELECT g FROM GafeIden g WHERE g.fechBaja = :fechBaja")})
public class GafeIden implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODI_GAFE_IDEN", nullable = false)
    private Long codiGafeIden;
    @Size(max = 200)
    @Column(name = "NOMB_GAFE_IDEN", length = 200)
    private String nombGafeIden;
    @Size(max = 200)
    @Column(name = "NUME_TIPO_GAFE", length = 200)
    private String numeTipoGafe;
    @Column(name = "FECH_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechAlta;
    @Column(name = "FECH_BAJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechBaja;
    @Lob
    @Column(name = "ESTA")
    private byte[] esta;
    @JoinColumn(name = "CODI_TIPO_GAFE", referencedColumnName = "CODI_TIPO_GAFE")
    @ManyToOne
    private TipoGafe tipoGafe;
    @OneToMany(mappedBy = "gafeIden")
    private List<Visi> visiList;

    public GafeIden() {
    }

    public GafeIden(Long codiGafeIden, String nombGafeIden, String numeTipoGafe, Date fechAlta, Date fechBaja, byte[] esta, TipoGafe tipoGafe, List<Visi> visiList) {
        this.codiGafeIden = codiGafeIden;
        this.nombGafeIden = nombGafeIden;
        this.numeTipoGafe = numeTipoGafe;
        this.fechAlta = fechAlta;
        this.fechBaja = fechBaja;
        this.esta = esta;
        this.tipoGafe = tipoGafe;
        this.visiList = visiList;
    }
    
    public Long getCodiGafeIden() {
        return codiGafeIden;
    }

    public void setCodiGafeIden(Long codiGafeIden) {
        this.codiGafeIden = codiGafeIden;
    }

    public String getNombGafeIden() {
        return nombGafeIden;
    }

    public void setNombGafeIden(String nombGafeIden) {
        this.nombGafeIden = nombGafeIden;
    }

    public String getNumeTipoGafe() {
        return numeTipoGafe;
    }

    public void setNumeTipoGafe(String numeTipoGafe) {
        this.numeTipoGafe = numeTipoGafe;
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

    public TipoGafe getTipoGafe() {
        return tipoGafe;
    }

    public void setTipoGafe(TipoGafe tipoGafe) {
        this.tipoGafe = tipoGafe;
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
        hash += (codiGafeIden != null ? codiGafeIden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GafeIden)) {
            return false;
        }
        GafeIden other = (GafeIden) object;
        if ((this.codiGafeIden == null && other.codiGafeIden != null) || (this.codiGafeIden != null && !this.codiGafeIden.equals(other.codiGafeIden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.GafeIden[ codiGafeIden=" + codiGafeIden + " ]";
    }
    
}
