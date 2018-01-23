package Registrar;

public class Course 
{
   String courseName;
   int registrationCode;
   int maximumNumStudents;
   String faculty;
   
   public Course(String name, int code, int maxNumStd, String instructor) {
      courseName = name;
      registrationCode = code;
      maximumNumStudents = maxNumStd;
      faculty = instructor;
   }
   
   public String returnCourseName() {
      return courseName;
   }
   
   public int returnRegistrationCode() {
      return registrationCode;
   }
   
   public int returnMaximumNumStudents() {
      return maximumNumStudents;
   }
   
   public String retrieveInstructor() {
      return faculty;
   }
   
//   Student[] studentArray = new Student[3];
//   
//   
//      
//      
//   //public void studentSearch() {
//     //}
//
//   
//   public void addStudent() {
//      for (int t = 0; t<studentArray.length; t++) {
//          if (studentArray[t] == null) {
//             studentArray[t] = new Student("Eddie",333,38,17.5,38/17.5); 
//             System.out.println("Student added: " + studentArray[t].studentName);  
//             System.out.println(studentArray[t].studentName +"'s credits: " + studentArray[t].numberOfCredits);  
//             System.out.println(studentArray[t].studentName +"'s grade points: " + studentArray[t].totalGradePoints);
//             System.out.println(studentArray[t].studentName +"'s GPA: " + studentArray[t].gradePointAverage);
//          }
//          else if (t+1 == studentArray.length && studentArray[t] != null) {
//             System.out.println("Course is full. Student not added");
//          }       
//       }
//    }

   
   //public removeStudent(); */
}