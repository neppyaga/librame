package librame.shared.time

import java.time.YearMonth
import java.time.temporal.ChronoUnit

trait YearMonthHelpers {
  implicit class RichYearMonth(yearMonth: YearMonth) {
    def <(that: YearMonth): Boolean =
      yearMonth.isBefore(that)

    def <=(that: YearMonth): Boolean =
      yearMonth.isBefore(that) || yearMonth.equals(that)

    def >(that: YearMonth): Boolean =
      yearMonth.isAfter(that)

    def >=(that: YearMonth): Boolean =
      yearMonth.isAfter(that) || yearMonth.equals(that)

    def diffOfMonth(that: YearMonth): Int =
      ChronoUnit.MONTHS.between(yearMonth, that).toInt
  }
}

object YearMonthHelpers extends YearMonthHelpers
