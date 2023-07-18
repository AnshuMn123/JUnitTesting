package ttd.service;

import ttd.model.User;
import ttd.userRepository.UserRepository;
import ttd.userRepository.UserRepositoryImpl;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


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

        User user = new User(firstName, lastName, email, UUID.randomUUID().toString());

        // this is a one way of doing these
        // but it will not make any differrence or we are not using mocking in it
        // because we are creating instance of class as object.
//        UserRepository userRepository = new UserRepositoryImpl();
        userRepository.save(user);

        // For mocking
        boolean isCreated = userRepository.save(user);

        if(!isCreated){
            throw new UserServiceException("User were not created");
        }

        return user;
    }


}
