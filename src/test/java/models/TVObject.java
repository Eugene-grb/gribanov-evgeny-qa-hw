package models;

import lombok.Data;
import models.valueobjects.*;

import java.io.Serializable;

@Data
public class TVObject implements Serializable {

  private Company company;
  private MaxDiagonal maxDiagonal;
  private MinDiagonal minDiagonal;
  private Illumination illumination;
  private RefreshRate refreshRate;
}
