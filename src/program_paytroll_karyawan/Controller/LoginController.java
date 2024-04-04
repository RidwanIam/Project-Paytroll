/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program_paytroll_karyawan.Controller;

import program_paytroll_karyawan.Config.DbConnection;
import program_paytroll_karyawan.Model.LoginModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author lincbp
 */
public class LoginController {
    public String authUser(LoginModel loginModel){
        String res = "Failed";
        
        String username = loginModel.getUsername();
        String password = loginModel.getPassword();
        
        Connection conn = DbConnection.getConnection();;
        Statement st = null;
        ResultSet rs = null;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM employe WHERE username='"+username+"' AND password='"+password+"'");
            if(rs.next()){
                res = "Success";
            }
            conn.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return res;
    }
}
