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
      log.info("similar user already exist")
      userList
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
    userList diff List(user)
  }

  def authenticateUser(username: String, password: String, userList: List[User]): String = {
    val userExist = userList.exists(x => (x.username == username) && (x.password == password))
    if (userExist) {
      log.info("similar user already exist")
      "token"
    }
    else {
      "no token can be generated"
    }
  }
}

