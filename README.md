# Coding Interview

## Complexity Analysis

#### Big O Complexity

Big O notation is used to describe the complexity of an algorithm when measuring its efficiency, which in this case
means how well the algorithm scales with the size of the dataset.

* Other notations:
    * Big Omega: lower bound
    * Big Theta: tight bound
    * Big O: upper bound

```
T(n) = O(f(n))
```

* O(1) - Constant Complexity
    ```
    int x = 0;
    int y = 1;
    int temp = x;
    x = y;
    y = temp;
    ```
  No loop or recursive calculation.

* O(n) - Linear Complexity
    ```
    for (int i = 1; i <= n; i++) {
        x++;
    }
    ```
    * `int i = 1` takes 1 time unit
    * `i <= n, i++, x++` each takes n time unit
    * total T(1+3n) &asymp;T(n)

* O(logN) - Logarithmic Complexity
    ```
    int i = 1;
    while(i < n) {
        i = i * 2;
    }
    ```

* O(nlogN) - Linearithmic Complexity
    ```
    for(int i = 0; i <= n: i++) {
        int x = 1;
        while(x < n) {
            x = x * 2;
        }
    }
    ```
    * It loops `n` times `T(logN)`, so total is `T(nlogN)`

* O(n²) - Quadratic Complexity

```
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
        x++;
    }
}
```

* O(n3) - Cubic Complexity:
  Similar to O(n2), but consider that example with an added nested loop.

* O(2n) - Exponential Complexity:
  The algorithm takes twice as long for every new element added, so even small increases in n dramatically
* increase the running time.

#### Space Complexity

Space complexity represents the amount of memory one program uses in order to achieve its execution.

* O(1): space cost won't change when variables `x, y` vary
    ```
    int x = 0;
    int y = 0;
    x++;
    y++;
    ```
* O(n): space cost will increase along with variable `n`
    ```
    int[] newArray = new int[n];
    for (int i = 0; i < n; i++) {
        newArray[i] = i;
    }
    ```
* O(n²): 2D array

#### Sorting Algorithms

| Algorithm      | Best       | Worst       | Average     |
|----------------|------------|-------------|-------------|
| Selection Sort | Ω(n^2)     | θ(n^2)      | O(n^2)      |
| Bubble Sort    | Ω(n)       | θ(n^2)      | O(n^2)      |
| Insertion Sort | Ω(n)       | θ(n^2)      | O(n^2)      |
| Heap Sort      | Ω(nlog(n)) | θ(n log(n)) | O(n log(n)) |
| Quick Sort     | Ω(nlog(n)) | θ(n log(n)) | O(n^2)      |
| Merge Sort     | Ω(nlog(n)) | θ(n log(n)) | O(n log(n)) | 
| Bucket Sort    | Ω(n+k)     | θ(n+k)      | O(n^2)      |	               
| Radix Sort     | Ω(nk)      | θ(nk)       | O(nk)       |                 
| Count Sort     | Ω(n+k)     | θ(n+k)      | O(n+k)      |                


## Binary Search

When to use binary search (`O(log(n))`):
* sorted array
* find a better performance than `O(n)`
