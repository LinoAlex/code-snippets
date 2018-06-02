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
@Table(name = "device")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Device.findAll", query = "SELECT d FROM Device d")
    , @NamedQuery(name = "Device.findById", query = "SELECT d FROM Device d WHERE d.id = :id")
    , @NamedQuery(name = "Device.findByDeviceName", query = "SELECT d FROM Device d WHERE d.deviceName = :deviceName")
    , @NamedQuery(name = "Device.findByUrlPath", query = "SELECT d FROM Device d WHERE d.urlPath = :urlPath")
    , @NamedQuery(name = "Device.findByLatitude", query = "SELECT d FROM Device d WHERE d.latitude = :latitude")
    , @NamedQuery(name = "Device.findByLongitude", query = "SELECT d FROM Device d WHERE d.longitude = :longitude")
    , @NamedQuery(name = "Device.findByDpuId", query = "SELECT d FROM Device d WHERE d.dpuId = :dpuId")
    , @NamedQuery(name = "Device.findByContactId", query = "SELECT d FROM Device d WHERE d.contactId = :contactId")
    , @NamedQuery(name = "Device.findByDeviceSerialNumber", query = "SELECT d FROM Device d WHERE d.deviceSerialNumber = :deviceSerialNumber")
    , @NamedQuery(name = "Device.findByDeviceTypeId", query = "SELECT d FROM Device d WHERE d.deviceTypeId = :deviceTypeId")})
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 1024)
    @Column(name = "device_name")
    private String deviceName;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Size(max = 1024)
    @Column(name = "url_path")
    private String urlPath;
    @Size(max = 16)
    @Column(name = "latitude")
    private String latitude;
    @Size(max = 16)
    @Column(name = "longitude")
    private String longitude;
    @Column(name = "dpu_id")
    private Integer dpuId;
    @Column(name = "contact_id")
    private Integer contactId;
    @Size(max = 124)
    @Column(name = "device_serial_number")
    private String deviceSerialNumber;
    @Column(name = "device_type_id")
    private Integer deviceTypeId;

    public Device() {
    }

    public Device(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
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

    public Integer getDpuId() {
        return dpuId;
    }

    public void setDpuId(Integer dpuId) {
        this.dpuId = dpuId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getDeviceSerialNumber() {
        return deviceSerialNumber;
    }

    public void setDeviceSerialNumber(String deviceSerialNumber) {
        this.deviceSerialNumber = deviceSerialNumber;
    }

    public Integer getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(Integer deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
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
        if (!(object instanceof Device)) {
            return false;
        }
        Device other = (Device) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.netphenix.npgalaxy.model.Device[ id=" + id + " ]";
    }
    
}
