package az.ematrix.matrix154springlearning.controller;


import az.ematrix.matrix154springlearning.dto.PersonDto;
import az.ematrix.matrix154springlearning.service.StudentsService;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/students")
public class StudentsController {

    private final StudentsService service;

    public StudentsController(StudentsService service) {
        this.service = service;
    }

    @GetMapping
    public String hello() {
        return "Hello World!";
    }

    @PostMapping("save")
    public PersonDto create(@RequestBody PersonDto dto) {
        service.save(dto);
        return dto;
    }

    @GetMapping("all")
    public ArrayList<PersonDto> readAll(@RequestHeader String language) {
        System.out.println(language);
        return service.getAll();
    }

    @GetMapping("get")
    public PersonDto get(@RequestParam Long id) {
        return service.get(id);
    }

    @PutMapping
    public PersonDto update(@RequestParam String name, @RequestParam Long id) {
        return service.update(name, id);
    }

    @DeleteMapping
    public HttpStatus delete(@RequestParam Long id) {
        service.delete(id);
        return HttpStatus.NO_CONTENT;
    }
}
