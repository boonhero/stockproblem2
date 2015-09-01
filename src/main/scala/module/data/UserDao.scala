package module.data

import model.User

trait UserDao {
  def update(user: User): Unit

  def find(name: String): Option[User]
}

class UserDaoImpl extends UserDao {
  override def find(name: String): Option[User] = ???

  override def update(user: User): Unit = ???
}
