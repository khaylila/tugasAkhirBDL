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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author milea
 */
@Entity
@Table(name = "cars")
@NamedQueries({
    @NamedQuery(name = "Cars.findAll", query = "SELECT c FROM Cars c"),
    @NamedQuery(name = "Cars.findByMobilId", query = "SELECT c FROM Cars c WHERE c.mobilId = :mobilId"),
    @NamedQuery(name = "Cars.findByMobilNama", query = "SELECT c FROM Cars c WHERE c.mobilNama = :mobilNama"),
    @NamedQuery(name = "Cars.findByMobilPabrikan", query = "SELECT c FROM Cars c WHERE c.mobilPabrikan = :mobilPabrikan"),
    @NamedQuery(name = "Cars.findByMobilTipe", query = "SELECT c FROM Cars c WHERE c.mobilTipe = :mobilTipe"),
    @NamedQuery(name = "Cars.findByMobilTahun", query = "SELECT c FROM Cars c WHERE c.mobilTahun = :mobilTahun"),
    @NamedQuery(name = "Cars.findByMobilKapasitasMesin", query = "SELECT c FROM Cars c WHERE c.mobilKapasitasMesin = :parameter"),
    @NamedQuery(name = "Cars.findByLikeMobilNama", query = "SELECT c FROM Cars c WHERE UPPER(c.mobilNama) LIKE UPPER(:parameter)"),
    @NamedQuery(name = "Cars.findByLikeMobilPabrikan", query = "SELECT c FROM Cars c WHERE UPPER(c.mobilPabrikan) LIKE (:parameter)"),
    @NamedQuery(name = "Cars.findByLikeMobilTipe", query = "SELECT c FROM Cars c WHERE UPPER(c.mobilTipe) LIKE (:parameter)"),
    @NamedQuery(name = "Cars.findByLikeMobilTahun", query = "SELECT c FROM Cars c WHERE c.mobilTahun LIKE :parameter")})
public class Cars implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mobil_id")
    private Integer mobilId;
    @Column(name = "mobil_nama")
    private String mobilNama;
    @Column(name = "mobil_pabrikan")
    private String mobilPabrikan;
    @Column(name = "mobil_tipe")
    private String mobilTipe;
    @Column(name = "mobil_tahun")
    private String mobilTahun;
    @Column(name = "mobil_kapasitas_mesin")
    private Integer mobilKapasitasMesin;

    public Cars() {
    }

    public Cars(Integer mobilId) {
        this.mobilId = mobilId;
    }

    public Integer getMobilId() {
        return mobilId;
    }

    public void setMobilId(Integer mobilId) {
        this.mobilId = mobilId;
    }

    public String getMobilNama() {
        return mobilNama;
    }

    public void setMobilNama(String mobilNama) {
        this.mobilNama = mobilNama;
    }

    public String getMobilPabrikan() {
        return mobilPabrikan;
    }

    public void setMobilPabrikan(String mobilPabrikan) {
        this.mobilPabrikan = mobilPabrikan;
    }

    public String getMobilTipe() {
        return mobilTipe;
    }

    public void setMobilTipe(String mobilTipe) {
        this.mobilTipe = mobilTipe;
    }

    public String getMobilTahun() {
        return mobilTahun;
    }

    public void setMobilTahun(String mobilTahun) {
        this.mobilTahun = mobilTahun;
    }

    public Integer getMobilKapasitasMesin() {
        return mobilKapasitasMesin;
    }

    public void setMobilKapasitasMesin(Integer mobilKapasitasMesin) {
        this.mobilKapasitasMesin = mobilKapasitasMesin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mobilId != null ? mobilId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cars)) {
            return false;
        }
        Cars other = (Cars) object;
        if ((this.mobilId == null && other.mobilId != null) || (this.mobilId != null && !this.mobilId.equals(other.mobilId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Cars[ mobilId=" + mobilId + " ]";
    }
    
}
