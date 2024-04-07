/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program_paytroll_karyawan.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import program_paytroll_karyawan.Config.DbConnection;
import program_paytroll_karyawan.Model.LoginModel;

/**
 *
 * @author lincbp
 */
public class LoginDAO implements ImplementLogin{

    @Override
    public String authUser(LoginModel loginModel) {
        String username = loginModel.getUsername();
        String password = loginModel.getPassword();
        Connection conn = DbConnection.getConnection();;
        Statement st = null;
        ResultSet rs = null;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM employe WHERE username='"+username+"' AND password='"+password+"' limit 1");
            if(rs.next()){
                loginModel.setEmploye_id(rs.getInt("employe_id"));
                loginModel.setEmploye_name(rs.getString("employe_name"));
                loginModel.setDate_of_birth(rs.getDate("date_of_birth"));
                loginModel.setNik(rs.getString("nik"));
                loginModel.setRole(rs.getString("role"));
                loginModel.setSalary(rs.getDouble("salary"));
                loginModel.setIs_active(rs.getInt("is_active"));
                loginModel.setCreated_by(rs.getString("created_by"));
                loginModel.setCreated_at(rs.getDate("created_at"));
                
                return "Success";
                
            }
            conn.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "Failed";
        
    }
    
}
