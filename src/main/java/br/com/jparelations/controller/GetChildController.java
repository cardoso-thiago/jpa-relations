package br.com.jparelations.controller;

import br.com.jparelations.entity.Child;
import br.com.jparelations.entity.Parent;
import br.com.jparelations.repository.ChildRepository;
import br.com.jparelations.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetChildController {
    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;

    @GetMapping
    public ResponseEntity<Iterable<Parent>> getParent() {
        Iterable<Parent> all = parentRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/childs")
    public ResponseEntity<Iterable<Child>> getChildsById(@RequestParam Long id) {
        Iterable<Child> all = childRepository.findChildByParentId(id);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @DeleteMapping("/childs")
    public ResponseEntity<String> deleteChildById(@RequestParam Long id) {
        childRepository.delete(childRepository.findById(id).get());
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @PostMapping("/childs")
    public ResponseEntity<String> addChild(@RequestParam Long id) {
        childRepository.save(new Child("new_child", parentRepository.findById(id).get()));
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}
