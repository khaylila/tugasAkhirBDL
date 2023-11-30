/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.io.Serializable;
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

/**
 *
 * @author milea
 */
@Entity
@Table(name = "customer")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "Customer.findByCustomerFullname", query = "SELECT c FROM Customer c WHERE c.customerFullname = :customerFullname"),
    @NamedQuery(name = "Customer.findByCustomerAlamat", query = "SELECT c FROM Customer c WHERE c.customerAlamat = :customerAlamat"),
    @NamedQuery(name = "Customer.findByCustomerTelepon", query = "SELECT c FROM Customer c WHERE c.customerTelepon = :customerTelepon"),
    @NamedQuery(name = "Customer.findByLikeCustomerFullname", query = "SELECT c FROM Customer c WHERE UPPER(c.customerFullname) LIKE UPPER(:parameter)"),
    @NamedQuery(name = "Customer.findByCustomerAlamat", query = "SELECT c FROM Customer c WHERE UPPER(c.customerAlamat) LIKE UPPER(:parameter)")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "customer_fullname")
    private String customerFullname;
    @Column(name = "customer_alamat")
    private String customerAlamat;
    @Column(name = "customer_telepon")
    private String customerTelepon;
    @OneToMany(mappedBy = "customerId")
    private List<Pembayaran> pembayaranList;
    @OneToMany(mappedBy = "customerId")
    private List<Projects> projectsList;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private Users userId;

    public Customer() {
    }

    public Customer(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFullname() {
        return customerFullname;
    }

    public void setCustomerFullname(String customerFullname) {
        this.customerFullname = customerFullname;
    }

    public String getCustomerAlamat() {
        return customerAlamat;
    }

    public void setCustomerAlamat(String customerAlamat) {
        this.customerAlamat = customerAlamat;
    }

    public String getCustomerTelepon() {
        return customerTelepon;
    }

    public void setCustomerTelepon(String customerTelepon) {
        this.customerTelepon = customerTelepon;
    }

    public List<Pembayaran> getPembayaranList() {
        return pembayaranList;
    }

    public void setPembayaranList(List<Pembayaran> pembayaranList) {
        this.pembayaranList = pembayaranList;
    }

    public List<Projects> getProjectsList() {
        return projectsList;
    }

    public void setProjectsList(List<Projects> projectsList) {
        this.projectsList = projectsList;
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
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Customer[ customerId=" + customerId + " ]";
    }
    
}
