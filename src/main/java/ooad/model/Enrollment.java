package ooad.model;

import jakarta.persistence.*;

@Entity
public class Enrollment {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

private String studentName;

private String courseName;

public Long getId(){return id;}

public String getStudentName(){return studentName;}
public void setStudentName(String studentName){this.studentName=studentName;}

public String getCourseName(){return courseName;}
public void setCourseName(String courseName){this.courseName=courseName;}

}