package models;

import models.valueObjects.*;

public class TVObject {

  private Company company;
  private MaxDiagonal maxDiagonal;
  private MinDiagonal minDiagonal;
  private Illumination illumination;
  private RefreshRate refreshRate;

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public MaxDiagonal getMaxDiagonal() {
    return maxDiagonal;
  }

  public void setMaxDiagonal(MaxDiagonal maxDiagonal) {
    this.maxDiagonal = maxDiagonal;
  }

  public MinDiagonal getMinDiagonal() {
    return minDiagonal;
  }

  public void setMinDiagonal(MinDiagonal minDiagonal) {
    this.minDiagonal = minDiagonal;
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
