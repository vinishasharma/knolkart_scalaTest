package operations

import entity.Item
import resources.checkoutResources

class CheckoutOperations extends checkoutResources {

  def addItemsToKart(itemList: List[Item], item: Item): List[Item] = {
    item :: itemList
  }

  def removeItemsFromKart(itemList: List[Item], item: Item): List[Item] = {
    val userExist = itemList.exists(x => x.itemID == item.itemID)
    if (userExist) {
      itemList diff List(item)
    }
    else {
      throw new Exception("item does not exist ")
    }

  }

  def buyItems(itemList: List[Item]): Double = {
    val totalAmount = itemList.foldLeft(0.0)((initialSum, item) => {
      initialSum + item.price
    })
    totalAmount
  }

}
