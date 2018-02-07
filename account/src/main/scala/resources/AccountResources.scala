package resources

import entity.User

trait AccountResources {
  def addUser(userList: List[User], user: User): List[User]

  def removeUser(userList: List[User], user: User): List[User]

  def authenticateUser(username: String, password: String, userList: List[User]): Boolean
}

