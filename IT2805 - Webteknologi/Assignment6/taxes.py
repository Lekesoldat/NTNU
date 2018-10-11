# Was provided a table that was to be converted to xml, - way too boring to do that manually.
# Below is a script that converts that specific table structure to XML and writes to a file.
from lxml import etree

def strip(values):
    return [value.strip() for value in values]

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

        append(entry, 'realName', values[1])
        append(entry, 'gender', values[2])
        append(entry, 'email', values[3])
        append(entry, 'birthyear', values[4])
        append(entry, 'heroName', values[5])
        append(entry, 'spandex', values[6])
        append(entry, 'strength', values[7])
        append(entry, 'speed', values[8])
        append(entry, 'intelligence', values[9])
        append(entry, 'wealth', values[10])
        append(entry, 'income', values[11])
        append(entry, 'tax', values[12])

        taxes.append(entry)

    # print(etree.tostring(taxes, pretty_print=True).decode('utf-8'))

    # Creates output file with the data
    with open('output.xml', 'w') as output:
        output.write(etree.tostring(taxes, pretty_print=True).decode('utf-8'))
