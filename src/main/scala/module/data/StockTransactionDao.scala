package module.data

import model.StockTransaction

trait StockTransactionDao {
  def findAll(): Option[List[StockTransaction]] 

  def save(transaction: StockTransaction): Unit

}
class StockTransactionDaoImpl extends StockTransactionDao {
  override def save(transaction: StockTransaction): Unit = ???

  override def findAll(): Option[List[StockTransaction]] = ???
}
