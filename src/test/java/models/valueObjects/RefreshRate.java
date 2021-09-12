package models.valueObjects;

public class RefreshRate {

    private int refreshRate;

    public RefreshRate() {}

    public RefreshRate(int refreshRate) {
        if (refreshRate > 0 ) {
            this.refreshRate = refreshRate;
        } else {
            throw new IllegalArgumentException("Значение частоты обновления дисплея не может быть меньше нуля");
        }
    }

    public String getRefreshRate() {
        return String.valueOf(this.refreshRate);
    }

    public boolean equals(RefreshRate otherFrequency) {
        return this.refreshRate == otherFrequency.refreshRate;
    }
}
