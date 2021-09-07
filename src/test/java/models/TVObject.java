package models;

import models.valueObjects.Company;
import models.valueObjects.Diagonal;
import models.valueObjects.Illumination;
import models.valueObjects.RefreshRate;

public class TVObject {

    private Company company;
    private Diagonal diagonal;
    private Illumination illumination;
    private RefreshRate refreshRate;

    public TVObject() {}

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Diagonal getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Diagonal diagonal) {
        this.diagonal = diagonal;
    }

    public Illumination getIllumination() {
        return illumination;
    }

    public void setIllumination(Illumination illumination) {
        this.illumination = illumination;
    }

    public RefreshRate getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(RefreshRate refreshRate) {
        this.refreshRate = refreshRate;
    }
}
