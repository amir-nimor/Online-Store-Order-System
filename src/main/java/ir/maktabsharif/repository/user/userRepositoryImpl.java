package ir.maktabsharif.repository.user;

import ir.maktabsharif.exception.HibernateException;
import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.model.User;
import ir.maktabsharif.repository.BaseRepository.BaseRepositoryImpl;
import ir.maktabsharif.util.HibernateUtil;

public class userRepositoryImpl extends BaseRepositoryImpl<User,Integer> implements userRepository {

    public userRepositoryImpl() {
        super(User.class);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        try {
            return HibernateUtil.read(em -> {
                return em.createQuery("SELECT s FROM User s where s.username = ?1 and s.password = ?2", User.class)
                        .setParameter(1,username)
                        .setParameter(2,password)
                        .getSingleResult();
            });
        }catch (HibernateException e){
            throw new RepositoryException("your operation is failed "+e.getMessage());
        }
    }
}
