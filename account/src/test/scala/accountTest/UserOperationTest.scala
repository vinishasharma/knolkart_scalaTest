package accountTest

import entity.User
import operations.UserOperations
import org.scalatest.FlatSpec

class UserOperationTest extends FlatSpec {

  val userOperationTest = new UserOperations
  val user =  new User("vinisha","vinisha1234","9999876542")
  val otherUser =  new User("ramesh","ramesh1234","9899876542")
  "addUser function" should "add new user to the existing user list" in {

    assert(userOperationTest.addUser(List(user)).contains(User("vinisha","vinisha1234","9999876542")))
  }

  it should "new user cannot be added exception" in {
    assertThrows[ArithmeticException](userOperationTest.addUser(List(otherUser)))
  }

  "removeUser function" should "remove user from the existing user list" in {
    assert(!userOperationTest.removeUser(List(user), user).contains(user))
  }

  it should "cannot remove user exception" in {
    assertThrows[ArithmeticException](userOperationTest.addUser(List(user,otherUser)))
  }

  "authenticateUser function" should "return token if user is registered" in {
    assert(userOperationTest.authenticateUser("vinisha","vinisha1234",List(user)) == "vinishaToken")
    assert(userOperationTest.authenticateUser("vinisha","vinisha1234",List(user)) == "vinishaToken")
  }

  it should " give user not registered exception" in {
    assertThrows[ArithmeticException](userOperationTest.addUser(List(user,otherUser)))
  }

}

