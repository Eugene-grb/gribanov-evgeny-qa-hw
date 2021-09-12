package models.valueObjects;

public class MaxDiagonal {

    private int diagonal;

    public MaxDiagonal() {}

    public MaxDiagonal(int inches) {
        if (inches >= 22 && inches <= 100 ) {
            diagonal = inches;
        } else {
            throw new IllegalArgumentException("Значение диагонали выходит за диапазон [22-88]");
        }
    }

    public String getDiagonal() {
        return String.valueOf(this.diagonal);
    }

    public boolean equals(MaxDiagonal otherMaxDiagonal) {
        return this.diagonal == otherMaxDiagonal.diagonal;
    }
}
