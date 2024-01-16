package org.example.beveragevendingmachine.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Outlet extends BaseModel{

    private Integer outletNumber;
    private OutletStatus outletStatus;

    public Outlet(Integer outletNumber){
        this.outletNumber = outletNumber;
        this.outletStatus = OutletStatus.AVAILABLE;
    }

    public void serveBeverage(Beverage beverage){
        this.setOutletStatus(OutletStatus.RUNNING);
        beverage.prepareBeverage();
        this.setOutletStatus(OutletStatus.AVAILABLE);
    }
}
