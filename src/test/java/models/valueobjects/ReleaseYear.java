package models.valueobjects;

import java.io.Serializable;

public class ReleaseYear implements Serializable {

    private String releaseYear;

    public ReleaseYear() {}

    public ReleaseYear(String releaseYear) {
        if (!releaseYear.isBlank() || releaseYear.isEmpty()) {
            this.releaseYear = releaseYear;
        } else {
            throw new IllegalArgumentException("Наименование года релиза не может быть пустым");
        }
    }

    public String ReleaseYear() {
        return this.releaseYear;
    }

    public boolean equals(ReleaseYear otherReleaseYear) {
        return this.releaseYear.equals(otherReleaseYear.releaseYear);
    }
}
