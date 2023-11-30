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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author milea
 */
@Entity
@Table(name = "colors")
@NamedQueries({
    @NamedQuery(name = "Colors.findAll", query = "SELECT c FROM Colors c"),
    @NamedQuery(name = "Colors.findByWarnaId", query = "SELECT c FROM Colors c WHERE c.warnaId = :warnaId"),
    @NamedQuery(name = "Colors.findByWarnaNama", query = "SELECT c FROM Colors c WHERE c.warnaNama = :warnaNama")})
public class Colors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "warna_id")
    private Integer warnaId;
    @Column(name = "warna_nama")
    private String warnaNama;
    @OneToMany(mappedBy = "warnaId")
    private List<Projects> projectsList;

    public Colors() {
    }

    public Colors(Integer warnaId) {
        this.warnaId = warnaId;
    }

    public Integer getWarnaId() {
        return warnaId;
    }

    public void setWarnaId(Integer warnaId) {
        this.warnaId = warnaId;
    }

    public String getWarnaNama() {
        return warnaNama;
    }

    public void setWarnaNama(String warnaNama) {
        this.warnaNama = warnaNama;
    }

    public List<Projects> getProjectsList() {
        return projectsList;
    }

    public void setProjectsList(List<Projects> projectsList) {
        this.projectsList = projectsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (warnaId != null ? warnaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colors)) {
            return false;
        }
        Colors other = (Colors) object;
        if ((this.warnaId == null && other.warnaId != null) || (this.warnaId != null && !this.warnaId.equals(other.warnaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Colors[ warnaId=" + warnaId + " ]";
    }
    
}
