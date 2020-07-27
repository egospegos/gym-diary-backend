package gymdiary.model.entity;

import java.io.Serializable;

public class Exercise implements Serializable {
    private int id;
    private String name;
    private String muscles;
    private String description;
    private String imageBase64;

    public Exercise(int id, String name, String muscles, String description, String imageBase64) {
        this.id = id;
        this.name = name;
        this.muscles = muscles;
        this.description = description;
        this.imageBase64 = imageBase64;
    }

    public String getName() {
        return name;
    }

    public String getMuscles() {
        return muscles;
    }

    public String getDescription() {
        return description;
    }

    public int getId() { return id;}

    public String getImageBase64() {
        return imageBase64;
    }
}
