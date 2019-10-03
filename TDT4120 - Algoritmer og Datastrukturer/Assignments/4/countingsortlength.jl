example = ["bbbb", "aa", "aaaa", "ccc", ""]
function countingsortlength(A)
    println("Input: ", A)
    output = Array{String}(undef, length(A)) # B
    storage = zeros(250) # C, just a big amount

    # Place every string with a offset of 1, - julia is 1-index so length 0 must be at 1
    for string in A
        storage[length(string) + 1] += 1
    end

    # Sum the occurences
    for i in 2:length(storage)
        storage[i] = storage[i] + storage[i - 1]
    end

    # Place in output at corret index. 
    for j in length(A):-1:1
        # Add the offset in case of empty string
        len = Int(length(A[j])) + 1

        output[Int(storage[len])] = A[j]
        storage[len] = storage[len] - 1
    end

    println("Output: ", output)
    return output
end

countingsortlength(example)

### Tests ###
# Disse testene blir kjør når du kjører filen
# Du trenger ikke å endre noe her, men du kan eksperimentere! 
printstyled("\n---------------\nKjører tester!!\n---------------\n"; color = :magenta)

using Test
@testset "Basic tests" begin
    @test countingsortlength(["ccc", "bb", "a"]) == ["a", "bb", "ccc"]
    @test countingsortlength(["aaa", "bb", "c"]) == ["c", "bb", "aaa"]
    @test countingsortlength(["bb", "a", ""]) == ["", "a", "bb"] # Testen her sjekker om du kan sortere også med emtpy string
    @test countingsortlength(["bbbb", "aa", "aaaa", "ccc"]) == ["aa", "ccc", "bbbb", "aaaa"] # Fra oppgaven
end

println("\nFungerte alt? Prøv å kjør koden i inginious!")
println("Husk at disse testene ikke alltid sjekker alle edge-cases")
println("---------------------------------------------------------\n\n")