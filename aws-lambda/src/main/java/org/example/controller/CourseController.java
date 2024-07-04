package org.example.controller;

import org.example.dto.Course;
import org.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //defind an endpoint POST to create course
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        //call the method addCourse of ResponseEntity to create a new course
        courseService.addCourse(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
        // return a created object Course with HTTP status is CREATED
    }
    //defind an endpoint GET to fetch all Courses
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Course>> getAllCourses() {
        // call method getAllCourses of CourseService to get a list of all Courses
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
        // return a list of courses with HTTP status OK
    }
    //defind an endpoint GET to fetch a course by id
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Course> getCourseById(@PathVariable int id) {
        // Call a method getCourseById of CourseService to get the course by id
        Optional<Course> course = courseService.getCourseById(id);
        //check if the course exist
        return course.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    //defind an endpoint PUT to update the info a course by id
    @PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Course> updateCourse(@PathVariable int id, @RequestBody Course newCourse) {        // Gọi phương thức updateCourse của CourseService để cập nhật thông tin khóa học
        // call the method updateCourse of CourseService the update the info of the course
        boolean updated = courseService.updateCourse(id, newCourse);
        //check if the update is success or not
        if (updated) {
            return new ResponseEntity<>(newCourse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //defind an endpoint DELETE to delete a course by its id
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Void> deleteCourse(@PathVariable int id) {
        // call method deleteCourse of CourseService to delete the course
        boolean deleted = courseService.deleteCourse(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
