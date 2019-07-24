package discs


object DiscLogic {
  def workOutAnswer(points: List[Point]): List[Disc] = {
    // do some logic here instead of this (non-optimal!) hard-coded answer
    //
    // this just takes the first 15 points and arbitrarily puts a disc there
    // with a radius of `20`
    points
      .take(15)
      .map(Disc(_, 20))
  }

  // https://www.google.com/search?q=area+of+circle&oq=area+of+circle
  def areaOfDisc(disc: Disc): Double = {
    math.Pi * math.pow(disc.radius, 2)
  }
}
