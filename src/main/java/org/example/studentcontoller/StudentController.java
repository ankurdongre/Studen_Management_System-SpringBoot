package org.example.studentcontoller;
import org.example.model.Student;
import org.example.studentservice.StudentServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentServiceimpl service;

    @RequestMapping("/insertStudent")
    @ResponseBody
    public void insertstudent(@RequestBody Student student){
        service.insertstudent(student);
    }
    @RequestMapping("/insertMulStudent")
    @ResponseBody
    public void insertmulstudent(@RequestBody List<Student> student){
        service.insertmulstudent(student);
    }
    @RequestMapping("/selectStudent")
    @ResponseBody
    public Student selectstudent(@RequestParam int id){
        return service.selectstudent(id);
    }
    @RequestMapping("/selectMulStudent")
    @ResponseBody
    public List<Student> selectmulstudent(@RequestParam List<Integer> ids){
        return service.selectmulstudent(ids);
    }
    @RequestMapping("/selectAllStudent")
    @ResponseBody
    public List<Student> selectallstudent(){
        return service.selectallstudent();
    }

    @RequestMapping("/updateStudent")
    @ResponseBody
    public Student updatestudent(@RequestBody Student student){
        return service.updatestudent(student);
    }

    @RequestMapping("/updateMulStudent")
    @ResponseBody
    public List<Student> updatemulstudent(@RequestBody List<Student> student){
        return service.updatemulstudent(student);
    }
    @RequestMapping("/deleteStudent")
    @ResponseBody
    public Boolean deletestudent(@RequestParam int id){
        return service.deletestudent(id);
    }
    @RequestMapping("/deleteMulStudent")
    @ResponseBody
    public List<Boolean> deletemulstudent(@RequestParam List<Integer> ids){
        return service.deletemulstudent(ids);
    }
    @RequestMapping("/deleteAllStudent")
    @ResponseBody
    public Boolean deleteallstudent(){
        return service.deleteallstudent();
    }
}
