package ttd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ttd.model.User;
import ttd.service.UserService;
import ttd.service.UserServiceImpl;
import ttd.userRepository.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Mock
    UserRepository userRepository;

    String firstName;
    String lastName;
    String email;
    String password;
    String repeatPassword;

    @BeforeEach
    void init(){
        firstName = "Anshu";
        lastName = "Singh";
        email = "anshu@singh.com";
        password = "123456";
        repeatPassword = "123456";
    }

    @Test
    void createUser_WhenDetailProvided(){
        // mocking
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(true);

        User user = userServiceImpl.createUser(firstName, lastName, email, password, repeatPassword);

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
                        userServiceImpl.createUser(firstName, lastName, email, password, repeatPassword),
                () -> expectedExceptionMessage);

        assertEquals(expectedExceptionMessage, thrown.getMessage(), () -> "error massage is not same");
    }

    @DisplayName("Empty last name causes correct exception")
    @Test
    void testCreateUser_whenLastNameIsEmpty_throwsIllegalArgumentException() {
        String lastName = "";
        String expectedExceptionMessage = "User's last name is empty";

        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
                    userServiceImpl.createUser(firstName, lastName, email, password, repeatPassword); },
                () -> "Empty last name should have caused an Illegal Argument Exception");

        assertEquals(expectedExceptionMessage,thrown.getMessage(),
                    () -> "Exception error message is not correct");
    }
}
