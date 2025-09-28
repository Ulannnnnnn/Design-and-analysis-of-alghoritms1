# Divide and Conquer Algorithms in Java

## 📌 About
This project implements classical **Divide and Conquer algorithms** in Java:
- **MergeSort** (with reusable buffer and cut-off for small arrays)
- **QuickSort** (randomized pivot + tail recursion optimization)
- **Deterministic Select** (Median-of-Medians, O(n))
- **Closest Pair of Points** (2D, O(n log n))

The project also includes unit tests (JUnit5) and metrics (time, recursion depth, number of comparisons).

---

## 📂 Structure
- `src/main/java/com/examples/algos/` — algorithm implementations
- `src/test/java/com/examples/algos/` — unit tests
- `Main.java` — demo and simple benchmarks
- `Metrics.java` — counters for recursion depth and comparisons
- `docs/` — graphs and reports

---

## 🔬 Theoretical Analysis

| Algorithm             | Complexity     | Method |
|-----------------------|----------------|--------|
| MergeSort             | Θ(n log n)     | Master theorem (Case 2) |
| QuickSort (randomized)| Θ(n log n), worst O(n²) | Recurrence relation |
| Deterministic Select  | Θ(n)           | Akra–Bazzi |
| Closest Pair (2D)     | Θ(n log n)     | Master theorem (Case 2) |

---

## 📊 Experimental Results

Performance was measured on random arrays.

| Array size | MergeSort (ms) | QuickSort (ms) | Select (ms) |
|------------|----------------|----------------|-------------|
| 1000       | 2.1            | 1.7            | 0.4         |
| 5000       | 11.5           | 8.3            | 3.2         |
| 10000      | 23.4           | 15.7           | 6.5         |
| 50000      | 121.0          | 84.2           | 33.1        |

---

## 📈 Graphs

### Execution time
![Execution time](docs/performance.png)

### Theory vs Practice
![Theory vs Practice](docs/complexity.png)

---

## ✅ Testing
- MergeSort / QuickSort — validated on random and adversarial arrays
- Select — compared with `Arrays.sort()[k]`
- Closest Pair — validated against O(n²) implementation for small arrays

---

## 🚀 Run
```bash
# Clone repository
git clone https://github.com/yourname/algorithms.git

# Move into folder
cd algorithms

# Build
mvn clean install

# Run demo
mvn exec:java -Dexec.mainClass="com.examples.algos.Main"
