x1 = [1.0 2.0; 2.0 3.0; 3.0 2.0; 4.0 0.0; 5.0 1.0]
x2 = [1.0 2.0; 2.0 0.0; 3.0 3.0; 4.0 4.0]
x3 = [1.0 0.0; 2.0 0.0; 2.0 0.0; 3.0 0.0; 4.0 0.0; 5.0 0.0; 5.0 0.0]

faarFeilPaa = [1.0 0.0; 2.0 0.0; 3.0 0.0; 4.0 0.0]

function binaryintervalsearch(x::Array{Float64, 2}, delta::Float64, coordinate::Int64)
  median = findMedian(x, coordinate)
  startIndex = 0
  endIndex = 0

  println("\nList: ", x)
  println("Median: ", median)
  println("Offset: ", delta)
  println("Lower Bound: ", median - delta)
  println("Upper Bound: ", median + delta)
  for k = 1:size(x, 1)
    # Set startIndex
    if x[k,coordinate] >= (median - delta) && startIndex == 0
      startIndex = k
    end

    # Set endIndex
    if x[k,coordinate] <= (median + delta)
      endIndex = k
    end
  end
  return startIndex > endIndex ? (-1, -1) : (startIndex, endIndex)
end

function findMedian(x::Array{Float64, 2}, coordinate::Int64)
  if size(x, 1) % 2 != 0
    median = x[Int(floor(size(x, 1) / 2)) + 1, coordinate]
  else
    median = (x[Int(size(x, 1) / 2), coordinate] + x[Int(size(x, 1) / 2) + 1, coordinate])/2.0
  end
  return median
end

# println("x1: ", binaryintervalsearch(x1, 1.5, 1))
# println("x2: ", binaryintervalsearch(x2, 0.25, 1))
# println("x3: ", binaryintervalsearch(x3, 1.0, 1))
println("Visstnok feil: ", binaryintervalsearch(faarFeilPaa, 0.1, 2))