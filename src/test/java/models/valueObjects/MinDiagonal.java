package models.valueObjects;

public class MinDiagonal {

    private int diagonal;

    public MinDiagonal() {}

    public MinDiagonal(int inches) {
        if (inches >= 22 && inches <= 100 ) {
            diagonal = inches;
        } else {
            throw new IllegalArgumentException("Значение диагонали выходит за диапазон [22-88]");
        }
    }

    public String getDiagonal() {
        return String.valueOf(this.diagonal);
    }

    public boolean equals(MinDiagonal otherMinDiagonal) {
        return this.diagonal == otherMinDiagonal.diagonal;
    }
}
