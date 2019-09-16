mutable struct NodeDoublyLinked
  prev::Union{NodeDoublyLinked, Nothing} # Er enten forrige node eller nothing
  next::Union{NodeDoublyLinked, Nothing} # Er enten neste node eller nothing
  value::Int # Verdien til noden
end

function createLinkedListDoublyLinked(length)
  # Create the list from the last element in the chain
  # This is so the returned element will be the first in the chain
  current = nothing
  beforeCurrent = nothing

  for i in 1:length
      # only fill out the next field because prev will be filled out later
      current = NodeDoublyLinked(nothing, beforeCurrent, rand(-100:100))
      # link up the node before this node to this node
      if beforeCurrent != nothing
          beforeCurrent.prev = current
      end
      beforeCurrent = current
  end
  return current
end

function maxofdoublelinkedlist(linkedlist)
  # Store refrence to starter node to avoid traversing some elements twice
  startingNode = linkedlist
  max::Int = linkedlist.value

  # Forward
  while linkedlist != nothing
    if linkedlist.value > max
      max = linkedlist.value
    end
    linkedlist = linkedlist.next
  end
  
  # Backward
  while startingNode != nothing
    if startingNode.value > max
      max = startingNode.value
    end
    startingNode = startingNode.prev
  end
  
  return max
end

function main()
  myList = createLinkedListDoublyLinked(10)
  println(maxofdoublelinkedlist(myList))
end

main()