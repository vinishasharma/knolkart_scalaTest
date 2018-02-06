package operations

import entity.Item
import resources.checkoutResources

class CheckoutOperations extends checkoutResources{

  def addItemsToKart(itemList: List[Item],item: Item): List[Item] ={
    item :: itemList
  }
  def removeItemsFromKart(itemList: List[Item],item: Item): List[Item]={
    itemList diff List(item)
  }
  def buyItems(itemList: List[Item]): Double = {
    val totalAmount = itemList.foldLeft(0.0)((initialSum, item) => {
      initialSum + item.price
    })
    totalAmount
  }

}
