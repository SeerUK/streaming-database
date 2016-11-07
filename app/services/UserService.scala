package services

import models.{User, Users}
import slick.backend.DatabasePublisher

import scala.concurrent.Future

object UserService {
  def addUser(user: User): Future[String] = {
    Users.add(user)
  }

  def deleteUser(id: Long): Future[Int] = {
    Users.delete(id)
  }

  def getUser(id: Long): Future[Option[User]] = {
    Users.get(id)
  }

  def listAllUsers: Future[Seq[User]] = {
    Users.listAll
  }

  def streamAllUsers: DatabasePublisher[User] = {
    Users.streamAll
  }
}
