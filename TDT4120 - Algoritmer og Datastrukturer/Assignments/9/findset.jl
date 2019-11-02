function findset(x)
    if x != x.p
        x.p = findset(x.p)
    end
    x.p
end