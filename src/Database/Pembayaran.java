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
@Table(name = "pembayaran")
@NamedQueries({
    @NamedQuery(name = "Pembayaran.findAll", query = "SELECT p FROM Pembayaran p"),
    @NamedQuery(name = "Pembayaran.findByPembayaranId", query = "SELECT p FROM Pembayaran p WHERE p.pembayaranId = :pembayaranId"),
    @NamedQuery(name = "Pembayaran.findByPembayaranTotal", query = "SELECT p FROM Pembayaran p WHERE p.pembayaranTotal = :pembayaranTotal"),
    @NamedQuery(name = "Pembayaran.findByPembayaranTanggal", query = "SELECT p FROM Pembayaran p WHERE p.pembayaranTanggal = :pembayaranTanggal")})
public class Pembayaran implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pembayaran_id")
    private Integer pembayaranId;
    @Column(name = "pembayaran_total")
    private Integer pembayaranTotal;
    @Column(name = "pembayaran_tanggal")
    @Temporal(TemporalType.DATE)
    private Date pembayaranTanggal;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne
    private Customer customerId;
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @ManyToOne
    private Projects projectId;

    public Pembayaran() {
    }

    public Pembayaran(Integer pembayaranId) {
        this.pembayaranId = pembayaranId;
    }

    public Integer getPembayaranId() {
        return pembayaranId;
    }

    public void setPembayaranId(Integer pembayaranId) {
        this.pembayaranId = pembayaranId;
    }

    public Integer getPembayaranTotal() {
        return pembayaranTotal;
    }

    public void setPembayaranTotal(Integer pembayaranTotal) {
        this.pembayaranTotal = pembayaranTotal;
    }

    public Date getPembayaranTanggal() {
        return pembayaranTanggal;
    }

    public void setPembayaranTanggal(Date pembayaranTanggal) {
        this.pembayaranTanggal = pembayaranTanggal;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Projects getProjectId() {
        return projectId;
    }

    public void setProjectId(Projects projectId) {
        this.projectId = projectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pembayaranId != null ? pembayaranId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pembayaran)) {
            return false;
        }
        Pembayaran other = (Pembayaran) object;
        if ((this.pembayaranId == null && other.pembayaranId != null) || (this.pembayaranId != null && !this.pembayaranId.equals(other.pembayaranId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Pembayaran[ pembayaranId=" + pembayaranId + " ]";
    }
    
}
