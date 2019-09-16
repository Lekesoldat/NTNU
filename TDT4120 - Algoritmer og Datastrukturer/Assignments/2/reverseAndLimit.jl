myArray = [1, 8, 3, 6, 9, 11, 30, 44, 10]

function reverseandlimit(array, maxnumber)
  array = reverse(array)
  for i = 1:length(array)
      if array[i] > maxnumber
          array[i] = maxnumber
      end
  end
  return array
end

reverseandlimit(myArray, 10)