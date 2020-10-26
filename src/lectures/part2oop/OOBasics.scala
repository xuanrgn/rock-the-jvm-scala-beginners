package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 23)
  println(person.x)
  person.greet("Argyn")
  person.greek()


  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
}


// constructor
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2

  println("Person class init...")

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greek() = println(s"Hi, I am $name")

  // multiple constructors
  def this(name: String) = this(name, 0)

  def this() = this("Argyn Khuan")

}

/*
  Novel and a Writer

  Writer: name, surname, year
    - method fullName

  Novel: name, year of release, author
    - authorAge
    - isWrittenBy(author)
    - copy (new year of release) = new instance of Novel
 */


class Writer(firstName: String, surname: String, val year: Int) {
  def fullName(): String = firstName + " " + surname
}

class Novel(name: String, year: Int, author: Writer) {

  def authorAge: Int = year - author.year

  def isWrittenBy(author: Writer): Boolean = this.author == author

  def copy(newYear: Int): Novel = new Novel(name, newYear, author)

}

/*
  Counter class
    - receives an Int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
*/


// class parameters are NOT FIELDS