package com.myapplicationdev.android.carparkavailabilityp13ps;

public class Carpark {

    private String carparkNo;
    private String lotType;
    private String lotAvailable;
    private String updateDateTime;
    private String totalLots;

    public Carpark(String carparkNo, String lotType, String lotAvailable, String updateDateTime, String totalLots) {
        this.carparkNo = carparkNo;
        this.lotType = lotType;
        this.lotAvailable = lotAvailable;
        this.updateDateTime = updateDateTime;
        this.totalLots = totalLots;
    }

    public String getCarparkNo() {
        return carparkNo;
    }

    public void setCarparkNo(String carparkNo) {
        this.carparkNo = carparkNo;
    }

    public String getLotType() {
        return lotType;
    }

    public void setLotType(String lotType) {
        this.lotType = lotType;
    }

    public String getLotAvailable() {
        return lotAvailable;
    }

    public void setLotAvailable(String lotAvailable) {
        this.lotAvailable = lotAvailable;
    }

    public String getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(String updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getTotalLots() {
        return totalLots;
    }

    public void setTotalLots(String totalLots) {
        this.totalLots = totalLots;
    }

    @Override
    public String toString() {
        return "CARPARK AVAILABILITY" + '\n' +
                "carparkNo: " + carparkNo + '\n' +
                "lotType: " + lotType + '\n' +
                "lotAvailable: " + lotAvailable + '\n' +
                "totalLots: " + totalLots + '\n' +
                "updateDateTime: " + updateDateTime;
    }
}
