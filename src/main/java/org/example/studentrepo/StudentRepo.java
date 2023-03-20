package org.example.studentrepo;
import org.example.model.Student;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo implements StudentRepoimpl {
    String url = "jdbc:mysql://localhost:3306/teststudent";
    String user = "root";
    String pass = "";

    @Override
    public void insertstudent(Student student) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            st.executeUpdate("insert into student values( '" +
                    student.getId() + "', '" +
                    student.getName() + "' ,'" +
                    student.getEmail() + "' )");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public Student selectstudent( int id){
        Student student = new Student();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student where id = '"+id+"'");
            while (rs.next()){
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return student;
    }
    public List<Student> selectallstudent(){
       List<Student> studentList = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student");
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
                studentList.add(student);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return studentList;
    }
    @Override
    public Student updatestudent(Student student){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            st.executeUpdate("update  student set name='"+
                    student.getName()+"',email='"+
                    student.getEmail()+"' where id = '"+student.getId()+"'");
        }catch (Exception e){
            System.out.println(e);
        }
        selectstudent(student.getId());
        return student;
    }
    @Override
    public Boolean deletestudent(int id){
        Boolean result = false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete  from student where id = '"+id+"' ");
            if(count != 0){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
    @Override
    public Boolean deleteallstudent(){
        Boolean result = false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete  from student");
            if(count != 0){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
}
