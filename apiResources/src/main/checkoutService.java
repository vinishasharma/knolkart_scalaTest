trait checkoutService {

  def addItemsToKart(item: Item , itemsInKart = List(Item) = Nil) : List(Item)
  def removeItemsInKart(item: Item, itemsInKart = List(Item)): List(Item)
  def purchaseItems(itemsInKart: List(Item), UserInfo : User) : Bill

}
