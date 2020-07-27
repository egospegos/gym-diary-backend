package gymdiary.repositories;

import gymdiary.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate=jdbcTemplate;
    }

    public void save(User request){
        jdbcTemplate.update("Insert INTO users (login, password) values (?,?)",
                request.getLogin(), request.getPassword());
    }

    public User getUser(String login){

        return jdbcTemplate.queryForObject("Select * from Users WHERE login=?", new Object[]{login}, (rs, rowNum) ->
                new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password")
                ));
    }

    public List<User> getAll(){
        return jdbcTemplate.query("Select * from Users", (rs, rowNum) ->
                new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password")
                ));
    }

    public void delete(Integer id){
        String sql = "DELETE FROM Users WHERE id = ?";
        Object[] args = new Object[] {id};

        jdbcTemplate.update(sql, args);
    }


}
