Non Overlapping Disks
=====================

Your goal is to make a list of up to 50 discs, each centred on one of the provided
points. The discs should not overlap any other disc or any other point.
Each disc can have its own radius, you should try to make discs as large as you
can without them overlapping other discs or points.

The challenge is to find a list of discs with the highest possible total area.

## Usage

This project comes set up for completing the challenge.

    $ sbt
    ...
    > run

After running the project, you should see something like the following:

    Your answer is: 1,20.0,2,20.0,3,20.0,4,20.0,5,20.0,6,20.0,7,20.0,8,20.0,9,20.0,10,20.0,11,20.0,12,20.0,13,20.0,14,20.0,15,20.0,16,20.0,17,20.0,18,20.0,19,20.0,20,20.0,21,20.0,22,20.0,23,20.0,24,20.0,25,20.0,26,20.0,27,20.0,28,20.0,29,20.0,30,20.0,31,20.0,32,20.0,33,20.0,34,20.0,35,20.0,36,20.0,37,20.0,38,20.0,39,20.0,40,20.0,41,20.0,42,20.0,43,20.0,44,20.0,45,20.0,46,20.0,47,20.0,48,20.0,49,20.0,50,20.0
    The total area of your answer is: 62831.8530717959
    Open the following in your browser to see your answer
    Visualisation: file:///tmp/discs-answer.html

You can then load the visualisation file in your web-browser to look at the answer.

If you want to run the project every time the code changes you can use `~run`,
which will watch for changes and execute the `run` command each time.

    $ sbt
    ...
    > ~run

This initially provided answer is not a very good one, hopefully you'll be able
to improve on it!

## Repository layout

### DiscLogic

The [DiscLogic.scala](src/main/scala/discs/DiscLogic.scala) file contains some
example logic for the program. The provided logic is just a hard-coded answer,
you'll be able to do better!

The `workOutAnswer` function will be called by `Main.scala`, this is what should
return your answer. You should feel free to create lots of functions in this
file to split the work into simple pieces, but it's up to you how you want to go
about solving the challenge.

It also provides a function for calculating the area of a disc. This is used to
calculate the area for your answer, so best to leave this function where it is.

### models

[models.scala](src/main/scala/discs/models.scala) contains the case classes for
the project. This keeps the definitions of our types separate from our logic.

### Main

We provide an initial [Main.scala](src/main/scala/discs/Main.scala) that will run
your logic. It will use your answer to build a submission (that can be checked by
the teachers), work out the total area of your answer, and produce a visualisation
of your answer to help you with debugging.

### Visualise

[Visualise.scala](src/main/scala/discs/Visualise.scala) contains the code that
produces a visualisation of your answer.

After running the program you'll be able to view the generated visualisation in
a web browser. Click on a disc to see more information about it (the label of the
point at its centre, and its radius) at the top of the page. This information
might be helpful for debugging your submission.

## Definitions

### Point

A 2-dimensional point on our map, comprised of an `x` and `y` coordinate.

    case class Point(x: Double, y: Double)

### Disc

A circle represented by a centre point, and a radius.

    case class Circle(centre: Point, radius: Double)

The centre point must be a point that exists on the map.

A disc is valid if it does not overlap any other disc *and* it does not overlap
any other point on the map.

### Answer

An answer is a valid collection of up to 50 discs, and the radius they cover.

