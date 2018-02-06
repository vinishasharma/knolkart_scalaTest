package entity

case class User(username: String, password: String, mobileNumber: String) {
  override def toString: String = {
    s"Username: $username password: $password\nMobile Number: $mobileNumber"
  }

}
