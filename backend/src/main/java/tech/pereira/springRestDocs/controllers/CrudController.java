package tech.pereira.springRestDocs.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.pereira.springRestDocs.models.CrudInput;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/crud")
public class CrudController {

    @GetMapping
    public List<CrudInput> read(@RequestBody @Valid CrudInput crudInput) {
        List<CrudInput> crudInputs = new ArrayList<>();
        crudInputs.add(crudInput);

        return crudInputs;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public HttpHeaders save(@RequestBody @Valid CrudInput crudInput) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(linkTo(CrudController.class).slash(crudInput.getId()).toUri());

        return httpHeaders;
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public HttpHeaders delete(@PathVariable long id) {
        return new HttpHeaders();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public void put(@PathVariable long id, @RequestBody CrudInput crudInput) {}

    @PatchMapping("/{id}")
    public List<CrudInput> patch(@PathVariable long id, @RequestBody CrudInput crudInput) {
        crudInput.setId(id);

        List<CrudInput> crudInputs = new ArrayList<>();
        crudInputs.add(crudInput);

        return crudInputs;
    }
}
