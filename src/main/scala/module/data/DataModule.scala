package module.data

import module.service.{StockTransactionService, UserService}

trait DataModule {

  lazy val stockDao: StockDao = new StockDaoImpl
  lazy val stockTransactionDao: StockTransactionDao = new StockTransactionDaoImpl
  lazy val userDao: UserDao = new UserDaoImpl
}
