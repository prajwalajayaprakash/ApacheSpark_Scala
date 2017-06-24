// EXERCISE

  // Create a list of the numbers 1-20; your job is to print out numbers that are evenly divisible by three. (Scala's
  // modula operator, like other languages, is %, which gives you the remainder after division. For example, 9 % 3 = 0
  // because 9 is evenly divisible by 3.) Do this first by iterating through all the items in the list and testing each
  // one as you go. Then, do it again by using a filter function on the list instead.
  val numberList2 = List(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
                                                  //> numberList2  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 
                                                  //| 14, 15, 16, 17, 18, 19, 20)
  for (number2 <- numberList2){if (number2 % 3 == 0){println(number2)}}
                                                  //> 3
                                                  //| 6
                                                  //| 9
                                                  //| 12
                                                  //| 15
                                                  //| 18
  val divisibleBy3 = numberList2.filter((y: Int) => y%3 == 0)
                                                  //> divisibleBy3  : List[Int] = List(3, 6, 9, 12, 15, 18)