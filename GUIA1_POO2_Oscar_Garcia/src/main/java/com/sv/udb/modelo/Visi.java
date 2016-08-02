/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "visi", catalog = "regivisitas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visi.findAll", query = "SELECT v FROM Visi v"),
    @NamedQuery(name = "Visi.findByCodiVisi", query = "SELECT v FROM Visi v WHERE v.codiVisi = :codiVisi"),
    @NamedQuery(name = "Visi.findByCodiPersVisi", query = "SELECT v FROM Visi v WHERE v.codiPersVisi = :codiPersVisi"),
    @NamedQuery(name = "Visi.findByFechHoraEntrVisi", query = "SELECT v FROM Visi v WHERE v.fechHoraEntrVisi = :fechHoraEntrVisi"),
    @NamedQuery(name = "Visi.findByFechHoraSaliVisi", query = "SELECT v FROM Visi v WHERE v.fechHoraSaliVisi = :fechHoraSaliVisi"),
    @NamedQuery(name = "Visi.findByMotiVisi", query = "SELECT v FROM Visi v WHERE v.motiVisi = :motiVisi"),
    @NamedQuery(name = "Visi.findByFechAlta", query = "SELECT v FROM Visi v WHERE v.fechAlta = :fechAlta"),
    @NamedQuery(name = "Visi.findByFechBaja", query = "SELECT v FROM Visi v WHERE v.fechBaja = :fechBaja")})
public class Visi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODI_VISI", nullable = false)
    private Long codiVisi;
    @Column(name = "CODI_PERS_VISI")
    private BigInteger codiPersVisi;
    @Column(name = "FECH_HORA_ENTR_VISI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechHoraEntrVisi;
    @Column(name = "FECH_HORA_SALI_VISI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechHoraSaliVisi;
    @Size(max = 255)
    @Column(name = "MOTI_VISI", length = 255)
    private String motiVisi;
    @Column(name = "FECH_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechAlta;
    @Column(name = "FECH_BAJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechBaja;
    @Lob
    @Column(name = "ESTA")
    private byte[] esta;
    @JoinColumn(name = "CODI_GAFE", referencedColumnName = "CODI_GAFE_IDEN")
    @ManyToOne
    private GafeIden gafeIden;
    @JoinColumn(name = "CODI_LUGA_ENTR", referencedColumnName = "CODI_LUGA_ACCE")
    @ManyToOne
    private LugaAcce lugaAcce;
    @JoinColumn(name = "CODI_LUGA_SALI", referencedColumnName = "CODI_LUGA_ACCE")
    @ManyToOne
    private LugaAcce lugaAcce1;
    @JoinColumn(name = "CODI_PERS", referencedColumnName = "CODI_PERS_HIST")
    @ManyToOne
    private PersHist persHist;
    @JoinColumn(name = "CODI_USUA", referencedColumnName = "CODI_USUA")
    @ManyToOne
    private Usua usua;
    @JoinColumn(name = "CODI_TIPO_DOCU", referencedColumnName = "CODI_TIPO_DOCU")
    @ManyToOne
    private TipoDocu tipoDocu;
    @JoinColumn(name = "CODI_UNID_ORGA_VISI", referencedColumnName = "CODI_UNID_ORGA")
    @ManyToOne
    private UnidOrga unidOrga;

    public Visi() {
    }

    public Visi(Long codiVisi) {
        this.codiVisi = codiVisi;
    }

    public Long getCodiVisi() {
        return codiVisi;
    }

    public void setCodiVisi(Long codiVisi) {
        this.codiVisi = codiVisi;
    }

    public BigInteger getCodiPersVisi() {
        return codiPersVisi;
    }

    public void setCodiPersVisi(BigInteger codiPersVisi) {
        this.codiPersVisi = codiPersVisi;
    }

    public Date getFechHoraEntrVisi() {
        return fechHoraEntrVisi;
    }

    public void setFechHoraEntrVisi(Date fechHoraEntrVisi) {
        this.fechHoraEntrVisi = fechHoraEntrVisi;
    }

    public Date getFechHoraSaliVisi() {
        return fechHoraSaliVisi;
    }

    public void setFechHoraSaliVisi(Date fechHoraSaliVisi) {
        this.fechHoraSaliVisi = fechHoraSaliVisi;
    }

    public String getMotiVisi() {
        return motiVisi;
    }

    public void setMotiVisi(String motiVisi) {
        this.motiVisi = motiVisi;
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

    public GafeIden getGafeIden() {
        return gafeIden;
    }

    public void setGafeIden(GafeIden gafeIden) {
        this.gafeIden = gafeIden;
    }

    public LugaAcce getLugaAcce() {
        return lugaAcce;
    }

    public void setLugaAcce(LugaAcce lugaAcce) {
        this.lugaAcce = lugaAcce;
    }

    public LugaAcce getLugaAcce1() {
        return lugaAcce1;
    }

    public void setLugaAcce1(LugaAcce lugaAcce1) {
        this.lugaAcce1 = lugaAcce1;
    }

    public PersHist getPersHist() {
        return persHist;
    }

    public void setPersHist(PersHist persHist) {
        this.persHist = persHist;
    }

    public Usua getUsua() {
        return usua;
    }

    public void setUsua(Usua usua) {
        this.usua = usua;
    }

    public TipoDocu getTipoDocu() {
        return tipoDocu;
    }

    public void setTipoDocu(TipoDocu tipoDocu) {
        this.tipoDocu = tipoDocu;
    }

    public UnidOrga getUnidOrga() {
        return unidOrga;
    }

    public void setUnidOrga(UnidOrga unidOrga) {
        this.unidOrga = unidOrga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiVisi != null ? codiVisi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visi)) {
            return false;
        }
        Visi other = (Visi) object;
        if ((this.codiVisi == null && other.codiVisi != null) || (this.codiVisi != null && !this.codiVisi.equals(other.codiVisi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Visi[ codiVisi=" + codiVisi + " ]";
    }
    
}
