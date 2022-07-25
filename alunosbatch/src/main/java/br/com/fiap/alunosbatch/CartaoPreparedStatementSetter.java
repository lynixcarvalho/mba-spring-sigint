package br.com.fiap.alunosbatch;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CartaoPreparedStatementSetter implements ItemPreparedStatementSetter<Aluno>{
    
    @Override
    public void setValues(Aluno aluno, PreparedStatement ps) throws SQLException {
        ps.setString(1, aluno.getCartao().getCartao().toString());
        ps.setString(2, aluno.getCartao().getLimite().toString());
        ps.setString(3, aluno.getCartao().getSenha());
        ps.setString(4, aluno.getCartao().getCreatedDate().toString());
        ps.setString(5, aluno.getCartao().getExpiredDate().toString());
        ps.setString(6, aluno.getCartao().getCancelDate().toString());
        ps.setString(7, String.valueOf(aluno.getMatricula()));
        
    }
    
}
