trait AccountService {

  def addUser(userMobileNumber: String): List(User)
  def removeUser(userMobileNumber: String):List(User)
  def authenticateUser(username: String,password: String): Boolean
}
