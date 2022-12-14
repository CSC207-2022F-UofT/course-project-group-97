package Entities.UserDataClasses.HideableUserDataClasses;

import Entities.UserDataClasses.CourseCode;
import Entities.UserDataClasses.HideableData;

import java.io.Serializable;
import java.util.ArrayList;

public class Courses extends HideableData<ArrayList<Course>> implements Serializable {
    public ArrayList<Course> data;
    public boolean hidden;

    // Constructors
    public Courses(){
        super(new ArrayList<>());
        this.data = super.data;
    }
    public Courses(String[] courseStrings){
        super(new ArrayList<>());
        for(String courseCodeData: courseStrings){
            super.data.add(new Course(new CourseCode(courseCodeData)));
        }
        this.data = super.data;
    }

    public Courses(ArrayList<Course> newCourses) {
        super(newCourses);
        this.data = super.data;
    }

    // Methods
    public void addCourse(Course course){
        this.data.add(course);
    }
    public void addCourses(ArrayList<Course> courses){
        this.data.addAll(courses);
    }
    public void removeCourse(Course course){
        this.data.remove(course);
    }
    public void removeCourses(ArrayList<Course> courses){
        this.data.removeAll(courses);
    }
    @Override
    public String toString(){
        StringBuilder returnString = new StringBuilder();
        if(this.data == null){return "";}
        for(Course course: this.data){
            returnString.append(course.getData().code);
            returnString.append(", ");
        }
        return returnString.toString();
    }
}