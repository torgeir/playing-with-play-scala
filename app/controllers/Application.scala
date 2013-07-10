package controllers

import play.api.mvc._
import play.Logger
import java.util.Date

object Application extends Controller {

  def LoggingAction(f: Request[AnyContent] => Result): Action[AnyContent] = {
    Action {
      request =>
        Logger.info(new Date + ": Request for " + request.path)
        f(request)
    }
  }

  def index = LoggingAction {
    request => Ok(views.html.index("Your new application is ready."))
  }
}