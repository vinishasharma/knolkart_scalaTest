package entity

case class Item(itemID: Int, itemName: String,itemCount: Int, price: Float, category: String, vendorInfo: String , description: String) {
  override def toString: String = {
    s"\nitem ID: $itemID \nitem name: $itemName \nitem count: " +
      s"$itemCount\ncategory: $category\nprice: $price \nitem vendor: $vendorInfo\ndescription: $description\n"
  }

}
