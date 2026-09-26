package ir.maktabsharif.service.user;

import ir.maktabsharif.exception.ValidationException;
import ir.maktabsharif.model.User;
import ir.maktabsharif.service.Base.BaseServiceImpl;
import ir.maktabsharif.repository.user.userRepository;
import ir.maktabsharif.repository.user.userRepositoryImpl;

import java.math.BigDecimal;

public class userServiceImpl extends BaseServiceImpl<User, Integer, userRepository> implements userService {
    public userServiceImpl(userRepository repository) {
        super(repository);
    }

    @Override
    protected void validation(User user) throws ValidationException {
        if (user.getFullName().isBlank()) throw new ValidationException("your user name is empty");
        if (user.getBalance().compareTo(BigDecimal.ZERO) < 0)
            throw new ValidationException("your user balance is negative");
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return new userRepositoryImpl().findByUsernameAndPassword(username,password);
    }
}
