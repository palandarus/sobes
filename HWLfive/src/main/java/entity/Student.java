package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }


}
