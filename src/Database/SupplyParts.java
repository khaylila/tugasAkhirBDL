/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 *
 * @author milea
 */
@Entity
@Table(name = "supply_parts")
@NamedQueries({
    @NamedQuery(name = "SupplyParts.findAll", query = "SELECT s FROM SupplyParts s"),
    @NamedQuery(name = "SupplyParts.findBySupplyPartId", query = "SELECT s FROM SupplyParts s WHERE s.supplyPartId = :supplyPartId"),
    @NamedQuery(name = "SupplyParts.findBySupplyPartQty", query = "SELECT s FROM SupplyParts s WHERE s.supplyPartQty = :supplyPartQty"),
    @NamedQuery(name = "SupplyParts.findBySupplyPartHargaBeli", query = "SELECT s FROM SupplyParts s WHERE s.supplyPartHargaBeli = :supplyPartHargaBeli")})
public class SupplyParts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "supply_part_id")
    private Integer supplyPartId;
    @Column(name = "supply_part_qty")
    private Integer supplyPartQty;
    @Column(name = "supply_part_harga_beli")
    private Integer supplyPartHargaBeli;
    @JoinColumn(name = "sparepart_id", referencedColumnName = "sparepart_id")
    @ManyToOne(optional = false)
    private Spareparts sparepartId;
    @JoinColumn(name = "supplier_id", referencedColumnName = "suplier_id")
    @ManyToOne(optional = false)
    private Supplier supplierId;

    public SupplyParts() {
    }

    public SupplyParts(Integer supplyPartId) {
        this.supplyPartId = supplyPartId;
    }

    public Integer getSupplyPartId() {
        return supplyPartId;
    }

    public void setSupplyPartId(Integer supplyPartId) {
        this.supplyPartId = supplyPartId;
    }

    public Integer getSupplyPartQty() {
        return supplyPartQty;
    }

    public void setSupplyPartQty(Integer supplyPartQty) {
        this.supplyPartQty = supplyPartQty;
    }

    public Integer getSupplyPartHargaBeli() {
        return supplyPartHargaBeli;
    }

    public void setSupplyPartHargaBeli(Integer supplyPartHargaBeli) {
        this.supplyPartHargaBeli = supplyPartHargaBeli;
    }

    public Spareparts getSparepartId() {
        return sparepartId;
    }

    public void setSparepartId(Spareparts sparepartId) {
        this.sparepartId = sparepartId;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplyPartId != null ? supplyPartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupplyParts)) {
            return false;
        }
        SupplyParts other = (SupplyParts) object;
        if ((this.supplyPartId == null && other.supplyPartId != null) || (this.supplyPartId != null && !this.supplyPartId.equals(other.supplyPartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.SupplyParts[ supplyPartId=" + supplyPartId + " ]";
    }
    
}
