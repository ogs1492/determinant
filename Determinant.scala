object Determinant extends App{
  def generateMatrix(dim : Int) = {
    val x = Array.ofDim[Int](dim, dim)
    for (i <- 0 until dim){
      for (j <- 0 until dim){
        x(i)(j) = (scala.math.random() * 100).asInstanceOf[Int]
      }
    }
    x
  }

  def generateMinor(i: Int, j: Int, mat: Array[Array[Int]]) = {
    val size = mat.length
    val out = Array.ofDim[Int](size-1, size-1)
    var x,y = 0
    for (r <- 0 until size ){
      if (r != i) {
        for (c <- 0 until size) {
          if (c != j) {
            out(x)(y) = mat(r)(c)
            y += 1
          }
        }
        y = 0
        x+=1
      }
    }
    out
  }

  def determinant(mat: Array[Array[Int]]): Int = {
    if (mat.length == 1){
      mat(0)(0)
    } else {
      var out = 0
      for (i <- mat.indices) {
        out = out + scala.math.pow(-1,i).asInstanceOf[Int]*mat(0)(i)*determinant(generateMinor(0, i, mat))
      }
      out
    }
  }

  def runTests( matSize: Int, iterations : Int): Unit = {
    println("Running " + matSize + "x" + matSize + " matrix " + iterations + " times")
    var time: Long = 0
    var t0: Long = 0
    var t1: Long = 0
    for (i <- 0 until iterations){
      val x = generateMatrix(matSize)
      t0 = System.currentTimeMillis()
      determinant(x)
      t1 = System.currentTimeMillis()
      time += t1 - t0
    }
    println("Total elapsed time : " + time + "ms")
    println("Average time: " + time/iterations + "ms\n")
  }


  runTests(1, 1000)
  runTests(2, 1000)
  runTests(3, 1000)
  runTests(4, 1000)
  runTests(5, 1000)
  runTests(6, 1000)
  runTests(7, 1000)
  runTests(8, 1000)
  runTests(9, 1000)
}
