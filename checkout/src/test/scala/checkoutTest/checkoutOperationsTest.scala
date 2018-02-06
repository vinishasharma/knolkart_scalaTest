package checkoutTest

import entity.Item
import operations.{CheckoutOperations, InventoryOperations}
import org.scalatest.FlatSpec


class checkoutOperationsTest extends FlatSpec {
    val checkoutOperation = new CheckoutOperations
    val inventoryOperations = new InventoryOperations
    val item =  new Item(1, "chair", 10, 200, "furniture", "AB furnitures, Delhi", "wooden chair")
    val item2 =  new Item(1, "chair", 23, 2500, "furniture", "xyz furnitures, Delhi", "wooden chair")
    val item3 =  new Item(2, "chair", 10, 500, "furniture", "xyz furnitures, Delhi", "wooden chair")

    "addItems to kart function" should "add new item to the existing item list in kart" in {

      assert(checkoutOperation.addItemsToKart(List(item),item3).contains(item3))
    }

    "remove Item function" should "remove item from the kart" in {
      assert(checkoutOperation.removeItemsFromKart(List(item,item3),item3) == List(item))
    }

    "buy items function" should "give total amount to be payed" in {
      assert(checkoutOperation.buyItems(List(item,item3)) == 500.0)
    }
}
