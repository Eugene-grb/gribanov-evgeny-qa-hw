package models.valueobjects.PlayStationConsole;

import java.io.Serializable;

public class Model implements Serializable {

    private String model;

    public Model() {}

    public Model(String model) {
        if (!model.isBlank() || model.isEmpty()) {
            this.model = model;
        } else {
            throw new IllegalArgumentException("Наименование модели не может быть пустым");
        }
    }

    public String Model() {
        return this.model;
    }

    public boolean equals(Model otherModel) {
        return this.model.equals(otherModel.model);
    }
}
