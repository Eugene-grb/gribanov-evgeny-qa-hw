package models.valueobjects;

import java.io.Serializable;

public class RefreshRate implements Serializable {

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
