package org.example.studentservice;
import org.example.model.Student;
import org.example.studentrepo.StudentRepoimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements StudentServiceimpl{
    @Autowired
    private StudentRepoimpl repo;
    @Override
    public void insertstudent(Student student){
        repo.insertstudent(student);
    }
    @Override
    public void insertmulstudent(List<Student> student){
        for(int i = 0 ; i < student.size();i++){
            repo.insertstudent(student.get(i));
        }
    }
    @Override
    public Student selectstudent(int id){
        return repo.selectstudent(id);
    }
    @Override
    public List<Student> selectmulstudent(List<Integer> ids){
        List<Student> studentList = new ArrayList<>();
        for (int i = 0;i<ids.size();i++){
            Student s1 =  repo.selectstudent(ids.get(i));
            studentList.add(s1);
        }
        return studentList;
    }
    @Override
    public List<Student> selectallstudent(){
      return repo.selectallstudent();
    }
    @Override
    public Student updatestudent(Student student){
        return repo.updatestudent(student);
    }
    @Override
    public List<Student> updatemulstudent(List<Student> student){
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i<student.size();i++){
            Student s1 = updatestudent(student.get(i));
            studentList.add(s1);
        }
     return studentList;
    }
    @Override
    public Boolean deletestudent(int id){
        return repo.deletestudent(id);
    }
    @Override
    public List<Boolean> deletemulstudent(List<Integer> ids){
        List<Boolean> b2 = new ArrayList<>();
        for (int i= 0;i<ids.size();i++){
            Boolean b1 = deletestudent(ids.get(i));
            b2.add(b1);
        }
        return b2;
    }
    @Override
    public Boolean deleteallstudent(){
        return repo.deleteallstudent();
    }
}
