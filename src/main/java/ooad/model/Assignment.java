package ooad.model;

import jakarta.persistence.*;

@Entity
public class Assignment {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String studentName;
private String fileName;

public Long getId() {
return id;
}

public String getStudentName() {
return studentName;
}

public void setStudentName(String studentName) {
this.studentName = studentName;
}

public String getFileName() {
return fileName;
}

public void setFileName(String fileName) {
this.fileName = fileName;
}

}