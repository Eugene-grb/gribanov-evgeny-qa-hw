package models;

import models.valueObjects.*;

import java.io.Serializable;

public class TVObjectBuilder implements Serializable {

  private final Company company;
  private final MaxDiagonal maxDiagonal;
  private final MinDiagonal minDiagonal;
  private final Illumination illumination;
  private final RefreshRate refreshRate;

  public TVObjectBuilder(
          Company company, MaxDiagonal maxDiagonal, Illumination illumination, RefreshRate refreshRate, MinDiagonal minDiagonal) {
    this.company = company;
    this.maxDiagonal = maxDiagonal;
    this.illumination = illumination;
    this.refreshRate = refreshRate;
    this.minDiagonal = minDiagonal;
  }

  public TVObject build() {
    TVObject tvObject = new TVObject();
    tvObject.setCompany(this.company);
    tvObject.setMaxDiagonal(this.maxDiagonal);
    tvObject.setMinDiagonal(this.minDiagonal);
    tvObject.setIllumination(this.illumination);
    tvObject.setRefreshRate(this.refreshRate);
    return tvObject;
  }
}
