package com.noodle.collection

import com.noodle.description.Description
import com.noodle.util.Data
import org.robolectric.annotation.Config
import org.robospock.RoboSpecification

/**
 *
 */
@Config(sdk = 21, manifest = "src/main/AndroidManifest.xml")
class InMemorySpec extends RoboSpecification {

  private InMemoryCollection<Data> inMemoryCollection
  private Description<Data> description

  void setup() {
    description = Description.of(Data)
        .withIdField("id")
        .build()

    inMemoryCollection = new InMemoryCollection<>(Data, description)
  }

  def "should add item"() {
    given:
    def a = new Data(name: 'A')

    when:
    inMemoryCollection.put(a).now()

    then:
    inMemoryCollection.dataMap.containsValue(a)

  }
}