mutable struct Node
  next::Union{Node, Nothing}
  value::Int
end

function createlinkedlist(length)
  child = nothing
  node = nothing

  for i in 1:length
    node = Node(child, rand(1:800))
    child = node
  end

  return node
end

# TL;DR findindexinlist skal returnere verdien i den linka listen med posisjon indeks, og om indeks er større enn lengden til den linka listen skal du returnere -1.
function findindexinlist(linkedlist, index)
  for i = 1:index -1
    if linkedlist.next == nothing
      return -1
    end
    linkedlist = linkedlist.next
  end
  return linkedlist.value
end

function main()
  myList = createlinkedlist(10)
  println(findindexinlist(myList, 2))
end

main()