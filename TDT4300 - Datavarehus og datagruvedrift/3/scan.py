from sklearn.cluster import DBSCAN
import numpy as np

print("TDT4300 - Magnus Lauritzen Holtet & Andreas Amundsen")
x = np.array(
    [
        [1, 1],
        [14, 8],
        [6, 12],
        [3, 1],
        [5, 11],
        [13, 6],
        [4, 12],
        [12, 8],
        [1, 3],
        [8, 1],
        [5, 9],
        [10, 12],
        [14, 5],
        [2, 4],
        [8, 6],
        [4, 3],
        [12, 5],
        [14, 14],
    ]
)

db = DBSCAN(eps=2, min_samples=3).fit(x)

labels = db.labels_
cores = db.core_sample_indices_

# Not familiar with Numpy at all, so refining all lists to regular python
refined_x = []
for i in range(len(x)):
    refined_x.append([f"P{i + 1}", list(x[i])])

print("All points:")
# Extracting noisy points
noisy_points = []
for i in range(len(labels)):
    opt = f"P{i + 1} ({x[i][0]},{x[i][1]})"
    if labels[i] != -1:
        opt += "\t=> cluster " + str(labels[i] + 1)
    else:
        noisy_points.append([f"P{i + 1}", list(x[i])])
        opt += "\t=> NOISE"
    print(opt)

refined_cores = []
for i in range(len(cores)):
    refined_cores.append([f"P{cores[i] + 1}", list(x[cores[i]])])

# Remove cores from all points
print("\nCores:")
y = list.copy(refined_x)
for core in refined_cores:
    print(f"{core[0]} ({core[1][0]}, {core[1][1]})")
    y.remove(core)

# Remove noise
print("\nNoise:")
for noise in noisy_points:
    print(f"{noise[0]} ({noise[1][0]}, {noise[1][1]})")
    y.remove(noise)

# Borders
print("\nBorder points:")
for p in y:
    print(f"{p[0]} ({p[1][0]}, {p[1][1]})")
