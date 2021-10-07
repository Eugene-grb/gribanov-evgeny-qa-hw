package models.valueobjects;

import java.io.Serializable;

public class MaxDiagonal implements Serializable {

    private String diagonal;

    public MaxDiagonal() {}

    public MaxDiagonal(String diagonal) {
        if (!diagonal.isBlank() || diagonal.isEmpty()) {
            this.diagonal = diagonal;
        } else {
            throw new IllegalArgumentException("Неверное значение диагонали");
        }
    }

    public String getDiagonal() {
        return String.valueOf(this.diagonal);
    }

    public boolean equals(MaxDiagonal otherDiagonal) {
        return this.diagonal.equals(otherDiagonal.getDiagonal());
    }
}
