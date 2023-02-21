
package DAL;

import BLL.Student;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import untils.MyDataAccess;

public class StudentDAL {
    MyDataAccess my = new MyDataAccess("localhost","root","","school1");
    public StudentDAL(){}
    public ArrayList<Student> docSV() throws Exception{
        ArrayList<Student> list = new ArrayList<Student>();
        try{
                String qry = "select * from person";
                ResultSet rs = my.executeQuery(qry);
                while(rs.next()){
                    Student sv = new Student();
                    sv.setMasv(rs.getString(1));
                    sv.setLastname(rs.getString(2));
                    sv.setFirstname(rs.getString(3));
                    sv.setHireDate(rs.getString(4));
                    sv.setEnrollmentDate(rs.getString(5));
                    list.add(sv);
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi đọc Database");
        }
        finally{
            my.close();
        }
        return list;
    }
    
    public int themSV(Student sv){
        int res = 0;
        try{
                String qry = "insert into person values(";
                qry=qry+"'"+sv.getMasv()+"'";
                qry=qry+",'"+sv.getLastname()+"'";
                qry=qry+",'"+sv.getFirstname()+"'";
                qry=qry+",'"+sv.getHireDate()+"'";
                qry=qry+",'"+sv.getEnrollmentDate()+"')";
                res = my.executeUpdate(qry);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Lỗi thêm Sinh viên vào Database");
            }
        return res;
    }
    public int suaSV(Student sv){
        int res = 0;
        try{
            String qry = "update person set ";
            qry = qry + "Lastname='"+sv.getLastname()+"',";
            qry = qry + "Firstname='"+sv.getFirstname()+"',";
            qry = qry + "HireDate='"+sv.getHireDate()+"',";
            qry = qry + "EnrollmentDate='"+sv.getEnrollmentDate()+"'";
            qry = qry +" where PersonID ='"+sv.getMasv()+"'";
            res = my.executeUpdate(qry);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi sửa khách hàng Database");
        }
        return res;
    }
}