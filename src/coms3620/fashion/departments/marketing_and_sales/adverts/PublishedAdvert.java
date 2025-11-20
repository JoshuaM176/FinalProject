package coms3620.fashion.departments.marketing_and_sales.adverts;

import java.time.LocalDate;
import java.util.UUID;

import coms3620.fashion.menus.marketing_and_sales.Approvable;

public class PublishedAdvert implements Approvable{
    
    private String name;
    private String advertCompany;
    private String type;
    private int quarterlyCost;
    private UUID id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String approvalStatus = "pending";

    public PublishedAdvert(String name, String type, int quarterlyCost, UUID id, int duration, String companyName) {
        this.name = name;
        this.type = type;
        this.quarterlyCost = quarterlyCost;
        this.id = id;
        this.startDate = LocalDate.now();
        this.endDate = LocalDate.now().plusDays(duration);
        this.advertCompany = companyName;
    }

    public PublishedAdvert(Object[] object) {
        type = (String)object[0];
        name = (String)object[1];
        quarterlyCost = (int)object[2];
        id = (UUID)object[3];
        startDate = (LocalDate)object[4];
        endDate = (LocalDate)object[5];
        approvalStatus = (String)object[6];
        advertCompany = (String)object[7];
    };

    public Object[] getRowData() {
        return new Object[]{"ssiuddss", type, name, quarterlyCost, id, startDate, endDate, approvalStatus, advertCompany};
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getApprovalStatus() {
        return approvalStatus;
    }

    @Override
    public void setApprovalStatus(String status) {
        approvalStatus = status;
    };

}
