/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netphenix.npgalaxy.model;

import com.netphenix.npgalaxy.utils.DateUtils;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author netphenix
 */
@Entity
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT w FROM Client w"),
    @NamedQuery(name = "Client.findById", query = "SELECT w FROM Client w WHERE w.id = :id"),
    @NamedQuery(name = "Client.findByClientRefId", query = "SELECT w FROM Client w WHERE w.clientRefId = :clientRefId"),
    @NamedQuery(name = "Client.findBySiteId", query = "SELECT w FROM Client w WHERE w.siteId = :siteId"),
    @NamedQuery(name = "Client.findByClientName", query = "SELECT w FROM Client w WHERE w.clientName = :clientName"),
    @NamedQuery(name = "Client.findByWebsite", query = "SELECT w FROM Client w WHERE w.website = :website"),
    @NamedQuery(name = "Client.findByCreatedTime", query = "SELECT w FROM Client w WHERE w.createdTime = :createdTime"),
    @NamedQuery(name = "Client.findByEmail", query = "SELECT w FROM Client w WHERE w.email = :email"),
    @NamedQuery(name = "Client.findByLastSiteVisit", query = "SELECT w FROM Client w WHERE w.lastSiteVisit = :lastSiteVisit"),
    @NamedQuery(name = "Client.findByStatus", query = "SELECT w FROM Client w WHERE w.status = :status")})
public class Client implements Serializable {
    @Size(max = 255)
    @Column(name = "accountmanager_email")
    private String accountmanagerEmail;
    @Size(max = 255)
    @Column(name = "accountmanager_name")
    private String accountmanagerName;
    @Size(max = 255)
    @Column(name = "accountmanager_title")
    private String accountmanagerTitle;
    @Column(name = "client_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date clientCreateDate;

    @Size(max = 256)
    @Column(name = "client_group")
    private String clientGroup;
    @Size(max = 1024)
    @Column(name = "oem")
    private String oem;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 256)
    @Column(name = "client_ref_id")
    private String clientRefId;
    @Size(max = 128)
    @Column(name = "site_id")
    private String siteId;
    @Size(max = 1024)
    @Column(name = "client_name")
    private String clientName;
    @Size(max = 4000)
    @Column(name = "client_address")
    private String clientAddress;
    @Size(max = 4000)
    @Column(name = "client_state")
    private String clientState;
    @Size(max = 4000)
    @Column(name = "client_city")
    private String clientCity;
    @Size(max = 64)
    @Column(name = "client_zip")
    private String clientZip;
    @Size(max = 1024)
    @Column(name = "segment_name")
    private String segmentName;
    @Size(max = 1024)
    @Column(name = "timezoneName")
    private String timezoneName;
    @Size(max = 1024)
    @Column(name = "oem_name")
    private String oemName;
    @Size(max = 32)
    @Column(name = "oem_program_id")
    private String oemProgramId;
    @Size(max = 1024)
    @Column(name = "oem_program_name")
    private String oemProgramName;
    @Size(max = 32)
    @Column(name = "oem_region_id")
    private String oemRegionId;
    @Size(max = 1024)
    @Column(name = "oem_region_name")
    private String oemRegionName;

    @Size(max = 1024)
    @Column(name = "active_clients_product_name")
    private String activeClientsProductName;
    @Size(max = 1024)
    @Column(name = "digital_advisor")
    private String digitalAdvisor;
    @Size(max = 64)
    @Column(name = "phone")
    private String phone;
    @Size(max = 1024)
    @Column(name = "website")
    private String website;
    @Column(name = "created_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    @Column(name = "campaign_launch_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date campaignLaunchDate;
    @Column(name = "first_contract_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstContractTime;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 1024)
    @Column(name = "email")
    private String email;
    @Size(max = 1024)
    @Column(name = "communication_email")
    private String communicationEmail;
    @Column(name = "last_site_visit")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastSiteVisit;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @Size(max = 45)
    @Column(name = "map_status")
    private String mapStatus;
    @Column(name = "budget")
    private Double budget;

    public Client() {
    }

    public Client(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientRefId() {
        return clientRefId;
    }

    public void setClientRefId(String clientRefId) {
        this.clientRefId = clientRefId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCommunicationEmail() {
        return communicationEmail;
    }

    public void setCommunicationEmail(String communicationEmail) {
        this.communicationEmail = communicationEmail;
    }

    public Date getLastSiteVisit() {
        return lastSiteVisit;
    }

    public void setLastSiteVisit(Date lastSiteVisit) {
        this.lastSiteVisit = lastSiteVisit;
    }

    public String getStatus() {
        if (lastSiteVisit == null) {
            return "InActive";
        }

        Date yesterday = DateUtils.getYesterday();

        Long dateDiff = DateUtils.dateDiffInSec(yesterday, lastSiteVisit);
        if (dateDiff > 0) {
            System.out.println(this.getClientName() + " - " + yesterday + " - " + lastSiteVisit + " Diff: " + dateDiff);
            return "InActive";
        }

        return "Active";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMapStatus() {
        return mapStatus;
    }

    public void setMapStatus(String mapStatus) {
        this.mapStatus = mapStatus;
    }
    
    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientState() {
        return clientState;
    }

    public void setClientState(String clientState) {
        this.clientState = clientState;
    }

    public String getClientCity() {
        return clientCity;
    }

    public void setClientCity(String clientCity) {
        this.clientCity = clientCity;
    }

    public String getClientZip() {
        return clientZip;
    }

    public void setClientZip(String clientZip) {
        this.clientZip = clientZip;
    }

    public String getSegmentName() {
        return segmentName;
    }

    public void setSegmentName(String segmentName) {
        this.segmentName = segmentName;
    }

    public String getTimezoneName() {
        return timezoneName;
    }

    public void setTimezoneName(String timezoneName) {
        this.timezoneName = timezoneName;
    }

    public String getOemName() {
        return oemName;
    }

    public void setOemName(String oemName) {
        this.oemName = oemName;
    }

    public String getOemProgramId() {
        return oemProgramId;
    }

    public void setOemProgramId(String oemProgramId) {
        this.oemProgramId = oemProgramId;
    }

    public String getOemProgramName() {
        return oemProgramName;
    }

    public void setOemProgramName(String oemProgramName) {
        this.oemProgramName = oemProgramName;
    }

    public String getOemRegionId() {
        return oemRegionId;
    }

    public void setOemRegionId(String oemRegionId) {
        this.oemRegionId = oemRegionId;
    }

    public String getOemRegionName() {
        return oemRegionName;
    }

    public void setOemRegionName(String oemRegionName) {
        this.oemRegionName = oemRegionName;
    }
    

    public String getActiveClientsProductName() {
        return activeClientsProductName;
    }

    public void setActiveClientsProductName(String activeClientsProductName) {
        this.activeClientsProductName = activeClientsProductName;
    }

    public String getDigitalAdvisor() {
        return digitalAdvisor;
    }

    public void setDigitalAdvisor(String digitalAdvisor) {
        this.digitalAdvisor = digitalAdvisor;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCampaignLaunchDate() {
        return campaignLaunchDate;
    }

    public void setCampaignLaunchDate(Date campaignLaunchDate) {
        this.campaignLaunchDate = campaignLaunchDate;
    }

    public Date getFirstContractTime() {
        return firstContractTime;
    }

    public void setFirstContractTime(Date firstContractTime) {
        this.firstContractTime = firstContractTime;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.visumbu.wa.model.Client[ id=" + id + " ]";
    }

    public String getClientGroup() {
        return clientGroup;
    }

    public void setClientGroup(String clientGroup) {
        this.clientGroup = clientGroup;
    }

    public String getOem() {
        return oem;
    }

    public void setOem(String oem) {
        this.oem = oem;
    }

    public String getAccountmanagerEmail() {
        return accountmanagerEmail;
    }

    public void setAccountmanagerEmail(String accountmanagerEmail) {
        this.accountmanagerEmail = accountmanagerEmail;
    }

    public String getAccountmanagerName() {
        return accountmanagerName;
    }

    public void setAccountmanagerName(String accountmanagerName) {
        this.accountmanagerName = accountmanagerName;
    }

    public String getAccountmanagerTitle() {
        return accountmanagerTitle;
    }

    public void setAccountmanagerTitle(String accountmanagerTitle) {
        this.accountmanagerTitle = accountmanagerTitle;
    }

    public Date getClientCreateDate() {
        return clientCreateDate;
    }

    public void setClientCreateDate(Date clientCreateDate) {
        this.clientCreateDate = clientCreateDate;
    }

}
