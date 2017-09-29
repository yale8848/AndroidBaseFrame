package ren.yale.android.androidbaseframe.data.db.entity;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by yale on 2017/9/29.
 */
@Entity
public class StudentEntity {

    @Id
    private long id;
    private String name;
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
