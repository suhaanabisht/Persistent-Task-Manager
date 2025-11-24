# USAGE

## Requirements
- Java JDK 11 or higher
- IDE: IntelliJ IDEA or Eclipse (or terminal for command line)
- Optional CSV files in the test-data/ folder:
    - students.csv
    - courses.csv
    - enrollments.csv

## Running in an IDE
1. Open the project folder vityarthi_proj in your IDE.
2. Ensure the src/ folder contains your classes (Person, Student, Teacher, Course) under edu.ccrm.domain.
3. Confirm the test-data/ folder is present at the project root.
4. Open Main.java (your main class).
5. Click *Run*.
6. Check the console output to see students, courses, and enrollments.

## Running via Command Line
1. Open a terminal and navigate to your project root:
   bash
   cd path/to/vityarthi_proj/src

2. Compile the Java classes:
   bash
   cd javac edu/ccrm/domain/*.java edu/ccrm/Main.java


3. Run the project:
    ```bash
    cd java edu.ccrm.Main


4. Output will appear in the terminal.

# Adding or Updating Test Data

- You can modify or replace CSV files in test-data/.

- Headers must remain the same:

- students.csv → student_id,first_name,last_name,email

- courses.csv → course_id,course_name,credits

- enrollments.csv → enrollment_id,student_id,course_id,grade