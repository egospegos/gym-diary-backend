package gymdiary.controllerses;

import java.util.List;

import gymdiary.model.entity.Exercise;
import gymdiary.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class ExerciseController {
    @Autowired
    ExerciseRepository exerciseRepository;

    @GetMapping("/exercise")
    public List<Exercise> allExercises () {

        return exerciseRepository.getAll();
    }

    @PostMapping("/exercise")
    public String addExercise(@RequestBody Exercise e){
        exerciseRepository.save(e);
        return "ok";
    }

    @DeleteMapping("/exercise")
    public String deleteExercise(int id){
        exerciseRepository.delete(id);
        return "ok";
    }

    @PutMapping("/exercise")
    public String updateExercise(@RequestBody Exercise e){
        exerciseRepository.update(e);
        return "ok";
    }

}
