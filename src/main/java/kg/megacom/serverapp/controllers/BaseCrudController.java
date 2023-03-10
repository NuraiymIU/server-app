package kg.megacom.serverapp.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BaseCrudController<S, T> {

    @PostMapping("/save")
    S save(@RequestBody S s);

    @PutMapping ("/update")
    S update(@RequestBody S s);

    @GetMapping("/{id}")
    S findById(@PathVariable T id);

    @GetMapping("/all")
    List<S> findAll();

}
