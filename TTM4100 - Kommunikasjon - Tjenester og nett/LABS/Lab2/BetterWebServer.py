# This is a rewritten version of the original assignment which had to be done in a certain, non pleasant, way.
# Big thanks to @fshauge for great teaching.
from socket import *

server = socket(AF_INET, SOCK_STREAM)   # Setup a TCP server socket.
serverPort = 1337                       # Assign a port number
server.bind(('', serverPort))           # Bind the socket to the server port
server.listen(1)                        # Listen to at most 1 connection at a time

httpVersion = "HTTP/1.1"

def createResponse(filepath):
    try:
        return 200, 'OK', open(filepath).read()
    except IOError:
        return 404, 'Not Found', '<html><head></head><body><h1>404 Not Found</h1></body></html>'

while True:
    print("Ready to serve...")
    # New connection from the client
    client, addr = server.accept()      

    # Message recieved from the client
    message = client.recv(1024).decode()

    # Path is the second part of the header
    filepath = message.split()[1]

    # Skipping the first character of the file path ('/')
    statusCode, reason, body = createResponse(filepath[1:])

    # Always end a line with CRLF
    statusLine = '{} {} {}\r\n'.format(httpVersion, statusCode, reason)
    response = '{}\r\n{}'.format(statusLine, body)

    client.send(response.encode())
    client.close()

server.close()