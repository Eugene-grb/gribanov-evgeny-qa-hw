package models.valueobjects.PlayStationGame;

import java.io.Serializable;

public class Package implements Serializable {

    private String gamePackage;

    public Package() {}

    public Package(String gamePackage) {
        if (!gamePackage.isBlank() || gamePackage.isEmpty()) {
            this.gamePackage = gamePackage;
        } else {
            throw new IllegalArgumentException("Наименование типа упаковки не может быть пустым");
        }
    }

    public String GameType() {
        return this.gamePackage;
    }

    public boolean equals(Package otherGamePackage) {
        return this.gamePackage.equals(otherGamePackage.gamePackage);
    }
}
