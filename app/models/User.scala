package models

import slick.driver.MySQLDriver.api._

case class User(id: Long, firstName: String, lastName: String, mobile: Long, email: String)

class UserTableDef(tag: Tag) extends Table[User](tag, "user") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def firstName = column[String]("first_name")
  def lastName = column[String]("last_name")
  def mobile = column[Long]("mobile")
  def email = column[String]("email")

  override def * =
    (id, firstName, lastName, mobile, email) <> (User.tupled, User.unapply)
}
