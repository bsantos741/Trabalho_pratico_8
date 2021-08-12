package tp8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Crud
{
	
    //cria o objeto do tipo conexão
    private Connection conexao;
    public Crud(Connection conexao){
        this.conexao = conexao;
    }
    
    public boolean adicionarAluno(String nome, int matricula){
        try{
            //O código SQL pode ser qualquer um, nesse caso é devido ser a construção do CRUD
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO Aluno VALUES('"+nome+"', "+matricula+")");
            
            System.out.println(nome+" - "+matricula+" foi adicionado com sucesso");
            return true;
            
        }catch(SQLException e){
            return false;
        }
    
    }
    
    public void adicionarAluno(Aluno aluno){
    	try {
    		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ALUNO (nome , matricula) VALUES (?, ?)");
    		
    		stmt.setString(1, aluno.getNome());
    		stmt.setInt(2, aluno.getMatricula());
    		
    		stmt.execute();
    		stmt.close();
    		
    		System.out.println("O aluno(a) "+aluno.getNome()+" foi adicionado com sucesso");
    		
    	}catch (SQLException e) {
    		throw new RuntimeException(e);
    	}
                      
    }
   
	public boolean pesquisarAluno(int matricula){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Aluno WHERE Matricula = "+matricula);

            while (rs.next()) {
                Integer id = rs.getInt("matricula");
                String nome = rs.getString("nome");

                System.out.println( "Matricula "+matricula +" pertence ao aluno(a) " + nome);
            }
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean atualizarAluno(String novoNome, int matricula){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("UPDATE Aluno SET nome ='"+novoNome+"' WHERE matricula ="+matricula);
            
            System.out.println("O nome do aluno(a) pertencente a matricula "+matricula+" foi alterado para "+novoNome);
            return true;
            
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean removerAluno(int matricula){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("DELETE FROM Aluno WHERE matricula ="+matricula+"");
            
            System.out.println("Aluno(a) de matricula "+matricula+" foi removido");
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    public void adicionarListaAlunos(Aluno[] alunos) {
    	for (int i = 0; i < 5 ; i++) {
    		adicionarAluno(alunos[i]);
    	}
    }
    public void pesquisarCampo(String campo){
    	try {
    		Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Aluno WHERE Nome LIKE '%"+campo+"%'");

            while (rs.next()) {
                Integer matricula = rs.getInt("matricula");
                String nome = rs.getString("nome");

                
                System.out.println("Matricula "+matricula +"| Aluno(a) " + nome);
    			
    		}
    		
    	
    		//System.out.println("O aluno(a) "+aluno.getNome()+" foi adicionado com sucesso");
    		
    	}catch (SQLException e) {
    		throw new RuntimeException(e);
    	}
    }
}