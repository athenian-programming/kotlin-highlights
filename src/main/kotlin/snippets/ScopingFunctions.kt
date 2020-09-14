package snippets

class Rectangle() {
  var width = 0
  var height = 0
  fun fill(color: Int) {}
  fun adjust() {}
  fun area(): Int {
    return 0
  }
}

fun main() {

  val myRectangle1 = Rectangle()
  myRectangle1.width = 4
  myRectangle1.height = 5
  myRectangle1.fill(0xFAFAFA)
  myRectangle1.adjust()

  val myRectangle2 =
    Rectangle()
      .apply {
        width = 4
        height = 5
        fill(0xFAFAFA)
        adjust()
      }

}


fun main2() {

  val myRectangle1 = Rectangle()
  myRectangle1.width = 4
  myRectangle1.height = 5
  myRectangle1.fill(0xFAFAFA)
  myRectangle1.adjust()
  val area1 = myRectangle1.area()

  val area2 =
    Rectangle()
      .run {
        width = 4
        height = 5
        fill(0xFAFAFA)
        adjust()
        area()
      }

}




