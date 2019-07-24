package discs

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

import discs.DiscLogic._

import scala.Console.{CYAN, MAGENTA, RED, RESET}


object Main {
  def main(args: Array[String]): Unit = {
    // your submission
    val answer = workOutAnswer(points)
    if (answer.length > 50) {
      println(s"${RED}A valid submission contains at most 50 discs. This answer contains ${answer.length} discs ${RESET}")
    } else {
      val totalArea = answer.map(areaOfDisc).sum
      println(s"${CYAN}Your answer is:${RESET} ${MAGENTA}${formatAnswer(answer)}${RESET}")
      println(s"${CYAN}The total area of your answer is:${RESET} ${MAGENTA}$totalArea${RESET}")

      // generate visualisation
      val html = Visualise.generateHtml(points, answer)
      val visualisationFile = s"/tmp/discs-answer.html"
      Files.write(Paths.get(visualisationFile), html.getBytes(StandardCharsets.UTF_8))
      println(s"Open the following in your browser to see your answer")
      println(s"${CYAN}Visualisation:${RESET} ${MAGENTA}file://$visualisationFile${RESET}")
    }
  }

  def formatAnswer(discs: List[Disc]): String = {
    discs
      .map(d => s"${d.centre.label},${d.radius}")
      .mkString(",")
  }

  val points = List(
    Point("1", 92.57, 968.15),
    Point("2", 425.72, 913.26),
    Point("3", 137.86, 972.97),
    Point("4", 81.63, 79.2),
    Point("5", 644.21, 170.29),
    Point("6", 776.34, 703.76),
    Point("7", 685.29, 42.83),
    Point("8", 694.47, 586.81),
    Point("9", 211.29, 922.32),
    Point("10", 720.88, 920.74),
    Point("11", 278.06, 171.42),
    Point("12", 715.71, 90.07),
    Point("13", 971.42, 816.4),
    Point("14", 738.06, 128.15),
    Point("15", 270.82, 805.11),
    Point("16", 404.26, 588.52),
    Point("17", 376.56, 587.58),
    Point("18", 769.7, 159.62),
    Point("19", 757.01, 788.3),
    Point("20", 501.59, 802.25),
    Point("21", 452.31, 841.34),
    Point("22", 60.09, 175.0),
    Point("23", 623.01, 102.18),
    Point("24", 985.09, 458.12),
    Point("25", 960.17, 184.43),
    Point("26", 731.93, 705.98),
    Point("27", 238.81, 907.27),
    Point("28", 39.18, 224.36),
    Point("29", 403.0, 149.68),
    Point("30", 749.29, 241.33),
    Point("31", 952.07, 719.88),
    Point("32", 551.94, 90.83),
    Point("33", 795.41, 745.43),
    Point("34", 410.43, 111.65),
    Point("35", 67.64, 863.6),
    Point("36", 258.78, 783.02),
    Point("37", 531.0, 543.56),
    Point("38", 557.41, 47.35),
    Point("39", 259.35, 183.28),
    Point("40", 560.36, 901.45),
    Point("41", 551.42, 605.75),
    Point("42", 817.48, 967.2),
    Point("43", 711.15, 621.36),
    Point("44", 980.81, 50.68),
    Point("45", 120.44, 991.32),
    Point("46", 762.22, 462.92),
    Point("47", 287.44, 425.33),
    Point("48", 291.75, 610.69),
    Point("49", 865.86, 784.81),
    Point("50", 294.49, 208.95),
    Point("51", 273.2, 500.22),
    Point("52", 170.97, 779.21),
    Point("53", 369.2, 231.16),
    Point("54", 683.26, 660.23),
    Point("55", 258.09, 940.34),
    Point("56", 822.18, 666.84),
    Point("57", 335.21, 283.98),
    Point("58", 226.95, 619.5),
    Point("59", 572.45, 489.73),
    Point("60", 216.29, 845.67),
    Point("61", 0.52, 831.46),
    Point("62", 847.85, 915.97),
    Point("63", 633.12, 767.93),
    Point("64", 639.34, 990.69),
    Point("65", 804.52, 234.85),
    Point("66", 776.03, 533.85),
    Point("67", 612.39, 699.61),
    Point("68", 408.52, 116.85),
    Point("69", 748.92, 417.61),
    Point("70", 859.81, 698.64),
    Point("71", 369.67, 22.78),
    Point("72", 849.24, 952.65),
    Point("73", 238.71, 867.25),
    Point("74", 894.57, 252.8),
    Point("75", 12.78, 115.27),
    Point("76", 93.51, 202.34),
    Point("77", 304.04, 481.01),
    Point("78", 519.51, 225.12),
    Point("79", 905.28, 98.02),
    Point("80", 357.24, 545.1),
    Point("81", 954.33, 922.03),
    Point("82", 928.24, 659.07),
    Point("83", 218.03, 859.54),
    Point("84", 232.99, 919.66),
    Point("85", 761.09, 867.86),
    Point("86", 565.54, 556.96),
    Point("87", 624.17, 113.85),
    Point("88", 542.49, 518.91),
    Point("89", 342.84, 645.57),
    Point("90", 618.73, 371.35),
    Point("91", 392.9, 935.86),
    Point("92", 615.08, 454.99),
    Point("93", 155.02, 347.08),
    Point("94", 198.6, 68.09),
    Point("95", 585.07, 116.82),
    Point("96", 179.41, 767.53),
    Point("97", 438.06, 843.02),
    Point("98", 287.89, 14.68),
    Point("99", 589.52, 586.66),
    Point("100", 664.61, 287.01)
  )
}
