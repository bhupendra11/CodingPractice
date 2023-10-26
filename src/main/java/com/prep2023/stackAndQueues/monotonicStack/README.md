# MONOTONIC STACK

A monotonic stack is a stack whose elements are monotonically increasing or decreasing. It contains all qualities that a typical stack has and its elements are all monotonic decreasing or increasing.

Below are the features of a monotonic stack:

* It is a range of queries in an array situation
* The minima/maxima elements
* When an element is popped from the monotonic stack, it will never be utilised again.

### The monotonic stack problem is mainly the previous/next smaller/larger problem. It maintains monotonicity while popping elements when a new item is pushed into the stack.

## Tip:
Try to store indexes in the stack rather than values, this way you have access to both indexes and values 
when required.

## Read this Gfg article for better understanding
[Monotoic stack](https://www.geeksforgeeks.org/introduction-to-monotonic-stack-data-structure-and-algorithm-tutorials/)