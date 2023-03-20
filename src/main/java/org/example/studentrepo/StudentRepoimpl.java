package org.example.studentrepo;
import org.example.model.Student;

import java.util.List;

public interface StudentRepoimpl {
    void insertstudent(Student student);
    Student selectstudent( int id);
    List<Student> selectallstudent();
    Student updatestudent(Student student);
    Boolean deletestudent(int id);
    Boolean deleteallstudent();
}
