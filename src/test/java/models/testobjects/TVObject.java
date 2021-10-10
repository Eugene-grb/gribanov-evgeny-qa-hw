package models.testobjects;

import lombok.Data;
import models.valueobjects.*;

import java.io.Serializable;

@Data
public class TVObject implements Serializable {
  private Company company;
  private RefreshRate refreshRate;

  public TVObject() {}

  public TVObject(Company company, RefreshRate refreshRate) {
    this.company = company;
    this.refreshRate = refreshRate;
  }

  public TVObject(Company company) {
  }
}

