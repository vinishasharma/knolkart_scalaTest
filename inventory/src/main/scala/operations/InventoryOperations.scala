package operations

import entity.Item
import resources.InventoryResources

class InventoryOperations extends InventoryResources {

  def addItem(itemList: List[Item], item: Item): List[Item] = {
    val itemIdExist = itemList.exists(x => x.itemID == item.itemID)
    if (itemIdExist) {
      throw new Exception("similnar ID already exist, item can't be added")
    }
    else {
      item :: itemList
    }
  }

  def searchItems(itemList: List[Item], itemCategory: String): List[Item] = {
    val searchedItemList = itemList.filter(x => x.category == itemCategory)
    if (searchedItemList.isEmpty) {
      throw new Exception("No such category present")
    }
    else {
      searchedItemList
    }
  }

  def sortItems(itemList: List[Item], sortCriteria: String = "highToLow"): List[Item] = {
    if (sortCriteria == "highToLow") {
      itemList.sortWith((item1, item2) => item1.price > item2.price)
    }
    else {
      itemList.sortWith((item1, item2) => item1.price < item2.price)
    }
  }
}
