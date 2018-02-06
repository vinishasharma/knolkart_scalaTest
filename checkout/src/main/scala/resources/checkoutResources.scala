package resources

import entity.Item

trait checkoutResources {

  def addItemsToKart(itemList: List[Item],item: Item): List[Item]
  def removeItemsFromKart(itemList: List[Item],item: Item): List[Item]
  def buyItems(itemList: List[Item]): Double
  }


