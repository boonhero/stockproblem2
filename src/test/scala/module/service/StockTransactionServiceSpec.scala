package module.service

import mock.{MockStockDao, MockStockTransactionDao, MockUserDao}
import model.{ComputeResult, Currency, Stock, StockTransaction}
import org.joda.time.DateTime
import org.scalatest.{FlatSpec, Matchers}

class StockTransactionServiceSpec extends FlatSpec with Matchers {

  val module = new ServiceModule {
    override lazy val userDao = new MockUserDao
    override lazy val stockTransactionDao = new MockStockTransactionDao
    override lazy val stockDao = new MockStockDao
  }

  behavior of "StockTransactionService"


  it should "get no profit and no loss" in {
      module.stockTransactionDao.stockTransactions = List[StockTransaction](
        StockTransaction("T-ABC1", Stock("ABC1", "ABC", new DateTime(), 10, BigDecimal("100"), Currency("USD", 1.0)), "BUY", new DateTime(), "testId"),
        StockTransaction("T-ABC1", Stock("ABC1", "ABC", new DateTime(), 10, BigDecimal("100"), Currency("USD", 1.0)), "BUY", new DateTime(), "testId"),
        StockTransaction("T-ABC1", Stock("ABC1", "ABC", new DateTime(), 10, BigDecimal("100"), Currency("USD", 1.0)), "SELL", new DateTime(), "testId"),
        StockTransaction("T-ABC1", Stock("ABC1", "ABC", new DateTime(), 10, BigDecimal("100"), Currency("USD", 1.0)), "SELL", new DateTime(), "testId")
      )
    val result = module.stockTransactionService.getProfitOrLossForAllStocks()

    println(result.get)
  }

  it should "get multiple profit" in {
    module.stockTransactionDao.stockTransactions = List[StockTransaction](
      StockTransaction("T-ABC1", Stock("ABC1", "ABC", new DateTime(), 10, BigDecimal("100"), Currency("USD", 1.0)), "BUY", new DateTime(), "testId"),
      StockTransaction("T-ABC1", Stock("ABC1", "ABC", new DateTime(), 10, BigDecimal("100"), Currency("USD", 1.0)), "BUY", new DateTime(), "testId"),
      StockTransaction("T-XYZ1", Stock("XYZ1", "XYZ", new DateTime(), 10, BigDecimal("100"), Currency("USD", 1.0)), "BUY", new DateTime(), "testId"),
      StockTransaction("T-XYZ1", Stock("XYZ1", "XYZ", new DateTime(), 10, BigDecimal("100"), Currency("USD", 1.0)), "BUY", new DateTime(), "testId")
    )
    val result = module.stockTransactionService.getProfitOrLossForAllStocks()

    println(result.get)
  }

}
