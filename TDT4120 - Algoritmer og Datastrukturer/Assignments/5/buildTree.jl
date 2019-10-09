### Denne må med når en tester lokalt ###
# (try-catch er bare for å unngå feilmelding om redefinition of constant struct)
try
   	mutable struct Node
       	children::Dict{Char,Node}
       	count::Int
   	end
catch
   	println("Node() allerede definert")
end
Node() = Node(Dict(), 0)

### Denne funksjonen overlagrer/definerer likhet for Node-objektet
import Base: ==
(==)(a::Node, b::Node) = a.count == b.count && a.children == b.children

### Du skal implementere denne funksjonen ###
function buildtree(dnasequences)
    root = Node()
    # Alle sekvenser har den tomme strengen som prefix:
    root.count = length(dnasequences)

    # Din kode

    return root
end

### Konstruert testdata, la stå ###
dnasequences1 = ["A"]
dnasequences2 = ["A", "T", "C", "G"]
dnasequences3 = ["AG", "AGT", "AGTA", "AGTT", "AGTC"]
dnasequences4 = vcat(dnasequences1, dnasequences2, dnasequences3)

tree1 = Node(Dict('A' => Node(Dict{Char,Node}(), 1)), 1)
tree2 = Node(Dict('A' => Node(Dict{Char,Node}(), 1), 'G' => Node(Dict{Char,Node}(), 1), 'T' => Node(Dict{Char,Node}(), 1), 'C' => Node(Dict{Char,Node}(), 1)), 4)
tree3 = Node(Dict('A' => Node(Dict('G' => Node(Dict('T' => Node(Dict('A' => Node(Dict{Char,Node}(), 1), 'T' => Node(Dict{Char,Node}(), 1), 'C' => Node(Dict{Char,Node}(), 1)), 4)), 5)), 5)), 5)
tree4 = Node(Dict('A' => Node(Dict('G' => Node(Dict('T' => Node(Dict('A' => Node(Dict{Char,Node}(), 1), 'T' => Node(Dict{Char,Node}(), 1), 'C' => Node(Dict{Char,Node}(), 1)), 4)), 5)), 7), 'G' => Node(Dict{Char,Node}(), 1), 'T' => Node(Dict{Char,Node}(), 1), 'C' => Node(Dict{Char,Node}(), 1)), 10)

### Tester ###
# Disse testene blir kjør når du kjører filen
# Du trenger ikke å endre noe her, men du kan eksperimentere!

printstyled("\n\n\n---------------\nKjører tester!!\n---------------\n"; color = :magenta)

using Test
@testset "Tester" begin
   	@test buildtree(dnasequences1) == tree1
   	@test buildtree(dnasequences2) == tree2
   	@test buildtree(dnasequences3) == tree3
   	@test buildtree(dnasequences4) == tree4
end

println("\nFungerte alt? Prøv å kjør koden i inginious!")
println("Husk at disse testene ikke alltid sjekker alle edge-cases")
println("---------------------------------------------------------\n\n")