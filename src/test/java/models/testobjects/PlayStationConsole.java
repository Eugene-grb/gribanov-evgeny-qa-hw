package models.testobjects;

import lombok.Builder;
import lombok.Data;
import models.valueobjects.PlayStationConsole.GamesIncluded;
import models.valueobjects.PlayStationConsole.Model;

import java.io.Serializable;

@Builder
@Data
public class PlayStationConsole implements Serializable {
    private GamesIncluded gamesIncluded;
    private Model model;
}
