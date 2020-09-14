package snippets

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.routing.*
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



