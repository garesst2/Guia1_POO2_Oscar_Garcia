/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "equi_comp", catalog = "regivisitas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquiComp.findAll", query = "SELECT e FROM EquiComp e"),
    @NamedQuery(name = "EquiComp.findByCodiEquiComp", query = "SELECT e FROM EquiComp e WHERE e.codiEquiComp = :codiEquiComp"),
    @NamedQuery(name = "EquiComp.findByNombEquiCom", query = "SELECT e FROM EquiComp e WHERE e.nombEquiCom = :nombEquiCom"),
    @NamedQuery(name = "EquiComp.findByMacAddrEquiComp", query = "SELECT e FROM EquiComp e WHERE e.macAddrEquiComp = :macAddrEquiComp"),
    @NamedQuery(name = "EquiComp.findByIpAddrEquiComp", query = "SELECT e FROM EquiComp e WHERE e.ipAddrEquiComp = :ipAddrEquiComp"),
    @NamedQuery(name = "EquiComp.findByFechAlta", query = "SELECT e FROM EquiComp e WHERE e.fechAlta = :fechAlta"),
    @NamedQuery(name = "EquiComp.findByFechBaja", query = "SELECT e FROM EquiComp e WHERE e.fechBaja = :fechBaja")})
public class EquiComp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODI_EQUI_COMP", nullable = false)
    private Long codiEquiComp;
    @Size(max = 100)
    @Column(name = "NOMB_EQUI_COM", length = 100)
    private String nombEquiCom;
    @Size(max = 50)
    @Column(name = "MAC_ADDR_EQUI_COMP", length = 50)
    private String macAddrEquiComp;
    @Size(max = 50)
    @Column(name = "IP_ADDR_EQUI_COMP", length = 50)
    private String ipAddrEquiComp;
    @Column(name = "FECH_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechAlta;
    @Column(name = "FECH_BAJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechBaja;
    @Lob
    @Column(name = "ESTA")
    private byte[] esta;
    @JoinColumn(name = "CODI_LUGA_ACCE", referencedColumnName = "CODI_LUGA_ACCE")
    @ManyToOne
    private LugaAcce lugaAcce;

    public EquiComp() {
    }

    public EquiComp(Long codiEquiComp, String nombEquiCom, String macAddrEquiComp, String ipAddrEquiComp, Date fechAlta, Date fechBaja, byte[] esta, LugaAcce lugaAcce) {
        this.codiEquiComp = codiEquiComp;
        this.nombEquiCom = nombEquiCom;
        this.macAddrEquiComp = macAddrEquiComp;
        this.ipAddrEquiComp = ipAddrEquiComp;
        this.fechAlta = fechAlta;
        this.fechBaja = fechBaja;
        this.esta = esta;
        this.lugaAcce = lugaAcce;
    }    

    public Long getCodiEquiComp() {
        return codiEquiComp;
    }

    public void setCodiEquiComp(Long codiEquiComp) {
        this.codiEquiComp = codiEquiComp;
    }

    public String getNombEquiCom() {
        return nombEquiCom;
    }

    public void setNombEquiCom(String nombEquiCom) {
        this.nombEquiCom = nombEquiCom;
    }

    public String getMacAddrEquiComp() {
        return macAddrEquiComp;
    }

    public void setMacAddrEquiComp(String macAddrEquiComp) {
        this.macAddrEquiComp = macAddrEquiComp;
    }

    public String getIpAddrEquiComp() {
        return ipAddrEquiComp;
    }

    public void setIpAddrEquiComp(String ipAddrEquiComp) {
        this.ipAddrEquiComp = ipAddrEquiComp;
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

    public LugaAcce getLugaAcce() {
        return lugaAcce;
    }

    public void setLugaAcce(LugaAcce lugaAcce) {
        this.lugaAcce = lugaAcce;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiEquiComp != null ? codiEquiComp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquiComp)) {
            return false;
        }
        EquiComp other = (EquiComp) object;
        if ((this.codiEquiComp == null && other.codiEquiComp != null) || (this.codiEquiComp != null && !this.codiEquiComp.equals(other.codiEquiComp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.EquiComp[ codiEquiComp=" + codiEquiComp + " ]";
    }
    
}
