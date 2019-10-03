example = ["ccc", "cba", "ca", "ab", "abc"]

function countingsortletters(A::Array{String}, position::Int64)
    println("Input: ", A, ", postition: ", position)
    output = Array{String}(undef, size(A)) # B
    storage = zeros(26)
    
    # Loop all strings
    for string in A
        # Get value of character
        digit = chartodigit(string[position])

        # Increment occurence of digit
        storage[digit] += 1
    end

    # Sum previous with current
    for index in 2:size(storage, 1)
        storage[index] = storage[index] + storage[index - 1]
    end

    # Place in output at corret index. 
    for j in size(A, 1):-1:1
        value = Int(chartodigit(A[j][position]))

        # At the correct index, place the string
        output[Int(storage[value])] = A[j]

        # Decremt after placement
        storage[value] = storage[value] - 1
    end

    println("Output: ", output)
    return output;
end

function chartodigit(character)
    return character - '`'
end

countingsortletters(example, 2)

### Tests ###
# Disse testene blir kjør når du kjører filen
# Du trenger ikke å endre noe her, men du kan eksperimentere! 

printstyled("\n---------------\nKjører tester!!\n---------------\n"; color = :magenta)

using Test
@testset "Basic tests" begin
    @test countingsortletters(["aa", "bb", "cc"], 1) == ["aa", "bb", "cc"]
    @test countingsortletters(["cc", "bb", "aa"], 2) == ["aa", "bb", "cc"]
    @test countingsortletters(["ac", "bb", "ca"], 2) == ["ca", "bb", "ac"]
    @test countingsortletters(["ccc", "cba", "ca", "ab", "abc"], 2) == ["ca", "cba", "ab", "abc", "ccc"]
end

println("\nFungerte alt? Prøv å kjør koden i inginious!")
println("Husk at disse testene ikke alltid sjekker alle edge-cases")
println("---------------------------------------------------------\n\n")