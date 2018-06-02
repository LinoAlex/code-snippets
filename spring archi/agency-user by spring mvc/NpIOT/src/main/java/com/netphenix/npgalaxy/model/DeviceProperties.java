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
import javax.persistence.Lob;
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
@Table(name = "device_properties")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeviceProperties.findAll", query = "SELECT d FROM DeviceProperties d")
    , @NamedQuery(name = "DeviceProperties.findById", query = "SELECT d FROM DeviceProperties d WHERE d.id = :id")
    , @NamedQuery(name = "DeviceProperties.findByPropertyName", query = "SELECT d FROM DeviceProperties d WHERE d.propertyName = :propertyName")
    , @NamedQuery(name = "DeviceProperties.findByPropertyDefaultValue", query = "SELECT d FROM DeviceProperties d WHERE d.propertyDefaultValue = :propertyDefaultValue")
    , @NamedQuery(name = "DeviceProperties.findByPropertyValue", query = "SELECT d FROM DeviceProperties d WHERE d.propertyValue = :propertyValue")
    , @NamedQuery(name = "DeviceProperties.findByDeviceId", query = "SELECT d FROM DeviceProperties d WHERE d.deviceId = :deviceId")
    , @NamedQuery(name = "DeviceProperties.findByDeviceTypeId", query = "SELECT d FROM DeviceProperties d WHERE d.deviceTypeId = :deviceTypeId")})
public class DeviceProperties implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 124)
    @Column(name = "property_name")
    private String propertyName;
    @Size(max = 1024)
    @Column(name = "property_default_value")
    private String propertyDefaultValue;
    @Size(max = 1024)
    @Column(name = "property_value")
    private String propertyValue;
    @Column(name = "device_id")
    private Integer deviceId;
    @Column(name = "device_type_id")
    private Integer deviceTypeId;
    @Lob
    @Size(max = 65535)
    @Column(name = "remarks")
    private String remarks;

    public DeviceProperties() {
    }

    public DeviceProperties(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyDefaultValue() {
        return propertyDefaultValue;
    }

    public void setPropertyDefaultValue(String propertyDefaultValue) {
        this.propertyDefaultValue = propertyDefaultValue;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(Integer deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
        if (!(object instanceof DeviceProperties)) {
            return false;
        }
        DeviceProperties other = (DeviceProperties) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.netphenix.npgalaxy.model.DeviceProperties[ id=" + id + " ]";
    }
    
}
