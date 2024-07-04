package org.example.service;

import org.example.dto.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final List<Course> courses = new ArrayList<>();
    // A method of creating a new course
    public void addCourse(Course course) {
        courses.add(course);
    }
    // a method of fetching all courses
    public List<Course> getAllCourses() {
        return courses;
    }
    // a method of fetching a course by its id
    public Optional<Course> getCourseById(int id) {
        return courses.stream()
                .filter(course -> course.getId() == id)
                .findFirst();
    }
    // Update a course
    public boolean updateCourse(int id, Course newCourse) {
        return getCourseById(id).map(existingCourse -> {
            courses.remove(existingCourse);
            courses.add(newCourse);
            return true;
        }).orElse(false);
    }

    // Delete a course by its id
    public boolean deleteCourse(int id) {
        return courses
                .removeIf(course -> course.getId() == id);
    }
}
