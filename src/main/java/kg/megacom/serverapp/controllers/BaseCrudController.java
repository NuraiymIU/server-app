package kg.megacom.serverapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BaseCrudController<S, T> {

    @PostMapping("/save")
    S save(@RequestBody S s);

    @PostMapping("/update")
    S update(@RequestBody S s);

    @GetMapping("/{id}")
    S findById(@PathVariable T id);

    @GetMapping("/all")
    List<S> findAll();

}
