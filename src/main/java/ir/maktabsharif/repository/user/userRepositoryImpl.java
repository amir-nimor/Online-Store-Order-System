package ir.maktabsharif.repository.user;

import ir.maktabsharif.model.User;
import ir.maktabsharif.repository.BaseRepository.BaseRepositoryImpl;

public class userRepositoryImpl extends BaseRepositoryImpl<User,Integer> implements userRepository {

    public userRepositoryImpl() {
        super(User.class);
    }
}
