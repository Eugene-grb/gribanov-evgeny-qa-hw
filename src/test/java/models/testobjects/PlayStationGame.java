package models.testobjects;

import lombok.Builder;
import lombok.Data;
import models.valueobjects.PlayStationGame.Platform;
import models.valueobjects.PlayStationGame.ReleaseYear;

import java.io.Serializable;

@Builder
@Data
public class PlayStationGame implements Serializable {
    private Package gamePackage;
    private Platform platform;
    private ReleaseYear releaseYear;
}
