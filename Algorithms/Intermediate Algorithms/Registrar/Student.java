package Registrar;
import java.util.Scanner;

public class Student
{
   private String _studentName;
   private int _studentID;
   private int _numberOfCredits;
   private double _totalGradePoints;
   private double _gradePointAverage;
	
	public Student(String name,int ID) {
		_studentName = name;
      _studentID = ID;
	}
   
   public String getStudentName() {
		return _studentName;    
   }
   
   public void setStudentName(String newValue) {
      _studentName = newValue;
   }
   
   public int getStudentID() {
		return _studentID;    
   }
   
   public void setStudentID(int newValue) {
      _studentID = newValue;
   }

   public int returnCredits() {
      return _numberOfCredits;
   }
   
   public void setCredits(int newValue) {
      _numberOfCredits = newValue;
   }

   public double returnGradePoints() {
      return _totalGradePoints;
   }
   
   public void setGradePoints(double newValue) {
      _totalGradePoints = newValue;
   }
   
   public double returnGPA() {
      _gradePointAverage = this._totalGradePoints / this._numberOfCredits;
      return _gradePointAverage;
   }
   
   
   public void ifEquals(Student a, Student b) {
      if (a.getStudentID() == b.getStudentID()) {
         System.out.println("These two students have the same ID");
      }
      else {
         System.out.println("These two students do not have the same ID");
      } 
   
   }
   
   
	
}