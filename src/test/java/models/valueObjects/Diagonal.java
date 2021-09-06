package models.valueObjects;

public class Diagonal {

    private int diagonal;

    public Diagonal() {}

    public Diagonal(int inches) {
        if (inches > 0 ) {
            this.diagonal = inches;
        } else {
            throw new IllegalArgumentException("Значение диагонали не может быть меньше нуля");
        }
    }

    public int getDiagonal() {
        return this.diagonal;
    }

    public boolean equals(Diagonal otherDiagonal) {
        return this.diagonal == otherDiagonal.diagonal;
    }
}
