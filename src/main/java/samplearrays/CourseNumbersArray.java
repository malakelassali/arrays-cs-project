package samplearrays;

import java.util.Arrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int newCourse = 3030;

        int[] updatedCourses = Arrays.copyOf(registeredCourses, registeredCourses.length + 1);
        updatedCourses[registeredCourses.length] = newCourse;

        System.out.println("Courses: ");
        for (int course : updatedCourses) {
            System.out.println(course);
        }

        int nb= 20;
        boolean found= false;
        for (int course:updatedCourses) {
            if (nb == course) {
                found= true;
                break;
            }
        }

        if (found) System.out.println(nb + " was found in the course list!");
        else System.out.println(nb + " was not found in the course list :(");
    }
}
