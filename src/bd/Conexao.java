/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bd;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Biah
 */
public class Conexao {
    
    private static Connection conexao;
    
    private Conexao(){}
    
    public static Connection getConexao(){
        
        
        if(conexao == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bd_restaurante", "root", "vertrigo");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return conexao;
    }
    
    
}
