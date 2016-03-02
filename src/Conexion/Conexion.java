/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion{
	Connection conexion;
	Statement consulta;
	public String  ruta;

   
    public Conexion()
    {
        String ruta1 = System.getProperty("user.dir");
        JOptionPane.showMessageDialog(null,ruta1);
        ruta = "/"+ruta1+"/registro.db";
        //ruta = "C:/Users/Miguel Rocha/Downloads/ProyectoSQLite/registro.db";
    }
    public void conectar(){
		try {
	            Class.forName("org.sqlite.JDBC");
	        }
	        catch (ClassNotFoundException e) {
	            JOptionPane.showMessageDialog(null, e.getMessage());
	        }	 
			try {
                            conexion = DriverManager.getConnection("jdbc:sqlite:"+ruta);
                            consulta = conexion.createStatement();
			} catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
	}
    
}