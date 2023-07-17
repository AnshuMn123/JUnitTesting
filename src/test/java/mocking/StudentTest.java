package mocking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    StudentService studentService = Mockito.mock(StudentService.class);
    Student s = new Student(studentService);
    @Test
    void testAverage() {
        Mockito.when(studentService.getTotalMark()).thenReturn(500);
        Mockito.when(studentService.getTotalStudent()).thenReturn(50);
        Assertions.assertEquals(10, s.getAverageMarks());
    }
}