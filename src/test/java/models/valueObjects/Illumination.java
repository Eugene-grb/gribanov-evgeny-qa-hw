package models.valueObjects;

public class Illumination {

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
