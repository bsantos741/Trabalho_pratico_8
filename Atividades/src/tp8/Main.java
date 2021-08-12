package tp8;


import tp8.TestConexao;
import tp8.Crud;
import java.sql.Statement;
import java.sql.SQLException;

public class Main{

	public static void main(String args[])throws Exception{
       
    	TestConexao conexao = new TestConexao();
        conexao.abrirConexao();
        Crud crud = new Crud(conexao.getConnection());
        
        
        
        //crud.adicionarAluno("Maria", 384487);          
        
        //crud.removerAluno(384487);
        
        //crud.atualizarAluno("Amaral", 383521);
        
        //crud.pesquisarAluno(383521);
      
        /*Aluno aluno = new Aluno();
        aluno.setNome("Neon");
        aluno.setMatricula(144777);
        crud.adicionarAluno(aluno);*/
        
       /*Aluno[] aluno = new Aluno[5];
        aluno[0] = new Aluno();
        aluno[1] = new Aluno();
        aluno[2] = new Aluno();
        aluno[3] = new Aluno();
        aluno[4] = new Aluno();
        
        aluno[0].setNome("Thais Dias");
        aluno[0].setMatricula(777000);
        aluno[1].setNome("Thais Castro");
        aluno[1].setMatricula(777001);
        aluno[2].setNome("Thais Herculano");
        aluno[2].setMatricula(777002);
        aluno[3].setNome("Thais Souza");
        aluno[3].setMatricula(777003);
        aluno[4].setNome("Thais Menezes");
        aluno[4].setMatricula(777005);
        
        crud.adicionarListaAlunos(aluno);*/
        
        //crud.pesquisarCampo("Thais");      
        
        
        
        
        
       
        
        
        
        //conexao.fecharConexao();     
        
        
    }
}