x = [1.0 1.0; 10.0 0.0; 2.0 2.0; 5.0 5.0]

function bruteforce(x::Array{Float64, 2})
  shortestDistance::Float64 = Inf
  j::Int64 = 1
  for i = 1:size(x, 1) - 1
    for j = i + 1 :size(x, 1)
      distance = calculateDistance(x[i, :], x[j, :])
      if shortestDistance >= distance
        shortestDistance = distance
      end
    end
  end

  return shortestDistance
end

function calculateDistance(one, two)
  # √((x2 - x1)^2 + (y2 - y1)^2) 
  return sqrt((two[1]-one[1])^2 + (two[2]-one[2])^2)
end

println("Shortest distance: ", bruteforce(x))
