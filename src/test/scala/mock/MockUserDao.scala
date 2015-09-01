package mock

import model.{Stock, User}
import module.data.UserDao

/**
 * Created by asales on 1/9/2015.
 */
class MockUserDao extends UserDao {
  var user: User = User("testId", List[Stock]())

  override def find(name: String): Option[User] = {
    Some(user)
  }

  override def update(user: User): Unit = {

  }
}
