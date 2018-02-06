package objects

import operations.{CheckoutOperations, InventoryOperations, UserOperations}

class KnolkartObjects {

  val inventoryOperation = new InventoryOperations
  val userOperation = new UserOperations
  val checkoutOperations = new CheckoutOperations
}
