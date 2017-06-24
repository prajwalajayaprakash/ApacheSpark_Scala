// EXERCISE

  // Strings have a built-in .toUpperCase method. For example, "foo".toUpperCase gives you back FOO.
  // Write a function that converts a string to upper-case, and use that function of a few test strings.
  // Then, do the same thing using a function literal instead of a separate, named function.
  def upper(s : String) : String = {s.toUpperCase}//> upper: (s: String)String
  def upString(s: String, f: String => String) : String = { f(s) }
                                                  //> upString: (s: String, f: String => String)String
  val result2 = upString("foo", upper )           //> result2  : String = FOO
  println(result2)                                //> FOO
  upString("prajwala", s => s.toUpperCase)        //> res3: String = PRAJWALA
}