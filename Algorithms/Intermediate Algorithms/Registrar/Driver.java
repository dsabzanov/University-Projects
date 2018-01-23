package Registrar;

public class Driver {

   public static void main(String[] args) {
     
     
      Student[] studentArray = new Student[3]; // STUDENT ARRAY
      
      
      // ---- STUDENT ------
      
      //Student_1 Object
      /*Student Student_1 = new Student("John",1111,48,15.5,48/15.5); 
      System.out.println("Student name: " + Student_1.studentName);  
      System.out.println(Student_1.studentName +"'s credits: " + Student_1.numberOfCredits);  
      System.out.println(Student_1.studentName +"'s grade points: " + Student_1.totalGradePoints);
      System.out.println(Student_1.studentName +"'s GPA: " + Student_1.gradePointAverage);
      */
      
      // First student initialized and printed from the student object
      Student student1 = new Student("John",1111);
      student1.setCredits(48);
      student1.setGradePoints(155.5);
      System.out.println("Student name: " + student1.getStudentName());  
      System.out.println(student1.getStudentName() +"'s credits: " + student1.returnCredits());  
      System.out.println(student1.getStudentName() +"'s grade points: " + student1.returnGradePoints());
      System.out.println(student1.getStudentName() +"'s GPA: " + student1.returnGPA());
      
      System.out.println(); // New line 
      
      
      //Student_2 Object
      // Second student initialized and printed from the student object
      Student student2 = new Student("Henry",1112);
      student2.setCredits(56);
      student2.setGradePoints(188.25);
      System.out.println("Second student name: " + student2.getStudentName());  
      System.out.println(student2.getStudentName() +"'s credits: " + student2.returnCredits());  
      System.out.println(student2.getStudentName() +"'s grade points: " + student2.returnGradePoints());
      System.out.println(student2.getStudentName() +"'s GPA: " + student2.returnGPA());
      
      System.out.println(); // New line 
     
     
      student1.ifEquals(student1, student2);  //Student Objects ifEquals method call
     
      // ---- END STUDENT ----
     
    
      System.out.println(); // New line 
      
      
      // ---- INSTRUCTOR ------      
      Instructor Instructor1 = new Instructor("Bob",2222);   
      Instructor1.setInstructorDept("COMP 182");     
      System.out.println("Instructor name: " + Instructor1.returnInstructorName());       
      System.out.println(Instructor1.returnInstructorName() + "'s department: " + Instructor1.returnInstructorDept());         
      // -- END INSTRUCTOR --     
     
     
     
     
     
     
            
       // ------ END COURSE ------                     
   }
}