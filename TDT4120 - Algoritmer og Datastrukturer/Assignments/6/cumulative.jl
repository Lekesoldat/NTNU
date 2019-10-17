### Du skal implementere denne funksjonen ###
function cumulative(weights)
  rows, cols = size(weights)
  # Start at the second row, as the first wont change
  for row = 2:rows
    for col = 1:cols
      # Left edge
      if col == 1
        weights[row, col] = weights[row, col] + min(weights[row-1, col], weights[row-1, col + 1])
      # Right edge
      elseif col == size(weights[row, :], 1)
        weights[row, col] = weights[row, col] + min(weights[row-1, col - 1], weights[row-1, col])
      # In between
      else
        weights[row, col] = weights[row, col] + min(weights[row-1, col - 1], weights[row-1, col], weights[row-1, col + 1])
      end
    end
  end
  return weights;
end

### Tester ###
# Disse testene blir kjør når du kjører filen
# Du trenger ikke å endre noe her, men du kan eksperimentere!

printstyled("\n\n\n---------------\nKjører tester!!\n---------------\n"; color = :magenta)

using Test
@testset "Tester" begin
	@test cumulative([1 1 ; 1 1]) == [1 1 ;2 2]
    #Dette er samme eksempel som det vist i oppgaveteskten
	@test cumulative([3  6  8 6 3; 7  6  5 7 3; 4  10 4 1 6; 10 4  3 1 2;6  1  7 3 9])== [3  6  8  6  3;10 9  11 10 6;13 19 13 7  12;23 17 10 8  9;23 11 15 11 17]
end


println("\nFungerte alt? Prøv å kjør koden i inginious!")
println("Husk at disse testene ikke alltid sjekker alle edge-cases")
println("---------------------------------------------------------\n\n")