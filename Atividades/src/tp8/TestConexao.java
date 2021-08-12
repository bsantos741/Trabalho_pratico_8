package tp8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Mais aqui: https://github.com/xerial/sqlite-jdbc#usage
public class TestConexao {

    private Connection connection;
    public TestConexao(){
        this.connection = null;
    }
    
    private void setConnection(Connection connection){
        this.connection = connection;
    }
    public Connection getConnection(){
        return this.connection;
    }
    
    public boolean abrirConexao(){
      
      try
      {
        // create a database connection
        connection = DriverManager.getConnection("jdbc:sqlite:/home/bruno/Downloads/Atividades/Escola.db");
        this.setConnection(connection);        
        return true;

      }
      catch(SQLException e)
      {        
        return false;
      }
    }
      public boolean fecharConexao(){
        try
        {
          if(this.getConnection() != null)
                this.getConnection().close();
                return true;
        }
        catch(SQLException e)
        {
          return false;
        }
    }
}