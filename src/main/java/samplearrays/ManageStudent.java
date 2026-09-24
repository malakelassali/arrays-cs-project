package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest= students[0];
        for (Student student : students) {
            if (student.getAge() > oldest.getAge()){
                oldest= student;
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count= 0;
        for (Student student: students) {
            if (student.getAge() >= 18) {
                count++;
            }
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        double sum= 0;
        int validStudents= 0;
        for (Student student:students) {
            sum+= student.getGrade();
            if (student.getGrade() > 0) validStudents++;
        }
        if (validStudents==0) return Double.NaN;
        return sum / validStudents;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student student:students) {
            if (student.getName() == name) return student;
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students, (Student a, Student b) -> b.getGrade() - a.getGrade());
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for (Student student:students) {
            if (student.getGrade() >= 15) System.out.println(student.toString());
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (Student student:students) {
            if (student.getId() == id) {
                student.setGrade(newGrade);
                return true;
            }
        } return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        Student[] found= new Student[students.length];
        int k= 0;
        for (Student student : students) {
            if (Arrays.asList(found).contains(student)) return true;
            found[k++] = student;
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] newArray= Arrays.copyOf(students, students.length + 1);
        newArray[students.length] = newStudent;
        return newArray;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] students= {new Student(1, "Jad", 14, 13),
                            new Student(2, "Laila", 20, 16),
                            new Student(3, "Khalid", 21, 15),
                            new Student(4, "Rim", 22, 18),
                            new Student(5, "Khadija", 18, 12),
        };

        // Print all
        System.out.println("== All Students ==");
        for (Student s : students) System.out.println(s.toString());
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("Oldest: " + findOldest(students).toString());

        // 3) Count adults
        System.out.println("There are " + countAdults(students) + " adults");

        // 4) Average grade
        System.out.println("Average grade: " + averageGrade(students));

        // 5) Find by name
        System.out.println(findStudentByName(students, "Khadija").toString());

        // 6) Sort by grade desc
        // sort function
        sortByGradeDesc(students);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : students) System.out.println(s.toString());

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(students);

        // 8) Update grade by id
        updateGrade(students, 4, 13);
        Student updated= students[0];

        for (Student student : students) {
            if (student.getId() == 4) {
                updated= student;
                break;
            }
        }
        // function
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(students, "Dina"));

        // 9) Duplicate names
        System.out.println("Does the array have duplicate names? " + hasDuplicateNames(students));

        // 10) Append new student
        Student[] newArray= appendStudent(students, new Student(6,"Malak", 20, 17));
        for (Student student : newArray) {
            System.out.println(student.toString());
        }
    }
}

