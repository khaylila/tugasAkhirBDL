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
@Table(name = "supplier")
@NamedQueries({
    @NamedQuery(name = "Supplier.findAll", query = "SELECT s FROM Supplier s"),
    @NamedQuery(name = "Supplier.findBySuplierId", query = "SELECT s FROM Supplier s WHERE s.suplierId = :suplierId"),
    @NamedQuery(name = "Supplier.findBySuplierNama", query = "SELECT s FROM Supplier s WHERE s.suplierNama = :suplierNama"),
    @NamedQuery(name = "Supplier.findBySuplierAlamat", query = "SELECT s FROM Supplier s WHERE s.suplierAlamat = :suplierAlamat"),
    @NamedQuery(name = "Supplier.findBySuplierTelpon", query = "SELECT s FROM Supplier s WHERE s.suplierTelpon = :suplierTelpon"),
    @NamedQuery(name = "Supplier.findBySuplierCreatedAt", query = "SELECT s FROM Supplier s WHERE s.suplierCreatedAt = :suplierCreatedAt"),
    @NamedQuery(name = "Supplier.findBySuplierUpdatedAt", query = "SELECT s FROM Supplier s WHERE s.suplierUpdatedAt = :suplierUpdatedAt")})
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "suplier_id")
    private Integer suplierId;
    @Column(name = "suplier_nama")
    private String suplierNama;
    @Column(name = "suplier_alamat")
    private String suplierAlamat;
    @Column(name = "suplier_telpon")
    private String suplierTelpon;
    @Column(name = "suplier_created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date suplierCreatedAt;
    @Column(name = "suplier_updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date suplierUpdatedAt;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private Users userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierId")
    private List<SupplyParts> supplyPartsList;

    public Supplier() {
    }

    public Supplier(Integer suplierId) {
        this.suplierId = suplierId;
    }

    public Integer getSuplierId() {
        return suplierId;
    }

    public void setSuplierId(Integer suplierId) {
        this.suplierId = suplierId;
    }

    public String getSuplierNama() {
        return suplierNama;
    }

    public void setSuplierNama(String suplierNama) {
        this.suplierNama = suplierNama;
    }

    public String getSuplierAlamat() {
        return suplierAlamat;
    }

    public void setSuplierAlamat(String suplierAlamat) {
        this.suplierAlamat = suplierAlamat;
    }

    public String getSuplierTelpon() {
        return suplierTelpon;
    }

    public void setSuplierTelpon(String suplierTelpon) {
        this.suplierTelpon = suplierTelpon;
    }

    public Date getSuplierCreatedAt() {
        return suplierCreatedAt;
    }

    public void setSuplierCreatedAt(Date suplierCreatedAt) {
        this.suplierCreatedAt = suplierCreatedAt;
    }

    public Date getSuplierUpdatedAt() {
        return suplierUpdatedAt;
    }

    public void setSuplierUpdatedAt(Date suplierUpdatedAt) {
        this.suplierUpdatedAt = suplierUpdatedAt;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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
        hash += (suplierId != null ? suplierId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.suplierId == null && other.suplierId != null) || (this.suplierId != null && !this.suplierId.equals(other.suplierId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Supplier[ suplierId=" + suplierId + " ]";
    }
    
}
