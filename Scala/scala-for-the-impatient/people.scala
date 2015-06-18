class Person(val name: String) {
    override def toString(): String = getClass.getName + "[name" + name + "]"
    }

class SecretAgent(codename: String) extends Person(codename) {
    override val name = "secret"
    override val toString = "secret"
}

/* I expect..

Person has:

One private name field // also it is FINAL
One public getter
One to string

SecreAgent has:
One private final name field
One public getter giving secret
One toString method giving secret

// ALSO the toString is now PRIVATE

*/