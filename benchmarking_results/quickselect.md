Measurements of time required to find percentile in the array of doubles.

Algorithm was:
* Select element with random index from array using the quick select algorithm implemented in ru.rubbles.udaf.percentiles.QuickSelect

Input data was:
* Array with certain length with random doubles from 0 to 1000
* Random generated element posistion

Each mesaured time is an average of 40 measurements.

Garbage collector working time was excluded from resulting measurement.

Each measurement was performed after the warming up.
```
BENCHMARKING RESULTS:
Size 82000, time: 2.7716751000000004 ms
Size 79500, time: 2.763121975 ms
Size 77000, time: 2.120682250000001 ms
Size 74500, time: 1.9853735500000007 ms
Size 72000, time: 2.5069738999999993 ms
Size 69500, time: 1.9395958250000003 ms
Size 67000, time: 1.6720698499999997 ms
Size 64500, time: 1.4069733750000004 ms
Size 62000, time: 1.320267225 ms
Size 59500, time: 1.7410574750000003 ms
Size 57000, time: 1.8023811249999997 ms
Size 54500, time: 1.3020449250000001 ms
Size 52000, time: 1.230933775 ms
Size 49500, time: 1.4722475 ms
Size 47000, time: 1.3840400000000004 ms
Size 44500, time: 1.3798622749999998 ms
Size 42000, time: 1.0368004750000002 ms
Size 39500, time: 0.933570625 ms
Size 37000, time: 1.0444744250000002 ms
Size 34500, time: 1.1831313249999997 ms
Size 32000, time: 2.7142331749999995 ms
Size 29500, time: 1.3276252249999998 ms
Size 27000, time: 0.9035755500000002 ms
Size 24500, time: 0.7365830250000001 ms
Size 22000, time: 1.8583019499999995 ms
Size 19500, time: 1.3307066749999998 ms
Size 17000, time: 0.8161287249999999 ms
Size 14500, time: 1.154113975 ms
Size 12000, time: 0.5196643750000001 ms
Size 9500, time: 0.48635079999999997 ms
Size 7000, time: 0.21566422499999996 ms
Size 4500, time: 0.187525875 ms
Size 2000, time: 0.18905682500000004 ms
```