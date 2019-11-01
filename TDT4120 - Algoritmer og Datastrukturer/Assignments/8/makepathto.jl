using Pkg; Pkg.add("DataStructures")
using DataStructures: Queue, enqueue!, dequeue!

mutable struct Node
    i::Int
    j::Int
    floor::Bool
    neighbors::Array{Node}
    color::Union{String,Nothing}
    distance::Union{Int,Nothing}
    predecessor::Union{Node,Nothing}
end
Node(i, j, floor=true) = Node(i, j, floor, [], nothing, nothing, nothing)

### Du skal implementere denne funksjonen ###
function makepathto(💡)
  ⚡ = Tuple{Int64, Int64}[]
  while 💡 != nothing
    pushfirst!(⚡, (💡.i,💡.j))
    💡 = 💡.predecessor
  end
  ⚡
end

### Tester ###
# Disse testene blir kjør når du kjører filen
# Du trenger ikke å endre noe her, men du kan eksperimentere!
printstyled("\n\n\n---------------\nKjører tester!!\n---------------\n"; color = :magenta)

using Test
@testset "LitenLabyrint" begin
    # maze = [0 0 0 0 0
    #         0 1 1 1 0
    #         0 1 0 0 0
    #         0 1 1 1 0
    #         0 0 0 0 0]

    nodelist = [Node(2, 2), Node(3, 2), Node(4, 2), Node(2, 3),
                Node(4, 3), Node(2, 4), Node(4, 4)]

    # startnode = nodelist[1]
    # goalnode = nodelist[7]
    nodelist[1].predecessor = nothing
    nodelist[2].predecessor = nodelist[1]
    nodelist[3].predecessor = nodelist[2]
    nodelist[4].predecessor = nodelist[1]
    nodelist[5].predecessor = nodelist[3]
    nodelist[6].predecessor = nodelist[4]
    nodelist[7].predecessor = nodelist[5]

    # Test at riktig sti returneres
    @test makepathto(nodelist[7]) ==
            [(2, 2), (3, 2), (4, 2), (4, 3), (4, 4)]

end

@testset "MiddelsLabyrint" begin
    # maze = [0 0 0 0 0 0 0
    #         0 1 1 1 1 1 0
    #         0 1 0 0 0 1 0
    #         0 1 0 1 0 1 0
    #         0 1 0 1 0 1 0
    #         0 1 1 1 0 1 0
    #         0 0 0 0 0 0 0]

    nodelist = [Node(2, 2), Node(3, 2), Node(4, 2), Node(5, 2), Node(6, 2),
                Node(2, 3), Node(6, 3), Node(2, 4), Node(4, 4), Node(5, 4),
                Node(6, 4), Node(2, 5), Node(2, 6), Node(3, 6), Node(4, 6),
                Node(5, 6), Node(6, 6)]

    # startnode = nodelist[1]
    # goalnode = nodelist[17]
    nodelist[1].predecessor = nothing
    nodelist[2].predecessor = nodelist[1]
    nodelist[3].predecessor = nodelist[2]
    nodelist[4].predecessor = nodelist[3]
    nodelist[5].predecessor = nodelist[4]
    nodelist[6].predecessor = nodelist[1]
    nodelist[7].predecessor = nodelist[5]
    nodelist[8].predecessor = nodelist[6]
    nodelist[9].predecessor = nodelist[10]
    nodelist[10].predecessor = nodelist[11]
    nodelist[11].predecessor = nodelist[7]
    nodelist[12].predecessor = nodelist[8]
    nodelist[13].predecessor = nodelist[12]
    nodelist[14].predecessor = nodelist[13]
    nodelist[15].predecessor = nodelist[14]
    nodelist[16].predecessor = nodelist[15]
    nodelist[17].predecessor = nodelist[16]

    @test makepathto(nodelist[17]) ==
            [(2, 2), (2, 3), (2, 4), (2, 5), (2, 6), (3, 6), (4, 6), (5, 6), (6, 6)]
end


println("\nFungerte alt? Prøv å kjør koden i inginious!")
println("Husk at disse testene ikke alltid sjekker alle edge-cases")
println("---------------------------------------------------------\n\n")