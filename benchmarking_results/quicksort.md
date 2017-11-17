Measurements of time required to find percentile in the array of doubles.

Algorithm was:
1. Sort array with merge sort (Scala's array.sorted method)
2. Take element on desired posistion

Input data was:
* Array with certain length with random doubles from 0 to 1000
* Random generated element posistion

Each mesaured time is an average of 40 measurements.

Garbage collector working time was excluded from resulting measurement.

Each measurement was performed after the warming up.
```
BENCHMARKING RESULTS (Simple scala sorting)
Size 82000, time: 24.0322071 ms
Size 79500, time: 23.271920150000003 ms
Size 77000, time: 21.294428200000002 ms
Size 74500, time: 20.815000800000007 ms
Size 72000, time: 20.258595624999995 ms
Size 69500, time: 19.2296472 ms
Size 67000, time: 19.176382824999994 ms
Size 64500, time: 21.3290553 ms
Size 62000, time: 17.8009849 ms
Size 59500, time: 16.259710150000004 ms
Size 57000, time: 16.9123623 ms
Size 54500, time: 14.532390950000002 ms
Size 52000, time: 13.113012699999999 ms
Size 49500, time: 13.100834849999998 ms
Size 47000, time: 12.050266574999997 ms
Size 44500, time: 11.542819325 ms
Size 42000, time: 10.147273100000005 ms
Size 39500, time: 11.345011950000002 ms
Size 37000, time: 8.577050199999999 ms
Size 34500, time: 7.628704325000001 ms
Size 32000, time: 7.093434824999998 ms
Size 29500, time: 7.282462125 ms
Size 27000, time: 5.09500455 ms
Size 24500, time: 4.4399327 ms
Size 22000, time: 3.7678039749999988 ms
Size 19500, time: 3.296257949999999 ms
Size 17000, time: 2.837492475 ms
Size 14500, time: 3.436663025 ms
Size 12000, time: 2.3937096250000005 ms
Size 9500, time: 1.7411859499999995 ms
Size 7000, time: 1.2699659249999995 ms
Size 4500, time: 1.04703255 ms
Size 2000, time: 0.64185705 ms
```