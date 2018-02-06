package accountTest

import entity.User
import operations.UserOperations
import org.scalatest.FlatSpec

class UserOperationTest extends FlatSpec {

  val userOperationTest = new UserOperations
  val user =  new User("vinisha","vinisha1234","9999876542")
  val otherUser =  new User("ramesh","ramesh1234","9899876542")
  val userList = List(otherUser)
  "addUser function" should "add new user to the existing user list" in {
    assert(userOperationTest.addUser(userList,user).contains(user))
  }

  it should "new user cannot be added exception" in {
    assertThrows[Exception](userOperationTest.addUser(userList,otherUser))
  }

  "removeUser function" should "remove user from the existing user list" in {
    assert(!userOperationTest.removeUser(userList, otherUser).contains(otherUser))
  }

  it should "cannot remove user exception" in {
    assertThrows[Exception](userOperationTest.removeUser(userList,user))
  }

  "authenticateUser function" should "return true if user is registered" in {
    assert(userOperationTest.authenticateUser("ramesh","ramesh1234",userList))
  }

  it should " give user not registered exception" in {
    assertThrows[Exception](userOperationTest.authenticateUser("vinisha","vinisha11",userList))
  }

}

