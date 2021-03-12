package application;

import Db.DB;
import Db.DBExeption;
import Db.DBIntegrityException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {

    public static void main(String[] args) {

       Connection conn = null;
       Statement st = null;
       try{
           conn = DB.getConnection();
           conn.setAutoCommit(false);
           st = conn.createStatement();

           int rows1 = st.executeUpdate(
                   "UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");


           int rows2 = st.executeUpdate(
                   "UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

           conn.commit();


           System.out.println("rows1: " + rows1);
           System.out.println("rows2: " + rows2);
       }catch (SQLException e){
           try {
               conn.rollback();
               throw  new DBExeption("Trasaction rolled back, cused by: " + e.getMessage());
           }catch(SQLException e1){
               throw new DBExeption("error trying to rowback, cause by: " + e1.getMessage());
           }
       }
       finally {
           DB.closeStatement(st);
           DB.closeConnection();
       }
    }
}
