package librame.shared.time

import librame.shared.time.YearMonthHelpers._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers._

import java.time.YearMonth

class YearMonthHelpersSpec extends AnyFreeSpec {
  "#<" - {
    trait Setup {
      val yearMonth = YearMonth.now()
    }
    "年月1が2021年8月の場合、年月2が2021年9月の時、trueを返す" in new Setup {
      val yearMonth1 = yearMonth.withYear(2021).withMonth(8)
      val yearMonth2 = yearMonth.withYear(2021).withMonth(9)

      (yearMonth1 < yearMonth2) should be(true)
    }
    "年月1が2021年8月の場合、年月2が2021年7月の時、falseを返す" in new Setup {
      val yearMonth1 = yearMonth.withYear(2021).withMonth(8)
      val yearMonth2 = yearMonth.withYear(2021).withMonth(7)

      (yearMonth1 < yearMonth2) should be(false)
    }
    "年月1が2021年8月の場合、年月2が2021年8月の時、falseを返す" in new Setup {
      val yearMonth1 = yearMonth.withYear(2021).withMonth(8)
      val yearMonth2 = yearMonth.withYear(2021).withMonth(8)

      (yearMonth1 < yearMonth2) should be(false)
    }
  }

  "#<=" - {
    trait Setup {
      val yearMonth = YearMonth.now()
    }
    "年月1が2021年8月の場合、年月2が2021年9月の時、trueを返す" in new Setup {
      val yearMonth1 = yearMonth.withYear(2021).withMonth(8)
      val yearMonth2 = yearMonth.withYear(2021).withMonth(9)

      (yearMonth1 <= yearMonth2) should be(true)
    }
    "年月1が2021年8月の場合、年月2が2021年7月の時、falseを返す" in new Setup {
      val yearMonth1 = yearMonth.withYear(2021).withMonth(8)
      val yearMonth2 = yearMonth.withYear(2021).withMonth(7)

      (yearMonth1 <= yearMonth2) should be(false)
    }
    "年月1が2021年8月の場合、年月2が2021年8月の時、trueを返す" in new Setup {
      val yearMonth1 = yearMonth.withYear(2021).withMonth(8)
      val yearMonth2 = yearMonth.withYear(2021).withMonth(8)

      (yearMonth1 <= yearMonth2) should be(true)
    }
  }

  "#>" - {
    trait Setup {
      val yearMonth = YearMonth.now()
    }
    "年月1が2021年8月の場合、年月2が2021年9月の時、falseを返す" in new Setup {
      val yearMonth1 = yearMonth.withYear(2021).withMonth(8)
      val yearMonth2 = yearMonth.withYear(2021).withMonth(9)

      (yearMonth1 > yearMonth2) should be(false)
    }
    "年月1が2021年8月の場合、年月2が2021年7月の時、trueを返す" in new Setup {
      val yearMonth1 = yearMonth.withYear(2021).withMonth(8)
      val yearMonth2 = yearMonth.withYear(2021).withMonth(7)

      (yearMonth1 > yearMonth2) should be(true)
    }
    "年月1が2021年8月の場合、年月2が2021年8月の時、falseを返す" in new Setup {
      val yearMonth1 = yearMonth.withYear(2021).withMonth(8)
      val yearMonth2 = yearMonth.withYear(2021).withMonth(8)

      (yearMonth1 > yearMonth2) should be(false)
    }
  }

  "#>=" - {
    trait Setup {
      val yearMonth = YearMonth.now()
    }
    "年月1が2021年8月の場合、年月2が2021年9月の時、falseを返す" in new Setup {
      val yearMonth1 = yearMonth.withYear(2021).withMonth(8)
      val yearMonth2 = yearMonth.withYear(2021).withMonth(9)

      (yearMonth1 >= yearMonth2) should be(false)
    }
    "年月1が2021年8月の場合、年月2が2021年7月の時、trueを返す" in new Setup {
      val yearMonth1 = yearMonth.withYear(2021).withMonth(8)
      val yearMonth2 = yearMonth.withYear(2021).withMonth(7)

      (yearMonth1 >= yearMonth2) should be(true)
    }
    "年月1が2021年8月の場合、年月2が2021年8月の時、trueを返す" in new Setup {
      val yearMonth1 = yearMonth.withYear(2021).withMonth(8)
      val yearMonth2 = yearMonth.withYear(2021).withMonth(8)

      (yearMonth1 >= yearMonth2) should be(true)
    }
  }

  "#getMonthUntilOf" - {
    trait Setup {
      val yearMonth = YearMonth.now()
    }
    "年月1が2021年8月の場合、年月2として2021年9月が渡された時、1を返す" in new Setup {
      val yearMonth1 = yearMonth.withYear(2021).withMonth(8)
      val yearMonth2 = yearMonth.withYear(2021).withMonth(9)

      val result = yearMonth1.getMonthUntilOf(yearMonth2)
      result should be(1)
    }
    "年月1が2021年8月の場合、年月2として2021年7月が渡された時、-1を返す" in new Setup {
      val yearMonth1 = yearMonth.withYear(2021).withMonth(8)
      val yearMonth2 = yearMonth.withYear(2021).withMonth(7)

      val result = yearMonth1.getMonthUntilOf(yearMonth2)
      result should be(-1)
    }
    "2つの年月が等しい場合、0を返す" in new Setup {
      val yearMonth1 = yearMonth.withYear(2021).withMonth(8)
      val yearMonth2 = yearMonth.withYear(2021).withMonth(8)

      val result = yearMonth1.getMonthUntilOf(yearMonth2)
      result should be(0)
    }
  }
}
