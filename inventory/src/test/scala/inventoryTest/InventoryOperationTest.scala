package inventoryTest

import entity.Item
import operations.InventoryOperations
import org.scalatest.FlatSpec

class InventoryOperationTest extends FlatSpec {
  val inventoryOperationTest = new InventoryOperations
  val item =  new Item(1, "chair", 23, 2400, "furniture", "AB furnitures, Delhi", "wooden chair")
  val item2 =  new Item(1, "chair", 23, 2500, "furniture", "xyz furnitures, Delhi", "wooden chair")
  val item3 =  new Item(2, "chair", 24, 2500, "furniture", "xyz furnitures, Delhi", "wooden chair")

  "addItem function" should "add new item to the existing item list" in {

    assert(inventoryOperationTest.addItem(List(item)).contains(item))
  }

  it should "new item cannot be added exception" in {
    assertThrows[ArithmeticException](inventoryOperationTest.addItem(List(item2)))
  }

  "search Item function" should "search item based on a category" in {
    assert(inventoryOperationTest.searchItems(List(item),"furniture") == List(item))
  }

  it should "give no such category exists exception" in {
    assertThrows[ArithmeticException](inventoryOperationTest.searchItems(List(item),"toys"))
  }

  "sortItem function" should "sort item based on criteria given" in {
    assert(inventoryOperationTest.sortItems(List(item,item3),"low to high") == List(item,item3)
  }

}
