package operations

import entity.User
import resources.AccountResources
import org.apache.log4j.Logger
import scala.io.StdIn

class UserOperations extends AccountResources {

  val log = Logger.getLogger(this.getClass)

  def addUser(userList: List[User]): List[User] = {
    log.info("\nEnter user mobile number:\n")
    val mobileNumber = StdIn.readLine().toString
    val userExist = userList.exists(x => x.mobileNumber == mobileNumber)
    if (userExist) {
      throw new Exception("Similar User exists,New user cannot be added")
    }
    else {
      log.info("\nEnter username\n")
      val username = StdIn.readLine().toString
      log.info("\nEnter password\n")
      val password = StdIn.readLine().toString
      log.info("\nEnter mobile number\n")
      val mobileNumber = StdIn.readLine().toString
      val newUser = User(username, password, mobileNumber)
      val updatedUserList = userList :+ newUser
      updatedUserList
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

  def authenticateUser(username: String, password: String, userList: List[User]): String = {
    val userExist = userList.exists(x => (x.username == username) && (x.password == password))
    if (userExist) {
      log.info("similar user already exist")
      val token = username + "Token"
      token
    }
    else {
      throw new Exception("user doesn't exist, no token can be generated")
    }
  }
}

