package services

import javax.inject.Inject

import models.{User, UserTableDef}
import slick.backend.{DatabaseConfig, DatabasePublisher}
import slick.driver.JdbcProfile

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 * User Service
 *
 * @param dbConfig The database configuration.
 */
class UserService @Inject()(dbConfig: DatabaseConfig[JdbcProfile]) {
  import dbConfig.driver.api._

  private val users = TableQuery[UserTableDef]

  def add(user: User): Future[String] = {
    dbConfig.db.run(users += user).map(res => "User successfully added").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  def delete(id: Long): Future[Int] = {
    dbConfig.db.run(users.filter(_.id === id).delete)
  }

  def get(id: Long): Future[Option[User]] = {
    dbConfig.db.run(users.filter(_.id === id).result.headOption)
  }

  def listAll: Future[Seq[User]] = {
    dbConfig.db.run(users.result)
  }

  def streamAll: DatabasePublisher[User] = {
    dbConfig.db.stream(users.result)
  }
}
