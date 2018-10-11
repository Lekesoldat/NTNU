from lxml import etree

def strip(lines):
    return [line.strip() for line in lines]

def append(parent, tag_name, value):
    child = etree.Element(tag_name)
    child.text = value
    parent.append(child)

with open('table.txt') as file:
    lines = strip(file)
    taxes = etree.Element('taxes')

    for i in range(4, len(lines)):
        values = strip(lines[i].split('|'))
        entry = etree.Element('entry')

        append(entry, 'name', values[1])
        append(entry, 'gender', values[2])
        append(entry, 'email', values[3])
        append(entry, 'birthyear', values[4])
        append(entry, 'hero', values[5])
        append(entry, 'spandex', values[6])
        append(entry, 'strength', values[7])
        append(entry, 'speed', values[8])
        append(entry, 'intelligence', values[9])
        append(entry, 'wealth', values[10])
        append(entry, 'income', values[11])
        append(entry, 'tax', values[12])

        taxes.append(entry)

    print(etree.tostring(taxes, pretty_print=True).decode('utf-8'))
