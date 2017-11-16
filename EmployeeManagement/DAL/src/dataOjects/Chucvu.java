/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataOjects;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NguyenPH
 */
@Entity
@Table(name = "chucvu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chucvu.findAll", query = "SELECT c FROM Chucvu c")
    , @NamedQuery(name = "Chucvu.findByMachucvu", query = "SELECT c FROM Chucvu c WHERE c.machucvu = :machucvu")
    , @NamedQuery(name = "Chucvu.findByTenchucvu", query = "SELECT c FROM Chucvu c WHERE c.tenchucvu = :tenchucvu")})
public class Chucvu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MACHUCVU")
    private String machucvu;
    @Basic(optional = false)
    @Column(name = "TENCHUCVU")
    private String tenchucvu;

    public Chucvu() {
    }

    public Chucvu(String machucvu) {
        this.machucvu = machucvu;
    }

    public Chucvu(String machucvu, String tenchucvu) {
        this.machucvu = machucvu;
        this.tenchucvu = tenchucvu;
    }

    public String getMachucvu() {
        return machucvu;
    }

    public void setMachucvu(String machucvu) {
        this.machucvu = machucvu;
    }

    public String getTenchucvu() {
        return tenchucvu;
    }

    public void setTenchucvu(String tenchucvu) {
        this.tenchucvu = tenchucvu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (machucvu != null ? machucvu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chucvu)) {
            return false;
        }
        Chucvu other = (Chucvu) object;
        if ((this.machucvu == null && other.machucvu != null) || (this.machucvu != null && !this.machucvu.equals(other.machucvu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dataOjects.Chucvu[ machucvu=" + machucvu + " ]";
    }
    
}
