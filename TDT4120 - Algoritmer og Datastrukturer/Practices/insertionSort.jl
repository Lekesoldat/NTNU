numbers = [27, 4, 12, 13, 6, 8, 9, 13, 7, 2, 33]

# 1. Select the first unsorted element.
# 2. Swap other elements to the right to create the correct position and shiftthe unsorted element.
# 3. Advance the current element to the right one element.

for j = 2 : length(numbers)
  current = numbers[j]
  i = j - 1
  while i > 0 && numbers[i] > current
    numbers[i + 1] = numbers[i]
    i = i - 1
  end
  numbers[i + 1] = current
end

println(numbers)