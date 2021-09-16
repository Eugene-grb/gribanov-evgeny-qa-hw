package models.valueObjects;

import java.io.Serializable;

public class Illumination implements Serializable {

    private String illuminationType;

    public Illumination() {}

    public Illumination(String illuminationType) {
        if (!illuminationType.isBlank() || illuminationType.isEmpty()) {
            this.illuminationType = illuminationType;
        } else {
            throw new IllegalArgumentException("Тип подсветки не может быть пустым");
        }
    }

    public String getIlluminationType() {
        return this.illuminationType;
    }

    public boolean equals(Illumination otherIlluminationType) {
        return this.illuminationType.equals(otherIlluminationType.getIlluminationType());
    }
}
