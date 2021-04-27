import sttp.tapir._
import sttp.tapir.json.circe._
import io.circe.generic.auto._
import sttp.tapir.docs.openapi.OpenAPIDocsInterpreter
import sttp.tapir.generic.auto._
import sttp.tapir.openapi.circe.yaml._

object Main extends App {

  case class Request(
      @description("time from") from: TimeRange,
      @description("time to") to: TimeRange,
      @description("simple field description") simpleField: String
  )

  case class TimeRange(timestamp: Int, misc: String)

  val sample =
    endpoint.post
      .in("sample")
      .in(jsonBody[Request])
      .out(stringBody)
      .errorOut(stringBody)

  val docs = OpenAPIDocsInterpreter.toOpenAPI(sample, "title", "1.0").toYaml
  println(docs)
}
