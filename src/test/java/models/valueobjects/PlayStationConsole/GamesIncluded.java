package models.valueobjects.PlayStationConsole;

import java.io.Serializable;

public class GamesIncluded implements Serializable {

    private String gamesIncluded;

    public GamesIncluded() {}

    public GamesIncluded(String gamesIncluded) {
        if (!gamesIncluded.isBlank() || gamesIncluded.isEmpty()) {
            this.gamesIncluded = gamesIncluded;
        } else {
            throw new IllegalArgumentException("Наименование бандла игр не может быть пустым");
        }
    }

    public String GamesIncluded() {
        return this.gamesIncluded;
    }

    public boolean equals(GamesIncluded otherGameIncluded) {
        return this.gamesIncluded.equals(otherGameIncluded.gamesIncluded);
    }
}
