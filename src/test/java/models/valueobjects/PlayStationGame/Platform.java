package models.valueobjects.PlayStationGame;

import java.io.Serializable;

public class Platform implements Serializable {

    private String platform;

    public Platform() {}

    public Platform(String platform) {
        if (!platform.isBlank() || platform.isEmpty()) {
            this.platform = platform;
        } else {
            throw new IllegalArgumentException("Наименование платформы не может быть пустым");
        }
    }

    public String Platform() {
        return this.platform;
    }

    public boolean equals(Platform otherPlatform) {
        return this.platform.equals(otherPlatform.platform);
    }
}
