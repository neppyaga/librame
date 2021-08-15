package librame.domain.model

import org.scalatest.FunSuite

class EntityIdTest extends FunSuite {

  case class EntityAId(value: String) extends EntityIdString
  case class EntityBId(value: String) extends EntityIdString

  test("違う型の場合等しくない") {
    val entityAId: EntityAId = EntityAId("ENTITY_A_ID")
    val entityBId: EntityBId = EntityBId("ENTITY_B_ID")

    assert(entityAId != entityBId)
  }

  test("同じ型でIdの値が等しくない") {
    val entityAId1: EntityAId = EntityAId("ENTITY_A_ID_VALUE1")
    val entityAId2: EntityAId = EntityAId("ENTITY_A_ID_VALUE2")

    assert(entityAId1 != entityAId2)
  }

  test("同じ型でIdの値が等しい") {
    val entityAId1: EntityAId = EntityAId("ENTITY_A_ID_VALUE")
    val entityAId2: EntityAId = EntityAId("ENTITY_A_ID_VALUE")

    assert(entityAId1 == entityAId2)
  }
}
