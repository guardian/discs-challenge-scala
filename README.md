Non Overlapping Disks
=====================




In order to state the aim of the challenge in an easy way, let's introduce three definitions.

## Definitions

### Point

A 2-dimensional point on our map, comprised of an `x` and `y` coordinate.

    case class Point(x: Double, y: Double)

### Disc

A circle represented by a centre point, and a radius.

    case class Circle(centre: Point, radius: Double)

The centre point must be a point that exists on the map.

### Answer

An answer is a valid collection of up to 50 discs, and the radius they cover.

It should be expressed as 

* A (well defined) disc will be said to be valid, if it contains no other point of the map than its center. In other words, to be valid, the radius of the disk has to be smaller than the distance between the center of the disk and any other point of the map.

A collection of disks is said to be valid if each of its disks is valid and the disks do not overlap (pairwise). In other words the distance between the center of any two disks of the collection has to be smaller than the sum of their radii.

We also add the additional condition that your collection can have at most 50 disks (half of the number of points on the map).

The aim of the challenge is to come up with the biggest collection of valid disks. To make that more precise, we need two more definitions

The value of a disk is the square of its radius. (This was chosen so that the value is proportional to the surface area of the disk).

The value of a valid collection is the sum of values of the disks of the collection.

You are after a collection of maximal value.