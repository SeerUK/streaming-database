import com.google.inject._
import play.api.db.slick.DatabaseConfigProvider
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile

/**
 * This class is a Guice module that tells Guice how to bind several
 * different types. This Guice module is created when the Play
 * application starts.
 *
 * Play will automatically use any class called `Module` that is in
 * the root package. You can create modules in other locations by
 * adding `play.modules.enabled` settings to the `application.conf`
 * configuration file.
 */
class Module extends AbstractModule {
  override def configure() = {}

  @Provides
  def provideDbConfig(dbConfigProvider: DatabaseConfigProvider): DatabaseConfig[JdbcProfile] = {
    dbConfigProvider.get[JdbcProfile]
  }
}
