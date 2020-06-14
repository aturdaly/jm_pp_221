package hiber.dao;

import hiber.model.User;
import javax.persistence.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserByCarInfo(String carName, Long carSeries) {
      String hql = "from User user where user.car.name = :paramCarName AND user.car.series = :paramCarSeries";
      Query query=sessionFactory.getCurrentSession().createQuery(hql);
      query.setParameter("paramCarName", carName);
      query.setParameter("paramCarSeries", carSeries);
      return (User) query.getSingleResult();
   }

}
