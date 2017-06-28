package com.hch.qewqs.firstclassexamforclass;

import java.io.Serializable;

/**
 * Created by qewqs on 2017-06-28.
 */

public class PresentativeCompany_info extends Personal_info  implements Serializable {
    private String CompaneyName;

    public PresentativeCompany_info(String companeyName) {
        super();
        CompaneyName = companeyName;
    }

    public PresentativeCompany_info(String name, int PID, String phone, String companeyName) {
        super(name, PID, phone);
        CompaneyName = companeyName;
    }

    public void setCompaneyName(String companeyName) {
        CompaneyName = companeyName;
    }

    public String getCompaneyName() {
        return CompaneyName;
    }

    @Override
    public String getAllData() {
        return super.getAllData() + "\n" + this.CompaneyName;
    }
}
