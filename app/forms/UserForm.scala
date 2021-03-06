package forms

import play.api.data.Form
import play.api.data.Forms._

case class UserFormData(firstName: String, lastName: String, mobile: Long, email: String)

object UserForm {
  val form = Form(
    mapping(
      "firstName" -> nonEmptyText,
      "lastName" -> nonEmptyText,
      "mobile" -> longNumber,
      "email" -> email
    )(UserFormData.apply)(UserFormData.unapply)
  )
}
