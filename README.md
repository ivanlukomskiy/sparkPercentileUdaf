## Overview

Spark user defined aggregate function that calculates percentile with quick select algorythm.

It performs linear intepolation between adjacent ranks.

Quick select provides linear complexity of calculations.

Null values on the input are ignored.

## Benchmarking results

[Percentiles benchmarking](benchmarking_results/percentiles.md)

Other two benchmarking reports was performed on the same machine in the same conditions and can be used to compare performance with percentiles calculations:

[Quickselect benchmarking](benchmarking_results/quickselect.md)

[Quicksort benchmarking](benchmarking_results/quicksort.md)

## Tests

[Percentiles tests](src/test/scala/ru/rubbles/udaf/percentiles/PercentilesTest.scala)

## License

[Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0)

This code was developed by me during my work in [SBDA Group](http://sbdagroup.com/)