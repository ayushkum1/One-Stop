package com.onestop.Address.Sample;

import com.onestop.Address.Model.AddressModel;

import java.util.ArrayList;
import java.util.List;

public class AddressSampleData {

    private List<AddressModel> addressList = new ArrayList<>();

    private AddressModel addressModel = new AddressModel("Ayush", "8217804700", "Home", "#108", "Surya Vijaya Vihar", "Ganesh Layout", "560097", "Bengaluru", "Karnataka");
    private AddressModel addressModel1 = new AddressModel("Ayush", "8217804700", "Home", "#108", "Surya Vijaya Vihar", "Ganesh Layout", "560097", "Bengaluru", "Karnataka");

    public List<AddressModel> getAddressList() {
        addressList.add(addressModel);
        addressList.add(addressModel1);
        return addressList;
    }
}
