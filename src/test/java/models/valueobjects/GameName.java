package models.valueobjects;

import java.io.Serializable;

public class GameName {
    public static class Illumination implements Serializable {

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

    public static class MaxDiagonal implements Serializable {

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

    public static class MinDiagonal implements Serializable {

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

    public static class RefreshRate implements Serializable {

        private String refreshRate;

        public RefreshRate() {}

        public RefreshRate(String refreshRate) {
            if (!refreshRate.isBlank() || refreshRate.isEmpty()) {
                this.refreshRate = refreshRate;
            } else {
                throw new IllegalArgumentException("Неверное значение частоты обновления дисплея");
            }
        }

        public String getRefreshRate() {
            return String.valueOf(this.refreshRate);
        }

        public boolean equals(RefreshRate otherFrequency) {
            return this.refreshRate.equals(otherFrequency.getRefreshRate());
        }
    }
}
