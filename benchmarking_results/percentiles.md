Measurements of time required to find percentile in the array of doubles.

Algorithm was:
* Calculate percentile with linear interpolation on a given array
Implementation of percentile is ru.rubbles.udaf.percentiles.Percentiles

Input data was:
* Array with certain length with random doubles from 0 to 1000
* Random generated pecent

Each mesaured time is an average of 40 measurements.

Garbage collector working time was excluded from resulting measurement.

Each measurement was performed after the warming up.
```
BENCHMARKING RESULTS:
Size 82000, time: 2.650065299999999 ms
Size 79500, time: 2.004662575 ms
Size 77000, time: 2.478805875 ms
Size 74500, time: 2.0025985499999996 ms
Size 72000, time: 2.7422628 ms
Size 69500, time: 2.366193475 ms
Size 67000, time: 2.1934329750000012 ms
Size 64500, time: 1.5093635249999997 ms
Size 62000, time: 1.5234377 ms
Size 59500, time: 1.7351217249999997 ms
Size 57000, time: 1.7354376999999999 ms
Size 54500, time: 1.5677341000000002 ms
Size 52000, time: 1.9617489250000002 ms
Size 49500, time: 1.8396253999999999 ms
Size 47000, time: 1.718529075 ms
Size 44500, time: 1.8479414249999997 ms
Size 42000, time: 1.7343217750000002 ms
Size 39500, time: 1.483605575 ms
Size 37000, time: 1.1689486500000001 ms
Size 34500, time: 1.1466473249999998 ms
Size 32000, time: 0.7750620749999999 ms
Size 29500, time: 0.7344398249999999 ms
Size 27000, time: 1.105738625 ms
Size 24500, time: 0.63324465 ms
Size 22000, time: 0.8971064750000002 ms
Size 19500, time: 0.9222620999999999 ms
Size 17000, time: 1.6682771500000002 ms
Size 14500, time: 0.669343425 ms
Size 12000, time: 0.4127605500000001 ms
Size 9500, time: 0.7275657750000001 ms
Size 7000, time: 0.3289680249999999 ms
Size 4500, time: 0.28672605 ms
Size 2000, time: 0.12834574999999998 ms
```