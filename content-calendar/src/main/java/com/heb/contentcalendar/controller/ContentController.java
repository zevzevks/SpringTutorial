package com.heb.contentcalendar.controller;

import com.heb.contentcalendar.model.Content;
import com.heb.contentcalendar.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@CrossOrigin()
public class ContentController {

    private final ContentRepository repository;

//    private final ContentJdbcRepository repository;

    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    //make a request get all content
    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    //CREATE READ UPDATE DELETE
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "content not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content) {
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no record to update");
        }
        repository.save(content);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

//    @GetMapping("/filter/{keyword}")
//    public List<Content> findByTitle(@PathVariable String keyword){
//
//    }
}
