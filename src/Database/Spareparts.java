/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "spareparts")
@NamedQueries({
    @NamedQuery(name = "Spareparts.findAll", query = "SELECT s FROM Spareparts s"),
    @NamedQuery(name = "Spareparts.findBySparepartId", query = "SELECT s FROM Spareparts s WHERE s.sparepartId = :sparepartId"),
    @NamedQuery(name = "Spareparts.findBySparepartNama", query = "SELECT s FROM Spareparts s WHERE s.sparepartNama = :sparepartNama"),
    @NamedQuery(name = "Spareparts.findBySparepartDeskripsi", query = "SELECT s FROM Spareparts s WHERE s.sparepartDeskripsi = :sparepartDeskripsi"),
    @NamedQuery(name = "Spareparts.findBySparepartQty", query = "SELECT s FROM Spareparts s WHERE s.sparepartQty = :sparepartQty"),
    @NamedQuery(name = "Spareparts.findBySparepartHarga", query = "SELECT s FROM Spareparts s WHERE s.sparepartHarga = :sparepartHarga"),
    @NamedQuery(name = "Spareparts.findBySparepartCreatedAt", query = "SELECT s FROM Spareparts s WHERE s.sparepartCreatedAt = :sparepartCreatedAt"),
    @NamedQuery(name = "Spareparts.findBySparepartUpdatedAt", query = "SELECT s FROM Spareparts s WHERE s.sparepartUpdatedAt = :sparepartUpdatedAt")})
public class Spareparts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sparepart_id")
    private Integer sparepartId;
    @Column(name = "sparepart_nama")
    private String sparepartNama;
    @Column(name = "sparepart_deskripsi")
    private String sparepartDeskripsi;
    @Column(name = "sparepart_qty")
    private Integer sparepartQty;
    @Column(name = "sparepart_harga")
    private Integer sparepartHarga;
    @Column(name = "sparepart_created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sparepartCreatedAt;
    @Column(name = "sparepart_updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sparepartUpdatedAt;
    @OneToMany(mappedBy = "sparepartId")
    private List<ItemInvoice> itemInvoiceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sparepartId")
    private List<SupplyParts> supplyPartsList;

    public Spareparts() {
    }

    public Spareparts(Integer sparepartId) {
        this.sparepartId = sparepartId;
    }

    public Integer getSparepartId() {
        return sparepartId;
    }

    public void setSparepartId(Integer sparepartId) {
        this.sparepartId = sparepartId;
    }

    public String getSparepartNama() {
        return sparepartNama;
    }

    public void setSparepartNama(String sparepartNama) {
        this.sparepartNama = sparepartNama;
    }

    public String getSparepartDeskripsi() {
        return sparepartDeskripsi;
    }

    public void setSparepartDeskripsi(String sparepartDeskripsi) {
        this.sparepartDeskripsi = sparepartDeskripsi;
    }

    public Integer getSparepartQty() {
        return sparepartQty;
    }

    public void setSparepartQty(Integer sparepartQty) {
        this.sparepartQty = sparepartQty;
    }

    public Integer getSparepartHarga() {
        return sparepartHarga;
    }

    public void setSparepartHarga(Integer sparepartHarga) {
        this.sparepartHarga = sparepartHarga;
    }

    public Date getSparepartCreatedAt() {
        return sparepartCreatedAt;
    }

    public void setSparepartCreatedAt(Date sparepartCreatedAt) {
        this.sparepartCreatedAt = sparepartCreatedAt;
    }

    public Date getSparepartUpdatedAt() {
        return sparepartUpdatedAt;
    }

    public void setSparepartUpdatedAt(Date sparepartUpdatedAt) {
        this.sparepartUpdatedAt = sparepartUpdatedAt;
    }

    public List<ItemInvoice> getItemInvoiceList() {
        return itemInvoiceList;
    }

    public void setItemInvoiceList(List<ItemInvoice> itemInvoiceList) {
        this.itemInvoiceList = itemInvoiceList;
    }

    public List<SupplyParts> getSupplyPartsList() {
        return supplyPartsList;
    }

    public void setSupplyPartsList(List<SupplyParts> supplyPartsList) {
        this.supplyPartsList = supplyPartsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sparepartId != null ? sparepartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spareparts)) {
            return false;
        }
        Spareparts other = (Spareparts) object;
        if ((this.sparepartId == null && other.sparepartId != null) || (this.sparepartId != null && !this.sparepartId.equals(other.sparepartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Spareparts[ sparepartId=" + sparepartId + " ]";
    }
    
}
