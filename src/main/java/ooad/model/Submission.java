package ooad.model;

import jakarta.persistence.*;

@Entity
public class Submission {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

private String studentName;

private String assignmentFile;

public Long getId(){return id;}

public String getStudentName(){return studentName;}
public void setStudentName(String studentName){this.studentName=studentName;}

public String getAssignmentFile(){return assignmentFile;}
public void setAssignmentFile(String assignmentFile){this.assignmentFile=assignmentFile;}

}