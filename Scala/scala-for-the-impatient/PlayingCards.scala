
object PlayingCards extends Enumeration {

    val Diamond = Value(1, "Diamond")
    val Clubs = Value(2, "Clubs")
    val Hearts = Value(3, "Hearts")
    val Ace = Value(4, "Ace")
}

def isRed(card: PlayingCards) : Boolean = {
    if (card.id % 2 == 1) 
    {true} 
    else 
    {false}
}   