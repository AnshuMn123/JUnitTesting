package ttd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ttd.model.User;
import ttd.service.UserService;
import ttd.service.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserServiceTest {
    UserService userService;
    String firstName;
    String lastName;
    String email;
    String password;
    String repeatPassword;

    @BeforeEach
    void init(){
        userService = new UserServiceImpl();
        firstName = "Anshu";
        lastName = "Singh";
        email = "anshu@singh.com";
        password = "123456";
        repeatPassword = "123456";
    }

    @Test
    void createUser_WhenDetailProvided(){
        User user = userService.createUser(firstName, lastName, email, password, repeatPassword);

        assertNotNull(user, "ajcnasj");
        assertEquals(firstName, user.getFirstName(), "ad");
        assertEquals(lastName, user.getLastName());
        assertEquals(email, user.getEmail());
        assertNotNull(user.getId());
    }

    @Test
    void TestUser_WhenForNullOrEmptyValue(){
        firstName = "";
        String expectedExceptionMessage = "User's firstname can't be null";

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                userService.createUser(firstName, lastName, email, password, repeatPassword),
                () -> expectedExceptionMessage);

        assertEquals(expectedExceptionMessage, thrown.getMessage(), () -> "error massage is not same");
    }

    @DisplayName("Empty last name causes correct exception")
    @Test
    void testCreateUser_whenLastNameIsEmpty_throwsIllegalArgumentException() {
        String lastName = "";
        String expectedExceptionMessage = "User's last name is empty";

        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            userService.createUser(firstName, lastName, email, password, repeatPassword); },
                () -> "Empty last name should have caused an Illegal Argument Exception");

        assertEquals(expectedExceptionMessage,thrown.getMessage(),
                    () -> "Exception error message is not correct");
    }
}
