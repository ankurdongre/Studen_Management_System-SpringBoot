package org.example.studentservice;
import org.example.model.Student;


import java.util.List;

public interface StudentServiceimpl {
    void insertstudent(Student student);
    void insertmulstudent(List<Student> student);
    Student selectstudent(int id);
    List<Student> selectmulstudent(List<Integer> ids);
    List<Student> selectallstudent();
    Student updatestudent(Student student);
    List<Student> updatemulstudent(List<Student> student);
    Boolean deletestudent(int id);
    List<Boolean> deletemulstudent(List<Integer> ids);
    Boolean deleteallstudent();
}
