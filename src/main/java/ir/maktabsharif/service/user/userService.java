package ir.maktabsharif.service.user;

import ir.maktabsharif.model.User;
import ir.maktabsharif.service.Base.BaseService;

public interface userService extends BaseService<User,Integer> {
    User findByUsernameAndPassword(String username,String password);
}
