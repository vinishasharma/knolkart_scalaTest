package operations

import entity.Item
import org.apache.log4j.Logger
import scala.io.StdIn
import resources.InventoryResources

class InventoryOperations extends InventoryResources {

  val log = Logger.getLogger(this.getClass)

  def addItem(itemList: List[Item]): List[Item] = {
    log.info("\nEnter item ID\n")
    val itemId = StdIn.readLine().toInt
    val itemIdExist = itemList.exists(x => x.itemID == itemId)
    if (itemIdExist) {
      log.info("similar ID already exist")
      itemList
    }
    else {
      log.info("\nEnter item name\n")
      val itemName = StdIn.readLine().toString
      log.info("\nEnter item count\n")
      val itemCount = StdIn.readLine().toInt
      log.info("\nEnter item price\n")
      val itemPrice = StdIn.readLine().toFloat
      log.info("\nEnter item vendor Info\n")
      val vendorInfo = StdIn.readLine().toString
      log.info("\nEnter item description\n")
      val description = StdIn.readLine().toString
      log.info("\nEnter item category\n")
      val category = StdIn.readLine().toString
      val newItem = Item(itemId, itemName, itemCount, itemPrice, category, vendorInfo, description)
      val updatedItemList = itemList :+ newItem
      updatedItemList
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

  def sortItems(itemList: List[Item], sortCriteria: String = "high to low"): List[Item] = {
    if (sortCriteria == "high to low") {
      itemList.sortWith((item1, item2) => item1.price > item2.price)
    }
    else {
      itemList.sortWith((item1, item2) => item1.price < item2.price)
    }

  }


}
