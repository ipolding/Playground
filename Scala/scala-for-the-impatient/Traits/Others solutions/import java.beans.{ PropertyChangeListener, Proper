import java.beans.{ PropertyChangeListener, PropertyChangeEvent }

object PropertyChangeSupport {
  import scala.language.implicitConversions

  // make the interface a bit more scalaesque while we're at it
  implicit def function2PropertyChangeListener(fn: (PropertyChangeEvent => Unit)) = new PropertyChangeListener {
    override def propertyChange(ev: PropertyChangeEvent) { fn.apply(ev) }
  }

  implicit class PropertyChangeEventScala(x: PropertyChangeEvent) {
    def source = x.getSource
    def propertyName = x.getPropertyName
    def oldValue = x.getOldValue
    def newValue = x.getNewValue
  }

  trait PropertyChangeSupport {
    private var listeners = Map[String, Set[PropertyChangeListener]]() withDefaultValue Set()

    // make the interface a bit more scalaesque while we're at it
    def addPropertyChangeListener(propertyName: String)(listener: PropertyChangeListener) {
      listeners += propertyName -> (listeners(propertyName) + listener)
    }

    def firePropertyChange(propertyName: String, oldValue: Any, newValue: Any) {
      val ev = new PropertyChangeEvent(this, propertyName, oldValue, newValue)
      listeners(propertyName).foreach(_.propertyChange(ev))
    }
  }
}

object Main extends App {
  import PropertyChangeSupport._

  val pt = new java.awt.Point(3, 4) with PropertyChangeSupport {
    override def setLocation(x: Double, y: Double) {
      firePropertyChange("location", (getX, getY), (x, y))
      super.setLocation(x, y)
    }
  }

  pt.addPropertyChangeListener("location") { ev: PropertyChangeEvent =>
    println(ev.source + "." + ev.propertyName + " changed from " + ev.oldValue + " to " + ev.newValue)
  }
  pt.setLocation(4.0, 5.0)
}