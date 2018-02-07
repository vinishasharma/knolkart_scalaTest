package operations

import entity.User
import resources.AccountResources
import org.apache.log4j.Logger

class UserOperations extends AccountResources {

  val log = Logger.getLogger(this.getClass)

  def addUser(userList: List[User], user: User): List[User] = {
    val userExist = userList.exists(x => x.mobileNumber == user.mobileNumber)
    if (userExist) {
      throw new Exception("Similar User exists,New user cannot be added")
    }
    else {
      user :: userList
    }
  }

  def removeUser(userList: List[User], user: User): List[User] = {
    val userExist = userList.exists(x => x.mobileNumber == user.mobileNumber)
    if (userExist) {
      userList diff List(user)
    }
    else {
      throw new Exception("user does not exist ")
    }
  }

  def authenticateUser(username: String, password: String, userList: List[User]): Boolean = {
    val userExist = userList.exists(x => (x.username == username) && (x.password == password))
    if (userExist) {
      true
    }
    else {
      throw new Exception("user doesn't exist, no token can be generated")
    }
  }
}

