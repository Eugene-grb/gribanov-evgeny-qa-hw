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

    public int getRefreshRate() {
        return this.refreshRate;
    }

    public boolean equals(RefreshRate otherRefreshRate) {
        return this.refreshRate == otherRefreshRate.getRefreshRate();
    }
}
