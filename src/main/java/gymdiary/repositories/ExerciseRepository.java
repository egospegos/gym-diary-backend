package gymdiary.repositories;

import gymdiary.model.entity.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExerciseRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ExerciseRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate=jdbcTemplate;

    }


    public void save(Exercise request){
       jdbcTemplate.update("Insert INTO Exercises (name, muscles, description, image_base_64) values (?,?,?,?)",
               request.getName(), request.getMuscles(), request.getDescription(), request.getImageBase64());
    }

    // удалять по ID ?
    public void delete(Integer id){
        String sql = "DELETE FROM Exercises WHERE id = ?";
        Object[] args = new Object[] {id};

        jdbcTemplate.update(sql, args);
    }

    
    public void update(Exercise e){
        String SQL = "update Exercises set name = COALESCE (?, name)," +
                " muscles = ?, description = ? where id = ?";
        jdbcTemplate.update(SQL, e.getName(), e.getMuscles(), e.getDescription(), e.getId());
    }

    public List<Exercise> getAll(){
        return jdbcTemplate.query("Select * from Exercises", (rs, rowNum) ->
                new Exercise(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("muscles"),
                        rs.getString("description"),
                        rs.getString("image_base_64")
                ));
    }


}
