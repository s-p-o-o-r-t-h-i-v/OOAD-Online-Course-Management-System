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

@Table(name = "submission")
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long assignmentId;
    private Long studentId;
    private String studentName;
    private String content;
    private Integer grade;
    private String feedback;
    private String gradingType;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getAssignmentId() { return assignmentId; }
    public void setAssignmentId(Long assignmentId) { this.assignmentId = assignmentId; }
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Integer getGrade() { return grade; }
    public void setGrade(Integer grade) { this.grade = grade; }
    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }
    public String getGradingType() { return gradingType; }
    public void setGradingType(String gradingType) { this.gradingType = gradingType; }
}