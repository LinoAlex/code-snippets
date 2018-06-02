/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netphenix.npgalaxy.model;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author samraj
 */
@Entity
@Table(name = "dpu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dpu.findAll", query = "SELECT d FROM Dpu d")
    , @NamedQuery(name = "Dpu.findById", query = "SELECT d FROM Dpu d WHERE d.id = :id")
    , @NamedQuery(name = "Dpu.findByLatitude", query = "SELECT d FROM Dpu d WHERE d.latitude = :latitude")
    , @NamedQuery(name = "Dpu.findByLongitude", query = "SELECT d FROM Dpu d WHERE d.longitude = :longitude")
    , @NamedQuery(name = "Dpu.findByDpuName", query = "SELECT d FROM Dpu d WHERE d.dpuName = :dpuName")
    , @NamedQuery(name = "Dpu.findByOsName", query = "SELECT d FROM Dpu d WHERE d.osName = :osName")
    , @NamedQuery(name = "Dpu.findByOsVersion", query = "SELECT d FROM Dpu d WHERE d.osVersion = :osVersion")
    , @NamedQuery(name = "Dpu.findByUrlPath", query = "SELECT d FROM Dpu d WHERE d.urlPath = :urlPath")})
public class Dpu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "latitude")
    private String latitude;
    @Size(max = 45)
    @Column(name = "longitude")
    private String longitude;
    @Size(max = 45)
    @Column(name = "dpu_name")
    private String dpuName;
    @Size(max = 45)
    @Column(name = "os_name")
    private String osName;
    @Size(max = 45)
    @Column(name = "os_version")
    private String osVersion;
    @Size(max = 1024)
    @Column(name = "url_path")
    private String urlPath;

    public Dpu() {
    }

    public Dpu(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDpuName() {
        return dpuName;
    }

    public void setDpuName(String dpuName) {
        this.dpuName = dpuName;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dpu)) {
            return false;
        }
        Dpu other = (Dpu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.netphenix.npgalaxy.model.Dpu[ id=" + id + " ]";
    }
    
}
