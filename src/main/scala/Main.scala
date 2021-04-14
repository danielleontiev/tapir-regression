import sttp.tapir._
import sttp.tapir.json.circe._
import io.circe.generic.auto._
import sttp.tapir.docs.openapi.OpenAPIDocsInterpreter
import sttp.tapir.generic.auto._
import sttp.tapir.openapi.circe.yaml._

object Main extends App {

  /*

  There are only 'skip'ped commits left to test.
  The first bad commit could be any of:
  eda45eb7f8aafe81be95e5985179a49803218c61
  fa035ca08749391dcf7309757d5e7e54d3f49876
  31db616960b13cd355a79846f5f0a316d3e8b8b7
  e19e13ebefac37b5ac9ffaeab895f0dd42ee8eed
  15ba46326f6827a756feb47475419347be31a6a7
  28050b58af8a489a089349b5478c6b34b6052c88
  433a99c3300114882b1cc2f6390551d468ed721c
  49750e5987e7dbe40a443ede2bc85a8639827de4
  9df5cabadc68e2f6400855f77f8f3c2f6de4e962
  We cannot bisect more!


   */

  case class Req(
      opt: Option[A],
      notOpt: B
  )

  case class A(a: String)
  case class B(b: String)

  val sample =
    endpoint.post
      .in("sample")
      .in(jsonBody[Req])
      .out(stringBody)
      .errorOut(stringBody)

  val docs = OpenAPIDocsInterpreter.toOpenAPI(sample, "title", "1.0").toYaml
  println(docs)
}
