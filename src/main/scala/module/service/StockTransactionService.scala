package module.service

import java.util.UUID

import model.{ComputeResult, Stock, StockTransaction}
import module.data.StockTransactionDao
import org.joda.time.DateTime

class StockTransactionService(stockTransactionDao: StockTransactionDao) {

  def transact(stock: Stock, transactionType: String, createdBy: String): Option[String] = {
    val transactionId: String = UUID.randomUUID().toString
    stockTransactionDao.save(StockTransaction(transactionId, stock, transactionType, new DateTime(), createdBy))
    Some(transactionId)
  }

  def findAll(): Option[List[StockTransaction]] = {
    stockTransactionDao.findAll()
  }

  /**
   * Converts the value to negative if type "SELL"
   * @param transactionType
   * @param decimal
   * @return
   */
  def convert(transactionType: String, value: BigDecimal) = {
    transactionType match {
      case "BUY" => decimal
      case "SELL" => -1 * decimal
    }
  }

  /**
   * Computes profit or loss for each Stock name
   * @return
   */
  def getProfitOrLossForAllStocks(): Option[List[ComputeResult]] = {
    findAll() match {
      case Some(all) => {
        Some(all.map(p => (p.stock.name, convert(p.transactionType, (p.stock.price * p.stock.quantity * p.stock.currency.rate))))
          .groupBy(_._1).map(kv => ComputeResult(kv._1, kv._2.map(_._2).sum)).toList)
      }
      case None => None
    }
  }
}
