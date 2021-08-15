/*
 * Copyright (c) 2021 Kushiro Taichi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package librame.domain.model.util

trait Enum
trait EnumInt    extends Enum { val code: Int    }
trait EnumString extends Enum { val code: String }

object Enum {
  abstract class Of[T <: Enum] {
    val values: Seq[T]
  }
}

object EnumInt {
  abstract class Of[T <: EnumInt] extends Enum.Of[T] {
    def unsafeApply(code: Int): T         = values.find(_.code == code).get
    def apply(code: Int): Either[Unit, T] = values.find(_.code == code).toRight(())
  }
}

object EnumString {
  abstract class Of[T <: EnumString] extends Enum.Of[T] {
    def unsafeApply(code: String): T         = values.find(_.code == code).get
    def apply(code: String): Either[Unit, T] = values.find(_.code == code).toRight(())
  }
}
