package snippets

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.h1
import kotlinx.html.head
import kotlinx.html.p
import kotlinx.html.title

fun Application.main() {
  routing {
    get("/hello") {
      call.respondHtml {
        head {
          title { +"Ktor: html" }
        }
        body {
          h1 { +"Welcome" }
          p {
            +"Hello from Ktor html sample application"
          }
        }
      }
    }
  }
}



