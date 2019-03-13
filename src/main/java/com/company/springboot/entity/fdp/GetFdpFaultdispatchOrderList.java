package com.company.springboot.entity.fdp;

import com.company.springboot.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class GetFdpFaultdispatchOrderList extends BaseEntity {
    private int companyId;
    private String dispatchStatus;
    private Integer lastDealPersonId;

    private String lastDealPerson;
    private String createPerson;
    private Date createTimeStart;
    private Date createTimeEnd;
    private Date userCompleteTimeStart;
    private Date userCompleteTimeEnd;
    private BigDecimal actualCostStart;
    private BigDecimal actualCostEnd;
    private BigDecimal estimatedCostStart;
    private BigDecimal estimatedCostEnd;
    private BigDecimal actualPriceStart;
    private BigDecimal actualPriceEnd;
    private BigDecimal estimatedPriceStart;
    private BigDecimal estimatedPriceEnd;
    private String province;
    private Integer vendorId;
    private Integer type;
    private String city;

    private String companyName;

    private Date expectReplyTime;

    //当前公司id
    private Integer userCompanyId;

    private String customerSource;

    private Date expectCompleteTime;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getDispatchStatus() {
        return dispatchStatus;
    }

    public void setDispatchStatus(String dispatchStatus) {
        this.dispatchStatus = dispatchStatus;
    }

    public Integer getLastDealPersonId() {
        return lastDealPersonId;
    }

    public void setLastDealPersonId(Integer lastDealPersonId) {
        this.lastDealPersonId = lastDealPersonId;
    }

    public Date getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public Date getUserCompleteTimeStart() {
        return userCompleteTimeStart;
    }

    public void setUserCompleteTimeStart(Date userCompleteTimeStart) {
        this.userCompleteTimeStart = userCompleteTimeStart;
    }

    public Date getUserCompleteTimeEnd() {
        return userCompleteTimeEnd;
    }

    public void setUserCompleteTimeEnd(Date userCompleteTimeEnd) {
        this.userCompleteTimeEnd = userCompleteTimeEnd;
    }

    public BigDecimal getActualCostStart() {
        return actualCostStart;
    }

    public void setActualCostStart(BigDecimal actualCostStart) {
        this.actualCostStart = actualCostStart;
    }

    public BigDecimal getActualCostEnd() {
        return actualCostEnd;
    }

    public void setActualCostEnd(BigDecimal actualCostEnd) {
        this.actualCostEnd = actualCostEnd;
    }

    public BigDecimal getEstimatedCostStart() {
        return estimatedCostStart;
    }

    public void setEstimatedCostStart(BigDecimal estimatedCostStart) {
        this.estimatedCostStart = estimatedCostStart;
    }

    public BigDecimal getEstimatedCostEnd() {
        return estimatedCostEnd;
    }

    public void setEstimatedCostEnd(BigDecimal estimatedCostEnd) {
        this.estimatedCostEnd = estimatedCostEnd;
    }

    public BigDecimal getActualPriceStart() {
        return actualPriceStart;
    }

    public void setActualPriceStart(BigDecimal actualPriceStart) {
        this.actualPriceStart = actualPriceStart;
    }

    public BigDecimal getActualPriceEnd() {
        return actualPriceEnd;
    }

    public void setActualPriceEnd(BigDecimal actualPriceEnd) {
        this.actualPriceEnd = actualPriceEnd;
    }

    public BigDecimal getEstimatedPriceStart() {
        return estimatedPriceStart;
    }

    public void setEstimatedPriceStart(BigDecimal estimatedPriceStart) {
        this.estimatedPriceStart = estimatedPriceStart;
    }

    public BigDecimal getEstimatedPriceEnd() {
        return estimatedPriceEnd;
    }

    public void setEstimatedPriceEnd(BigDecimal estimatedPriceEnd) {
        this.estimatedPriceEnd = estimatedPriceEnd;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getUserCompanyId() {
        return userCompanyId;
    }

    public void setUserCompanyId(Integer userCompanyId) {
        this.userCompanyId = userCompanyId;
    }

    public String getCustomerSource() {
        return customerSource;
    }

    public void setCustomerSource(String customerSource) {
        this.customerSource = customerSource;
    }

    public String getLastDealPerson() {
        return lastDealPerson;
    }

    public void setLastDealPerson(String lastDealPerson) {
        this.lastDealPerson = lastDealPerson;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public Date getExpectCompleteTime() {
        return expectCompleteTime;
    }

    public void setExpectCompleteTime(Date expectCompleteTime) {
        this.expectCompleteTime = expectCompleteTime;
    }

    public Date getExpectReplyTime() {
        return expectReplyTime;
    }

    public void setExpectReplyTime(Date expectReplyTime) {
        this.expectReplyTime = expectReplyTime;
    }

    @Override
    public String toString() {
        return "GetFdpFaultdispatchOrderList{" +
                "companyId=" + companyId +
                ", dispatchStatus='" + dispatchStatus + '\'' +
                ", lastDealPersonId=" + lastDealPersonId +
                ", lastDealPerson='" + lastDealPerson + '\'' +
                ", createPerson='" + createPerson + '\'' +
                ", createTimeStart=" + createTimeStart +
                ", createTimeEnd=" + createTimeEnd +
                ", userCompleteTimeStart=" + userCompleteTimeStart +
                ", userCompleteTimeEnd=" + userCompleteTimeEnd +
                ", actualCostStart=" + actualCostStart +
                ", actualCostEnd=" + actualCostEnd +
                ", estimatedCostStart=" + estimatedCostStart +
                ", estimatedCostEnd=" + estimatedCostEnd +
                ", actualPriceStart=" + actualPriceStart +
                ", actualPriceEnd=" + actualPriceEnd +
                ", estimatedPriceStart=" + estimatedPriceStart +
                ", estimatedPriceEnd=" + estimatedPriceEnd +
                ", province='" + province + '\'' +
                ", vendorId=" + vendorId +
                ", type=" + type +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", expectReplyTime=" + expectReplyTime +
                ", userCompanyId=" + userCompanyId +
                ", customerSource='" + customerSource + '\'' +
                ", expectCompleteTime=" + expectCompleteTime +
                '}';
    }
}