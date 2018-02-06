package inventoryTest

import entity.Item
import operations.InventoryOperations
import org.scalatest.FlatSpec

class InventoryOperationTest extends FlatSpec {
  val inventoryOperationTest = new InventoryOperations
  val item =  new Item(1, "chair", 23, 2400, "furniture",5, "AB furnitures, Delhi", "wooden chair")
  val item2 =  new Item(1, "chair", 23, 2500, "furniture",4,"xyz furnitures, Delhi", "wooden chair")
  val item3 =  new Item(2, "chair", 24, 2500, "furniture",3 ,"xyz furnitures, Delhi", "wooden chair")
  val itemList = List(item)
  "addItem function" should "add new item to the existing item list" in {
    assert(inventoryOperationTest.addItem(itemList,item3).contains(item3))
  }

  it should "new item cannot be added exception" in {
    assertThrows[Exception](inventoryOperationTest.addItem(itemList,item2))
  }

  "search Item function" should "search item based on a category" in {
    assert(inventoryOperationTest.searchItems(itemList,"furniture") == itemList)
  }

  it should "give no such category exists exception" in {
    assertThrows[Exception](inventoryOperationTest.searchItems(itemList,"toys"))
  }

  "sortItem function" should "sort item based on criteria given" in {
    assert(inventoryOperationTest.sortItems(List(item,item3),"low to high") == List(item,item3))
  }

  it should "sort item from high to low based on criteria given" in {
    assert(inventoryOperationTest.sortItems(List(item,item3),"highToLow") == List(item3,item))
  }

}
