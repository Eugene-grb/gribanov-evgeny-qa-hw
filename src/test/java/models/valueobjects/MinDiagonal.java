package models.valueobjects;

import java.io.Serializable;

public class MinDiagonal implements Serializable {

    private String diagonal;

    public MinDiagonal() {}

    public MinDiagonal(String diagonal) {
        if (!diagonal.isBlank() || diagonal.isEmpty()) {
            this.diagonal = diagonal;
        } else {
            throw new IllegalArgumentException("Неверное значение диагонали");
        }
    }

    public String getDiagonal() {
        return String.valueOf(this.diagonal);
    }

    public boolean equals(MinDiagonal otherDiagonal) {
        return this.diagonal.equals(otherDiagonal.getDiagonal());
    }
}
