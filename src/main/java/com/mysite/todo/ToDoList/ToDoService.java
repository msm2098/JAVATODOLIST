package com.mysite.todo.ToDoList;


import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;
    public List<ToDoEntity>getList(){
        return this.toDoRepository.findAll();
    }
    public void create(String content){
        ToDoEntity toDoEntity = new ToDoEntity();
        toDoEntity.setContent(content);
        toDoEntity.setCompleted("<div id=\"progress\" class=\"badge bg-danger text-wrap fs-5 rounded-pill\">진행중</div>");
        this.toDoRepository.save(toDoEntity);
    }
    public void delete(Integer id){
        ToDoEntity toDoEntity = toDoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 아이템이 없습니다. id"+id));
        this.toDoRepository.delete(toDoEntity);
    }
    @Transactional
    public void update(Integer id, String content){
        ToDoEntity toDoEntity = toDoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 아이템이 없습니다. id"+id));
        toDoEntity.setContent(content);
        this.toDoRepository.save(toDoEntity);
    }
    @Transactional
    public void finish(Integer id,String content){
        ToDoEntity toDoEntity = toDoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 아이템이 없습니다. id"+id));
        toDoEntity.setCompleted(content);
        this.toDoRepository.save(toDoEntity);
    }

}
