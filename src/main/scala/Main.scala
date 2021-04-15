import sttp.tapir._
import sttp.tapir.json.circe._
import io.circe.generic.auto._
import sttp.tapir.docs.openapi.OpenAPIDocsInterpreter
import sttp.tapir.generic.auto._
import sttp.tapir.openapi.circe.yaml._

object Main extends App {

  case class Req(
      @description("opt-field description") opt: Option[A],
      @description("notOpt-field description") notOpt: B
  )

  case class A(
      @description("a-field description") a: String
  )
  case class B(
      @description("b-field description") b: String
  )

  val sample =
    endpoint.post
      .in("sample")
      .in(jsonBody[Req])
      .out(stringBody)
      .errorOut(stringBody)

  val docs = OpenAPIDocsInterpreter.toOpenAPI(sample, "title", "1.0").toYaml
  println(docs)
}
