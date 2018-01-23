package Registrar;

public class Instructor
{
   private String _instructorName;
   private int _facultyID;
   private String _instructorDept;
   
   public Instructor(String name, int ID) {
      _instructorName = name;
      _facultyID = ID;
   }
   
   public void setInstructorName(String name) {
      _instructorName = name;
   }
   
   
   public String returnInstructorName() {
		return _instructorName;    
   }
   
   
   public void setInstructorDept(String dept) {
      _instructorDept = dept;
   }
   
   
   public String returnInstructorDept() {
		return _instructorDept;    
   }
   
}