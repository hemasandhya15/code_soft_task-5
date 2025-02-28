mport java.util.*;

class Course {
    String code, title, description, schedule;
    int capacity, availableSlots;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.availableSlots = capacity;
        this.schedule = schedule;
    }

    public void register() {
        if (availableSlots > 0) {
            availableSlots--;
            System.out.println("Registered successfully!");
        } else {
            System.out.println("Course is full!");
        }
    }

    public void drop() {
        if (availableSlots < capacity) {
            availableSlots++;
            System.out.println("Dropped successfully!");
        } else {
            System.out.println("You are not registered for this course!");
        }
    }
}

class Student {
    String id, name;
    List<Course> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        course.register();
        registeredCourses.add(course);
    }

    public void dropCourse(Course course) {
        course.drop();
        registeredCourses.remove(course);
    }
}

public class CourseRegistrationSystem {
    static Map<String, Course> courses = new HashMap<>();
    static Map<String, Student> students = new HashMap<>();

    public static void main(String[] args) {
        Course course1 = new Course("CS101", "Intro to CS", "Learn basics of CS", 10, "Mon 10-12");
        Course course2 = new Course("CS202", "Data Structures", "Learn data structures", 15, "Tue 2-4");

        courses.put(course1.code, course1);
        courses.put(course2.code, course2);


        Student student1 = new Student("S1", "John Doe");
        Student student2 = new Student("S2", "Jane Doe");

        students.put(student1.id, student1);
        students.put(student2.id, student2);

        System.out.println("Available Courses:");
        for (Course course : courses.values()) {
            System.out.println(course.code + ": " + course.title + " - Available Slots: " + course.availableSlots);
        }

        student1.registerCourse(course1);
        student2.registerCourse(course2);

        System.out.println("\nRegistered Courses:");
        for (Student student : students.values()) {
            System.out.println(student.name + ":");
            for (Course course : student.registeredCourses) {
                System.out.println(course.code + ": " + course.title);
            }
        }

        student1.dropCourse(course1);
        System.out.println("\nUpdated Registered Courses:");
        for (Student student : students.values()) {
            System.out.println(student.name + ":");
            for (Course course : student.registeredCourses) {
                System.out.println(course.code + ": " + course.title);
            }
        }
    }
}
