package Entities.UserDataClasses;

public class Course extends HideableData<CourseCode> {
    public CourseCode data;
    public boolean hidden;

    public Course(CourseCode courseCode){
        super(courseCode);
        this.data = courseCode;
        this.hidden = true;
    }
    public Course(CourseCode courseCode, boolean hidden){
        super(courseCode);
        this.data = courseCode;
        this.hidden = hidden;
    }
}
