package resources

import entity.Item

trait InventoryResources {

  def addItem(itemList: List[Item], item: Item): List[Item]

  def searchItems(itemList: List[Item], category: String): List[Item]

  def sortItems(itemList: List[Item], criteria: String): List[Item]

}
