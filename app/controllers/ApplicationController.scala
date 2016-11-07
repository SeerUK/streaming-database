package controllers

import javax.inject.Inject

import forms.UserForm
import models.User
import play.api.mvc._
import services.UserService

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Application Controller
 *
 * @author Elliot Wright <elliot@elliotwright.co>
 */
class ApplicationController @Inject() (userService: UserService) extends Controller {
  def index = Action.async { implicit request =>
    userService.listAll.map(users => {
      Ok(views.html.index(UserForm.form, users))
    })
  }

  def addUser() = Action.async { implicit request =>
    UserForm.form.bindFromRequest.fold(
      // On error
      errorForm => Future.successful(Ok(views.html.index(errorForm, Seq.empty[User]))),
      // On success
      data => {
        val newUser = User(0, data.firstName, data.lastName, data.mobile, data.email)
        userService.add(newUser).map(res => {
          Redirect(routes.ApplicationController.index())
        })
      })
  }

  def deleteUser(id: Long) = Action.async { implicit request =>
    userService.delete(id).map(res => {
      Redirect(routes.ApplicationController.index())
    })
  }
}
