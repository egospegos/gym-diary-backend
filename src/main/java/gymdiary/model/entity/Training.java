package gymdiary.model.entity;

import java.util.Date;

public class Training {
    private int id;
    private int user_id;
    private Date date;

    public Training(int id, int user_id, Date date) {
        this.id = id;
        this.user_id = user_id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public Date getDate() {
        return date;
    }
}
