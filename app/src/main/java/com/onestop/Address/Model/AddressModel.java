package com.onestop.Address.Model;

public class AddressModel {

    private String addressOwnerName, addressPhone, addressType, addressHouseNo, addressBuildingName, addressStreetName, addressPinCode, addressCity, addressState;

    public AddressModel() {
    }

    public AddressModel(String addressOwnerName, String addressPhone, String addressType, String addressHouseNo, String addressBuildingName, String addressStreetName, String addressPinCode, String addressCity, String addressState) {
        this.addressOwnerName = addressOwnerName;
        this.addressPhone = addressPhone;
        this.addressType = addressType;
        this.addressHouseNo = addressHouseNo;
        this.addressBuildingName = addressBuildingName;
        this.addressStreetName = addressStreetName;
        this.addressPinCode = addressPinCode;
        this.addressCity = addressCity;
        this.addressState = addressState;
    }

    public String getAddressOwnerName() {
        return addressOwnerName;
    }

    public void setAddressOwnerName(String addressOwnerName) {
        this.addressOwnerName = addressOwnerName;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    public String getAddressPinCode() {
        return addressPinCode;
    }

    public void setAddressPinCode(String addressPinCode) {
        this.addressPinCode = addressPinCode;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddressBuildingName() {
        return addressBuildingName;
    }

    public void setAddressBuildingName(String addressBuildingName) {
        this.addressBuildingName = addressBuildingName;
    }

    public String getAddressHouseNo() {
        return addressHouseNo;
    }

    public void setAddressHouseNo(String addressHouseNo) {
        this.addressHouseNo = addressHouseNo;
    }

    public String getAddressStreetName() {
        return addressStreetName;
    }

    public void setAddressStreetName(String addressStreetName) {
        this.addressStreetName = addressStreetName;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }
}
