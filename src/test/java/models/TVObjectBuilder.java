package models;

import models.valueObjects.Company;
import models.valueObjects.Diagonal;
import models.valueObjects.Illumination;
import models.valueObjects.RefreshRate;

public class TVObjectBuilder {

    private final Company company;
    private final Diagonal diagonal;
    private final Illumination illumination;
    private final RefreshRate refreshRate;

    public TVObjectBuilder(
            Company company,
            Diagonal diagonal,
            Illumination illumination,
            RefreshRate refreshRate
    ) {
        this.company = company;
        this.diagonal = diagonal;
        this.illumination = illumination;
        this.refreshRate = refreshRate;
    }

    public TVObject build() {
        TVObject tvObject = new TVObject();
        tvObject.setCompany(this.company);
        tvObject.setDiagonal(this.diagonal);
        tvObject.setIllumination(this.illumination);
        tvObject.setRefreshRate(this.refreshRate);
        return tvObject;
    }
}
