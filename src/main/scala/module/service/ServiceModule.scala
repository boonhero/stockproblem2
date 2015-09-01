package module.service

import module.data.DataModule

trait ServiceModule extends DataModule {

  lazy val userService = new UserService(userDao, stockTransactionService, stockDao)
  lazy val stockTransactionService = new StockTransactionService(stockTransactionDao)

}
