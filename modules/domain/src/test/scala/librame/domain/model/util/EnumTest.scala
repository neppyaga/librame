package librame.domain.model.util

import org.scalatest.FunSuite

class EnumTest extends FunSuite {

  sealed abstract class IntStatus(val code: Int) extends EnumInt
  object IntStatus                               extends EnumInt.Of[IntStatus] {
    case object TODO        extends IntStatus(code = 0)
    case object IN_PROGRESS extends IntStatus(code = 1)
    case object DONE        extends IntStatus(code = 2)

    val values: Seq[IntStatus] = Seq(TODO, IN_PROGRESS, DONE)
  }

  test("EnumInt: get instance") {
    import IntStatus._

    assertResult(Right(TODO))(IntStatus(0))
    assertResult(Right(IN_PROGRESS))(IntStatus(1))
    assertResult(Right(DONE))(IntStatus(2))
  }

  test("EnumInt: not found code") {
    assertResult(Left())(IntStatus(-1))
    assertResult(Left())(IntStatus(3))
  }

  sealed abstract class StringStatus(val code: String) extends EnumString
  object StringStatus                                  extends EnumString.Of[StringStatus] {
    case object TODO        extends StringStatus(code = "TODO")
    case object IN_PROGRESS extends StringStatus(code = "IN_PROGRESS")
    case object DONE        extends StringStatus(code = "DONE")

    val values: Seq[StringStatus] = Seq(TODO, IN_PROGRESS, DONE)
  }

  test("EnumString: get instance") {
    import StringStatus._

    assertResult(Right(TODO))(StringStatus("TODO"))
    assertResult(Right(IN_PROGRESS))(StringStatus("IN_PROGRESS"))
    assertResult(Right(DONE))(StringStatus("DONE"))
  }

  test("EnumString: not found code") {
    assertResult(Left())(StringStatus("failed"))
  }
}
