numbers = [27, 4, 12, 13, 6, 8, 9, 13, 7, 2, 33]

# 1. Select the first unsorted element.
# 2. Swap other elements to the right to create the correct position and shiftthe unsorted element.
# 3. Advance the current element to the right one element.

function sort!(list)
  # Starting at second element
  for j = 2 : length(list)
    current = list[j]

    # Keep index of element left of the current one
    i = j - 1

    # i > 0 => check if start of list
    # list[i] > current => where in the list 'current' fits
    while i > 0 && list[i] > current
      list[i + 1] = list[i]
      i = i - 1
    end

    # Place element
    list[i + 1] = current
  end
end

function run()
  println(numbers)

  sort!(numbers)

  println(numbers)
end

run()