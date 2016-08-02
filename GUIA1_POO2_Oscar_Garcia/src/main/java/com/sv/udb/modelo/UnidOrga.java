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
@Table(name = "unid_orga", catalog = "regivisitas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidOrga.findAll", query = "SELECT u FROM UnidOrga u"),
    @NamedQuery(name = "UnidOrga.findByCodiUnidOrga", query = "SELECT u FROM UnidOrga u WHERE u.codiUnidOrga = :codiUnidOrga"),
    @NamedQuery(name = "UnidOrga.findByNombUnidOrga", query = "SELECT u FROM UnidOrga u WHERE u.nombUnidOrga = :nombUnidOrga"),
    @NamedQuery(name = "UnidOrga.findBySiglUnidOrga", query = "SELECT u FROM UnidOrga u WHERE u.siglUnidOrga = :siglUnidOrga"),
    @NamedQuery(name = "UnidOrga.findByDireUnidOrga", query = "SELECT u FROM UnidOrga u WHERE u.direUnidOrga = :direUnidOrga"),
    @NamedQuery(name = "UnidOrga.findByTeleUnidOrga", query = "SELECT u FROM UnidOrga u WHERE u.teleUnidOrga = :teleUnidOrga"),
    @NamedQuery(name = "UnidOrga.findByFaxUnidOrga", query = "SELECT u FROM UnidOrga u WHERE u.faxUnidOrga = :faxUnidOrga"),
    @NamedQuery(name = "UnidOrga.findByEmaiUnidOrga", query = "SELECT u FROM UnidOrga u WHERE u.emaiUnidOrga = :emaiUnidOrga"),
    @NamedQuery(name = "UnidOrga.findByContUnidOrga", query = "SELECT u FROM UnidOrga u WHERE u.contUnidOrga = :contUnidOrga"),
    @NamedQuery(name = "UnidOrga.findByFechAlta", query = "SELECT u FROM UnidOrga u WHERE u.fechAlta = :fechAlta"),
    @NamedQuery(name = "UnidOrga.findByFechBaja", query = "SELECT u FROM UnidOrga u WHERE u.fechBaja = :fechBaja")})
public class UnidOrga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODI_UNID_ORGA", nullable = false)
    private Long codiUnidOrga;
    @Size(max = 100)
    @Column(name = "NOMB_UNID_ORGA", length = 100)
    private String nombUnidOrga;
    @Size(max = 100)
    @Column(name = "SIGL_UNID_ORGA", length = 100)
    private String siglUnidOrga;
    @Size(max = 200)
    @Column(name = "DIRE_UNID_ORGA", length = 200)
    private String direUnidOrga;
    @Size(max = 20)
    @Column(name = "TELE_UNID_ORGA", length = 20)
    private String teleUnidOrga;
    @Size(max = 20)
    @Column(name = "FAX_UNID_ORGA", length = 20)
    private String faxUnidOrga;
    @Size(max = 50)
    @Column(name = "EMAI_UNID_ORGA", length = 50)
    private String emaiUnidOrga;
    @Size(max = 100)
    @Column(name = "CONT_UNID_ORGA", length = 100)
    private String contUnidOrga;
    @Column(name = "FECH_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechAlta;
    @Column(name = "FECH_BAJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechBaja;
    @Lob
    @Column(name = "ESTA")
    private byte[] esta;
    @JoinColumn(name = "CODI_UBIC_GEOG", referencedColumnName = "CODI_UBIC_GEOG")
    @ManyToOne
    private UbicGeog ubicGeog;
    @OneToMany(mappedBy = "unidOrga")
    private List<UnidOrga> unidOrgaList;
    @JoinColumn(name = "CODI_UNID_ORGA_SUPE", referencedColumnName = "CODI_UNID_ORGA")
    @ManyToOne
    private UnidOrga unidOrga;
    @OneToMany(mappedBy = "unidOrga")
    private List<Visi> visiList;

    public UnidOrga() {
    }

    public UnidOrga(Long codiUnidOrga) {
        this.codiUnidOrga = codiUnidOrga;
    }

    public Long getCodiUnidOrga() {
        return codiUnidOrga;
    }

    public void setCodiUnidOrga(Long codiUnidOrga) {
        this.codiUnidOrga = codiUnidOrga;
    }

    public String getNombUnidOrga() {
        return nombUnidOrga;
    }

    public void setNombUnidOrga(String nombUnidOrga) {
        this.nombUnidOrga = nombUnidOrga;
    }

    public String getSiglUnidOrga() {
        return siglUnidOrga;
    }

    public void setSiglUnidOrga(String siglUnidOrga) {
        this.siglUnidOrga = siglUnidOrga;
    }

    public String getDireUnidOrga() {
        return direUnidOrga;
    }

    public void setDireUnidOrga(String direUnidOrga) {
        this.direUnidOrga = direUnidOrga;
    }

    public String getTeleUnidOrga() {
        return teleUnidOrga;
    }

    public void setTeleUnidOrga(String teleUnidOrga) {
        this.teleUnidOrga = teleUnidOrga;
    }

    public String getFaxUnidOrga() {
        return faxUnidOrga;
    }

    public void setFaxUnidOrga(String faxUnidOrga) {
        this.faxUnidOrga = faxUnidOrga;
    }

    public String getEmaiUnidOrga() {
        return emaiUnidOrga;
    }

    public void setEmaiUnidOrga(String emaiUnidOrga) {
        this.emaiUnidOrga = emaiUnidOrga;
    }

    public String getContUnidOrga() {
        return contUnidOrga;
    }

    public void setContUnidOrga(String contUnidOrga) {
        this.contUnidOrga = contUnidOrga;
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

    public UbicGeog getUbicGeog() {
        return ubicGeog;
    }

    public void setUbicGeog(UbicGeog ubicGeog) {
        this.ubicGeog = ubicGeog;
    }

    @XmlTransient
    public List<UnidOrga> getUnidOrgaList() {
        return unidOrgaList;
    }

    public void setUnidOrgaList(List<UnidOrga> unidOrgaList) {
        this.unidOrgaList = unidOrgaList;
    }

    public UnidOrga getUnidOrga() {
        return unidOrga;
    }

    public void setUnidOrga(UnidOrga unidOrga) {
        this.unidOrga = unidOrga;
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
        hash += (codiUnidOrga != null ? codiUnidOrga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidOrga)) {
            return false;
        }
        UnidOrga other = (UnidOrga) object;
        if ((this.codiUnidOrga == null && other.codiUnidOrga != null) || (this.codiUnidOrga != null && !this.codiUnidOrga.equals(other.codiUnidOrga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.UnidOrga[ codiUnidOrga=" + codiUnidOrga + " ]";
    }
    
}
