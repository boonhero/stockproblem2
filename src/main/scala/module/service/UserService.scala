package module.service

import model.{User, Stock}
import module.data.{StockDao, UserDao}
import org.joda.time.DateTime

class UserService(userDao: UserDao, stockTransactionService: StockTransactionService, stockDao: StockDao) {

    /**
     * Sell stock, remove the stock from user, get a new stock on the market to update price and sell it.
     *
     * @param stock
     * @param userId
     * @return
     */
    def sell(stock: Stock, userId: String): Option[String] = {
        getUser(userId) match {
            case Some(user) => {
                user.removeStock(stock._id)
                userDao.update(user)
                stockDao.findBy(stock.name, new DateTime()) match {
                    case newStock => stockTransactionService.transact(stock, "SELL", user.name)
                    case None => None
                }

            }
            case None => None
        }
    }


    def buy(stock: Stock, userId: String): Option[String] = {
        getUser(userId) match {
            case Some(user) => {
                user.addStock(stock)
                userDao.update(user)
                stockTransactionService.transact(stock, "BUY", user.name)
            }
            case None => None
        }
    }

    def getUser(name: String): Option[User] = {
        userDao.find(name)
    }
}
