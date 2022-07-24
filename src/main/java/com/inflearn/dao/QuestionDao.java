package com.inflearn.dao;    
import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;    
import com.inflearn.beans.Question;    
    
public class QuestionDao {    
JdbcTemplate template;    
    
public void setTemplate(JdbcTemplate template) {    
    this.template = template;    
}    
public int save(Question p){    
    String sql="insert into june_question(user_id, title, content) values('1','"+p.getTitle()+"','"+p.getContent()+"')";    
    return template.update(sql);    
}    
public int update(Question p){    
    String sql="update june_question set user_id='1', title='"+p.getTitle()+"',content='"+p.getContent()+"' where id="+p.getId();    
    System.out.println(sql);
    return template.update(sql);    
}    
public int delete(int id){    
    String sql="delete from june_question where id="+id+"";    
    return template.update(sql);    
}    
public Question getRecordById(int id){    
    String sql="select * from june_question where id=?";    
    Question queryForObject = template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Question>(Question.class));
	return queryForObject;    
}    
public List<Question> getAllRecords(){    
    return template.query("select * from june_question",new RowMapper<Question>(){    
        public Question mapRow(ResultSet rs, int row) throws SQLException {    
        	Question e=new Question();    
            e.setId(rs.getInt(1));    
            e.setUser_id(rs.getInt(2));    
            e.setTitle(rs.getString(3));    
            e.setContent(rs.getString(4));    
            e.setTime_stamp(rs.getString(5));    

            return e;    
        }    
    });    
}    
}   