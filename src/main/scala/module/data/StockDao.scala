package module.data

import model.Stock
import org.joda.time.DateTime

trait StockDao {
    def findBy(name: String, tradeDate: DateTime): Option[Stock]
}

class StockDaoImpl extends StockDao {
  override def findBy(name: String, tradeDate: DateTime): Option[Stock] = ???
}
