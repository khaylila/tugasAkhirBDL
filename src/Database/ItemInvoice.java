/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author milea
 */
@Entity
@Table(name = "item_invoice")
@NamedQueries({
    @NamedQuery(name = "ItemInvoice.findAll", query = "SELECT i FROM ItemInvoice i"),
    @NamedQuery(name = "ItemInvoice.findByInvoiceItemId", query = "SELECT i FROM ItemInvoice i WHERE i.invoiceItemId = :invoiceItemId"),
    @NamedQuery(name = "ItemInvoice.findByInvoiceItemQty", query = "SELECT i FROM ItemInvoice i WHERE i.invoiceItemQty = :invoiceItemQty"),
    @NamedQuery(name = "ItemInvoice.findByInvoiceItemHarga", query = "SELECT i FROM ItemInvoice i WHERE i.invoiceItemHarga = :invoiceItemHarga"),
    @NamedQuery(name = "ItemInvoice.findByInvoiceItemCreatedAt", query = "SELECT i FROM ItemInvoice i WHERE i.invoiceItemCreatedAt = :invoiceItemCreatedAt"),
    @NamedQuery(name = "ItemInvoice.findByInvoiceItemUpdatedAt", query = "SELECT i FROM ItemInvoice i WHERE i.invoiceItemUpdatedAt = :invoiceItemUpdatedAt")})
public class ItemInvoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invoice_item_id")
    private Integer invoiceItemId;
    @Column(name = "invoice_item_qty")
    private Integer invoiceItemQty;
    @Column(name = "invoice_item_harga")
    private Integer invoiceItemHarga;
    @Column(name = "invoice_item_created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invoiceItemCreatedAt;
    @Column(name = "invoice_item_updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invoiceItemUpdatedAt;
    @JoinColumn(name = "jasa_id", referencedColumnName = "jasa_id")
    @ManyToOne
    private Jasa jasaId;
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @ManyToOne
    private Projects projectId;
    @JoinColumn(name = "sparepart_id", referencedColumnName = "sparepart_id")
    @ManyToOne
    private Spareparts sparepartId;

    public ItemInvoice() {
    }

    public ItemInvoice(Integer invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public Integer getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(Integer invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public Integer getInvoiceItemQty() {
        return invoiceItemQty;
    }

    public void setInvoiceItemQty(Integer invoiceItemQty) {
        this.invoiceItemQty = invoiceItemQty;
    }

    public Integer getInvoiceItemHarga() {
        return invoiceItemHarga;
    }

    public void setInvoiceItemHarga(Integer invoiceItemHarga) {
        this.invoiceItemHarga = invoiceItemHarga;
    }

    public Date getInvoiceItemCreatedAt() {
        return invoiceItemCreatedAt;
    }

    public void setInvoiceItemCreatedAt(Date invoiceItemCreatedAt) {
        this.invoiceItemCreatedAt = invoiceItemCreatedAt;
    }

    public Date getInvoiceItemUpdatedAt() {
        return invoiceItemUpdatedAt;
    }

    public void setInvoiceItemUpdatedAt(Date invoiceItemUpdatedAt) {
        this.invoiceItemUpdatedAt = invoiceItemUpdatedAt;
    }

    public Jasa getJasaId() {
        return jasaId;
    }

    public void setJasaId(Jasa jasaId) {
        this.jasaId = jasaId;
    }

    public Projects getProjectId() {
        return projectId;
    }

    public void setProjectId(Projects projectId) {
        this.projectId = projectId;
    }

    public Spareparts getSparepartId() {
        return sparepartId;
    }

    public void setSparepartId(Spareparts sparepartId) {
        this.sparepartId = sparepartId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceItemId != null ? invoiceItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemInvoice)) {
            return false;
        }
        ItemInvoice other = (ItemInvoice) object;
        if ((this.invoiceItemId == null && other.invoiceItemId != null) || (this.invoiceItemId != null && !this.invoiceItemId.equals(other.invoiceItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.ItemInvoice[ invoiceItemId=" + invoiceItemId + " ]";
    }
    
}
