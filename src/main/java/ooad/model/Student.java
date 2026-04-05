package ooad.model;

import jakarta.persistence.*;

@Entity
public class Student {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

private String name;

private String course;

public Long getId(){return id;}

public String getName(){return name;}
public void setName(String name){this.name=name;}

public String getCourse(){return course;}
public void setCourse(String course){this.course=course;}

}