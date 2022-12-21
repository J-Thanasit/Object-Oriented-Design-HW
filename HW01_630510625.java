import java.util.Scanner;

class Student{
    private String name;
    private String major;
    private Courses[] course = new Courses[4];
    private rawGrade[] raw_grade = new raawGrade[5];
    private int i = 0;

    public Student(String name,String major){
        this.name = name;
        this.major = major;
    }
    public void addCourse(ScaleCourse course, double raw_grade){
        Courses.add(course);
        rawGrade.add(raw_grade);
    }
    public void printTranscript(){
        double gpa = 0;
        int totalCredit = 0;
        int totalGpaCredit = 0;
        System.out.println("Name: "+ name);
        System.out.println("Major: "+ major);
    }
}

abstract class Course{
    private String name;
    private int credit;

    public void setCourseName(String name){
        this.name = name;
    }
    public void setCourseCredit(int credit){
        this.credit = credit;
    }
    public String getCourseName(){
        return(name);
    }
    public String getCourseCredit(){
        return(credit);
    }
}

class ScaleCourse extends Course{
    public double[] scales = new double[5];
    
    public ScaleCourse(String name,int credit, double[] scales){
        setCourseName(name);
        setCourseCredit(credit);
        this.scales = scales;
    }
    public String getFinalLetterGrade(double grade){
        String letterGrade = "";
        if(grade >= scales[0])
            letterGrade = "A";
        else if(grade >= scales[1])
            letterGrade = "B";
        else if(grade >= scales[2])
            letterGrade = "C";
        else if(grade >= scales[3])
            letterGrade = "D";
        else if(grade <= scales[4])
            letterGrade = "F";
        return letterGrade;
    }
    public String getType(){
        return "Scale";
    }
}

class SatisfactoryCourse extends Course{
    public double threshold;

    public SatisfactoryCourse(String name,int credit, double threshold){
        this.threshold = threshold;
        setCourseName(name);
        setCourseCredit(credit);
        this.threshold = threshold;
    }
    public String getFinalLetterGrade(double grade){
        String letterGrade;
        if(grade >= threshold)
            letterGrade = "S";
        else
            letterGrade = "U";
        return letterGrade;
    }
    public String getType(){
        return "S/U";
    }
}

public class HW1_630510625{
    public static void main(String[] args){
        String studentName = "Thanasit Suksermsal";
        String studentMajor = "Computer Science";
        Student stu = new Student(studentName, studentMajor);
        double[] scales = {94.0, 82.0, 70.0, 56.0, 0.0};
        stu.addCourse(new ScaleCourse("CS306", 4, scales),55.0);
        stu.addCourse(new SatisfactoryCourse("CS123", 3, 61.25),80);
        stu.addCourse(new ScaleCourse("CS265", 3, scales),72);
        stu.printTranscript();
    }
}
