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
@Table(name = "projects")
@NamedQueries({
    @NamedQuery(name = "Projects.findAll", query = "SELECT p FROM Projects p"),
    @NamedQuery(name = "Projects.findByProjectId", query = "SELECT p FROM Projects p WHERE p.projectId = :projectId"),
    @NamedQuery(name = "Projects.findByTahunMobil", query = "SELECT p FROM Projects p WHERE p.tahunMobil = :tahunMobil"),
    @NamedQuery(name = "Projects.findByDetailKerusakan", query = "SELECT p FROM Projects p WHERE p.detailKerusakan = :detailKerusakan"),
    @NamedQuery(name = "Projects.findByTanggalMasuk", query = "SELECT p FROM Projects p WHERE p.tanggalMasuk = :tanggalMasuk"),
    @NamedQuery(name = "Projects.findByTanggalKeluar", query = "SELECT p FROM Projects p WHERE p.tanggalKeluar = :tanggalKeluar"),
    @NamedQuery(name = "Projects.findByProjectStatus", query = "SELECT p FROM Projects p WHERE p.projectStatus = :projectStatus"),
    @NamedQuery(name = "Projects.findByTanggalInvoice", query = "SELECT p FROM Projects p WHERE p.tanggalInvoice = :tanggalInvoice"),
    @NamedQuery(name = "Projects.findByProjectCreatedAt", query = "SELECT p FROM Projects p WHERE p.projectCreatedAt = :projectCreatedAt"),
    @NamedQuery(name = "Projects.findByProjectUpdatedAt", query = "SELECT p FROM Projects p WHERE p.projectUpdatedAt = :projectUpdatedAt"),
    @NamedQuery(name = "Projects.findByPlatNomor", query = "SELECT p FROM Projects p WHERE p.platNomor = :platNomor"),
    @NamedQuery(name = "Projects.findByLikeCustomerName", query = "SELECT p FROM Projects p WHERE UPPER(p.customerId.customerFullname) LIKE UPPER(:parameter) AND EXTRACT(MONTH FROM b.createdAt) = :month AND EXTRACT(YEAR FROM b.createdAt) = :year"),
    @NamedQuery(name = "Projects.findByLikePlatNomor", query = "SELECT p FROM Projects p WHERE UPPER(p.platNomor) LIKE UPPER(:parameter) AND EXTRACT(MONTH FROM b.createdAt) = :month AND EXTRACT(YEAR FROM b.createdAt) = :year")})
public class Projects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "project_id")
    private Integer projectId;
    @Column(name = "tahun_mobil")
    private Integer tahunMobil;
    @Column(name = "detail_kerusakan")
    private String detailKerusakan;
    @Column(name = "tanggal_masuk")
    @Temporal(TemporalType.DATE)
    private Date tanggalMasuk;
    @Column(name = "tanggal_keluar")
    @Temporal(TemporalType.DATE)
    private Date tanggalKeluar;
    @Column(name = "project_status")
    private String projectStatus;
    @Column(name = "tanggal_invoice")
    @Temporal(TemporalType.DATE)
    private Date tanggalInvoice;
    @Column(name = "project_created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date projectCreatedAt;
    @Column(name = "project_updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date projectUpdatedAt;
    @Column(name = "plat_nomor")
    private String platNomor;
    @OneToMany(mappedBy = "projectId")
    private List<ItemInvoice> itemInvoiceList;
    @OneToMany(mappedBy = "projectId")
    private List<Pembayaran> pembayaranList;
    @JoinColumn(name = "mobil_id", referencedColumnName = "mobil_id")
    @ManyToOne
    private Cars mobilId;
    @JoinColumn(name = "warna_id", referencedColumnName = "warna_id")
    @ManyToOne
    private Colors warnaId;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne
    private Customer customerId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private Users userId;

    public Projects() {
    }

    public Projects(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getTahunMobil() {
        return tahunMobil;
    }

    public void setTahunMobil(Integer tahunMobil) {
        this.tahunMobil = tahunMobil;
    }

    public String getDetailKerusakan() {
        return detailKerusakan;
    }

    public void setDetailKerusakan(String detailKerusakan) {
        this.detailKerusakan = detailKerusakan;
    }

    public Date getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(Date tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public Date getTanggalKeluar() {
        return tanggalKeluar;
    }

    public void setTanggalKeluar(Date tanggalKeluar) {
        this.tanggalKeluar = tanggalKeluar;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Date getTanggalInvoice() {
        return tanggalInvoice;
    }

    public void setTanggalInvoice(Date tanggalInvoice) {
        this.tanggalInvoice = tanggalInvoice;
    }

    public Date getProjectCreatedAt() {
        return projectCreatedAt;
    }

    public void setProjectCreatedAt(Date projectCreatedAt) {
        this.projectCreatedAt = projectCreatedAt;
    }

    public Date getProjectUpdatedAt() {
        return projectUpdatedAt;
    }

    public void setProjectUpdatedAt(Date projectUpdatedAt) {
        this.projectUpdatedAt = projectUpdatedAt;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public List<ItemInvoice> getItemInvoiceList() {
        return itemInvoiceList;
    }

    public void setItemInvoiceList(List<ItemInvoice> itemInvoiceList) {
        this.itemInvoiceList = itemInvoiceList;
    }

    public List<Pembayaran> getPembayaranList() {
        return pembayaranList;
    }

    public void setPembayaranList(List<Pembayaran> pembayaranList) {
        this.pembayaranList = pembayaranList;
    }

    public Cars getMobilId() {
        return mobilId;
    }

    public void setMobilId(Cars mobilId) {
        this.mobilId = mobilId;
    }

    public Colors getWarnaId() {
        return warnaId;
    }

    public void setWarnaId(Colors warnaId) {
        this.warnaId = warnaId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
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
        hash += (projectId != null ? projectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projects)) {
            return false;
        }
        Projects other = (Projects) object;
        if ((this.projectId == null && other.projectId != null) || (this.projectId != null && !this.projectId.equals(other.projectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Projects[ projectId=" + projectId + " ]";
    }
    
}
