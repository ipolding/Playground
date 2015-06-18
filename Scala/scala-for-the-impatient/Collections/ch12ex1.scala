    // Write a function that, given a string, produces a map of the indexes of all characters
    // index("Mississippi")

        def indexes(word: String) : scala.collection.mutable.Map[Char, scala.collection.mutable.SortedSet[Int]] = {
            val count = scala.collection.mutable.Map[Char,scala.collection.mutable.SortedSet[Int]]()
            var index = 0
            for(c <- word) {
                count(c) = count.getOrElse(c, scala.collection.mutable.SortedSet[Int]()) + index 
                index += 1
            }
            count
        }