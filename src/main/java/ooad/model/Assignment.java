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

import java.time.LocalDate;

@Entity
@Table(name = "assignment")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Long courseId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }
}