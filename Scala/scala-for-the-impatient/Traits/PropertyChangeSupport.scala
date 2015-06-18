/* This is a utility trait that can be used by beans that support bound properties. 
It manages a list of listeners and dispatches PropertyChangeEvents to them. 

You can use an instance of this class as a member field of your bean and delegate
 these types of work to it. The PropertyChangeListener can be registered for all 
 properties or for a property specified by name.
*/
import java.beans.PropertyChangeListener
import java.beans.PropertyChangeEvent
import scala.collection.mutable.ArrayBuffer
 
trait PropertyChangeSupport {

    val listenerList = scala.collection.mutable.Map[String, PropertyChangeListener]()

    def addPropertyChangeListener(propertyName: String, listener: PropertyChangeListener) {
        listenerList(propertyName) = listener
    }

    def firePropertyChange(propertyName: String, oldValue: Any, newValue: Any) {
        new PropertyChangeEvent(this, propertyName, oldValue, newValue)
    }
}

/*
val pt = new java.awt.Point(3, 4) with PropertyChangeSupport {
    override def setLocation(x: Double, y: Double) {
      firePropertyChange("location", (getX, getY), (x, y))
      super.setLocation(x, y)
    }
  }
  */