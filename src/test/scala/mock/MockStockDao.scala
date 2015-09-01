package mock

import model.{Currency, Stock}
import module.data.StockDao
import org.joda.time.DateTime

/**
 * Created by asales on 1/9/2015.
 */
class MockStockDao extends StockDao {
  var stocks = List[Stock] (Stock("AB01", "ABC", new DateTime(), -1, 50, Currency("USD", 1.0)))

  override def findBy(name: String, tradeDate: DateTime): Option[Stock] = {
    stocks.filter(p => p.name.equals(name)).filter(p => p.tradeDate.withTimeAtStartOfDay().isEqual(tradeDate.withTimeAtStartOfDay())) match {
      case stock :: Nil => Some(stock)
      case Nil => None
    }
  }
}
