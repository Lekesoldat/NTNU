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

myMaze = [
  0 0 0 0 0
  0 1 1 1 0
  0 1 0 0 0
  0 1 1 1 0
  0 0 0 0 0
]

### Du skal implementere denne funksjonen ###
function mazetonodelist(maze)
  # For all ones, create a node.
  myNodes = [Node(element.I...) for element in findall(==(1), maze)]

  # Traverse all nodes
  for node in myNodes
    # For each node, check if other nodes are adjacent aka neighbors
    neighbors = filter(x -> isone(abs(node.i - x.i) + abs(node.j - x.j)), myNodes)
    append!(node.neighbors, neighbors)
  end

  return myNodes
end

mazetonodelist(myMaze);


### Tester ###
# Disse testene blir kjør når du kjører filen
# Du trenger ikke å endre noe her, men du kan eksperimentere!

# (Følgende er hjelpefunksjoner for testene og kan i utgangspunktet ignoreres)
function sortnodelist(nodelist)
    sort!(sort!(nodelist, by=node->node.i), by=node->node.j)
end

function getcoords(nodelist)
    return [(node.i, node.j) for node in nodelist]
end

function getneighborcoords(nodelist)
    return [sort(sort(
               [(neighbor.i, neighbor.j) for neighbor in node.neighbors],
            by = x -> x[1]), by = x -> x[2])
            for node in nodelist]
end

printstyled("\n\n\n---------------\nKjører tester!!\n---------------\n"; color = :magenta)

using Test
@testset "LitenLabyrint" begin
    maze = [0 0 0 0 0
            0 1 1 1 0
            0 1 0 0 0
            0 1 1 1 0
            0 0 0 0 0]
    nodelist = mazetonodelist(maze)

    # Test at nodelist er en liste/array med Node-instanser
    # Merk at følgende tester vil feile dersom dette ikke er tilfelet
    @test nodelist isa Array{Node,1}

    # Test at grafen inneholder riktig antall noder
    @test length(nodelist) == 7

    # Vi sorterer nodelist ut ifra koordinatene, ettersom vi ikke pålegger
    # en spesifikk rekkefølge på nodene i nodelist
    sortnodelist(nodelist)

    # Test at koordinatene til hver node er korrekte
    @test getcoords(nodelist) ==
        [(2, 2), (3, 2), (4, 2), (2, 3), (4, 3), (2, 4), (4, 4)]

    # Test at koordinatene til hver nabonode er korrekte
    @test getneighborcoords(nodelist) ==
        [[(3, 2), (2, 3)], [(2, 2), (4, 2)],
         [(3, 2), (4, 3)], [(2, 2), (2, 4)],
         [(4, 2), (4, 4)], [(2, 3)], [(4, 3)]]
end

@testset "MiddelsLabyrint" begin
    maze = [0 0 0 0 0 0 0
            0 1 1 1 1 1 0
            0 1 0 0 0 1 0
            0 1 0 1 0 1 0
            0 1 0 1 0 1 0
            0 1 1 1 0 1 0
            0 0 0 0 0 0 0]
    nodelist = mazetonodelist(maze)

    @test nodelist isa Array{Node,1}

    @test length(nodelist) == 17

    sortnodelist(nodelist)

    @test getcoords(nodelist) ==
        [(2, 2), (3, 2), (4, 2), (5, 2), (6, 2),
         (2, 3), (6, 3), (2, 4), (4, 4), (5, 4),
         (6, 4), (2, 5), (2, 6), (3, 6), (4, 6),
         (5, 6), (6, 6)]

    @test getneighborcoords(nodelist) ==
        [[(3, 2), (2, 3)], [(2, 2), (4, 2)], [(3, 2), (5, 2)],
         [(4, 2), (6, 2)], [(5, 2), (6, 3)], [(2, 2), (2, 4)],
         [(6, 2), (6, 4)], [(2, 3), (2, 5)], [(5, 4)],
         [(4, 4), (6, 4)], [(6, 3), (5, 4)], [(2, 4), (2, 6)],
         [(2, 5), (3, 6)], [(2, 6), (4, 6)], [(3, 6), (5, 6)],
         [(4, 6), (6, 6)], [(5, 6)]]
end

println("\nFungerte alt? Prøv å kjør koden i inginious!")
println("Husk at disse testene ikke alltid sjekker alle edge-cases")
println("---------------------------------------------------------\n\n")