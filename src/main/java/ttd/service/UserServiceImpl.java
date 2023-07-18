package ttd.service;

import ttd.model.User;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    @Override
    public User createUser(
            String firstName,
            String lastName,
            String email,
            String password,
            String repeatPassword
    ) {

        if(firstName == null || firstName.trim().length() == 0){
            throw new IllegalArgumentException("User's firstname can't be null");
        }

        if(lastName == null || lastName.trim().length() == 0) {
            throw new IllegalArgumentException("User's last name is empty");
        }

        return new User(firstName, lastName, email, UUID.randomUUID().toString());
    }


}
