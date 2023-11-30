/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author milea
 */
@Entity
@Table(name = "jasa")
@NamedQueries({
    @NamedQuery(name = "Jasa.findAll", query = "SELECT j FROM Jasa j"),
    @NamedQuery(name = "Jasa.findByJasaId", query = "SELECT j FROM Jasa j WHERE j.jasaId = :jasaId"),
    @NamedQuery(name = "Jasa.findByJasaNama", query = "SELECT j FROM Jasa j WHERE j.jasaNama = :jasaNama"),
    @NamedQuery(name = "Jasa.findByJasaDeskripsi", query = "SELECT j FROM Jasa j WHERE j.jasaDeskripsi = :jasaDeskripsi"),
    @NamedQuery(name = "Jasa.findByJasaHarga", query = "SELECT j FROM Jasa j WHERE j.jasaHarga = :jasaHarga"),
    @NamedQuery(name = "Jasa.findByJasaCreatedAt", query = "SELECT j FROM Jasa j WHERE j.jasaCreatedAt = :jasaCreatedAt"),
    @NamedQuery(name = "Jasa.findByJasaUpdatedAt", query = "SELECT j FROM Jasa j WHERE j.jasaUpdatedAt = :jasaUpdatedAt")})
public class Jasa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "jasa_id")
    private Integer jasaId;
    @Column(name = "jasa_nama")
    private String jasaNama;
    @Column(name = "jasa_deskripsi")
    private String jasaDeskripsi;
    @Column(name = "jasa_harga")
    private Integer jasaHarga;
    @Column(name = "jasa_created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jasaCreatedAt;
    @Column(name = "jasa_updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jasaUpdatedAt;
    @OneToMany(mappedBy = "jasaId")
    private List<ItemInvoice> itemInvoiceList;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private Users userId;

    public Jasa() {
    }

    public Jasa(Integer jasaId) {
        this.jasaId = jasaId;
    }

    public Integer getJasaId() {
        return jasaId;
    }

    public void setJasaId(Integer jasaId) {
        this.jasaId = jasaId;
    }

    public String getJasaNama() {
        return jasaNama;
    }

    public void setJasaNama(String jasaNama) {
        this.jasaNama = jasaNama;
    }

    public String getJasaDeskripsi() {
        return jasaDeskripsi;
    }

    public void setJasaDeskripsi(String jasaDeskripsi) {
        this.jasaDeskripsi = jasaDeskripsi;
    }

    public Integer getJasaHarga() {
        return jasaHarga;
    }

    public void setJasaHarga(Integer jasaHarga) {
        this.jasaHarga = jasaHarga;
    }

    public Date getJasaCreatedAt() {
        return jasaCreatedAt;
    }

    public void setJasaCreatedAt(Date jasaCreatedAt) {
        this.jasaCreatedAt = jasaCreatedAt;
    }

    public Date getJasaUpdatedAt() {
        return jasaUpdatedAt;
    }

    public void setJasaUpdatedAt(Date jasaUpdatedAt) {
        this.jasaUpdatedAt = jasaUpdatedAt;
    }

    public List<ItemInvoice> getItemInvoiceList() {
        return itemInvoiceList;
    }

    public void setItemInvoiceList(List<ItemInvoice> itemInvoiceList) {
        this.itemInvoiceList = itemInvoiceList;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jasaId != null ? jasaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jasa)) {
            return false;
        }
        Jasa other = (Jasa) object;
        if ((this.jasaId == null && other.jasaId != null) || (this.jasaId != null && !this.jasaId.equals(other.jasaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Jasa[ jasaId=" + jasaId + " ]";
    }
    
}
