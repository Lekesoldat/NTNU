# Merge sort for a two dimmentional array with coordinates

# For testing purposes
AsortedOnX = [1 2; 2 1; 4 6; 5 5]
BsortedOnX = [3 5; 8 2; 11 4; 12 5]

AsortedOnY = [2 1; 1 2; 4 6]
BsortedOnY = [1 3; 4 4; 6 5; 2 7]

unsorted = [2.0 1.0; 1.0 5.0; 3.0 9.0; 11.0 4.0; 5.0 25.0; 3.0 11.0; 8.0 7.0; 3.0 4.0; 11.0 2.0; 6.0 3.0; 3.0 5.0]
############################

function mergearrays(left::Array{Float64,2}, right::Array{Float64,2}, coordinate::Int64)
    resultArray::Array{Float64,2} = Array{Float64,2}(undef, size(left, 1) + size(right, 1), 2)
    li::Int64 = 1
    ri::Int64 = 1
    i::Int64 = 1

    # Looper til en av listene tømmes
    @inbounds while li <= size(left, 1) && ri <= size(right, 1)
      if left[li, coordinate] <= right[ri, coordinate]
        resultArray[i,:] = left[li,:]
        li += 1
      else
        resultArray[i,:] = right[ri, :]
        ri +=  1
      end
      i += 1
    end
    
    # En av listene er tømt, enten har left igjen, ellers har right igjen
    if  li <= size(left, 1)
      # Print siste elementene fra left
      for k = li: size(left, 1)
        resultArray[i,:] = left[li, :]
        li += 1
        i += 1
      end
    
    elseif ri <= size(right, 1)
      # Print siste elementene fra right
      for k = ri: size(right, 1)
        resultArray[i,:] = right[ri, :]
        ri += 1
        i += 1
      end
    end
    return resultArray
end

function mergesort(x::Array{Float64, 2}, coordinate::Int64)
  # Base case
  if size(x, 1) <= 1
    return x
  end
  
  # Finner midten
  mid = Int(floor(size(x, 1)/2))

  # Sort left
  left = mergesort(x[1:mid, 1:2], coordinate)

  # Sort right
  right = mergesort(x[mid + 1:size(x, 1), 1:2], coordinate)

  # Merge
  return mergearrays(left, right, coordinate)
end

println("Before: ", unsorted)
println("After: ", mergesort(unsorted, 1))