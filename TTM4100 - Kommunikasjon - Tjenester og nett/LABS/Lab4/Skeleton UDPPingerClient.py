"""
READ THE DISCLAIMER AT https://github.com/Lekesoldat/NTNU/blob/master/README.md before proceeding.
Written by Magnus L. Holtet.
"""
# This skeleton is valid for both Python 2.7 and Python 3.
# You should be aware of your additional code for compatibility of the Python version of your choice.

import time
import sys
from socket import *

# Get the server hostname and port as command line arguments                    
[_, host, port] = sys.argv
timeout = 1.0 # in seconds

# Create UDP client socket
client = socket(AF_INET, SOCK_DGRAM)

# Note the second parameter is NOT SOCK_STREAM
# but the corresponding to UDP

client.settimeout(timeout)

# Sequence number of the ping message
ptime = 0  

# Ping for 10 times
while ptime < 10: 
    ptime += 1
    # Format the message to be sent as in the Lab description	
    data = "Operator Mono is expensive."
    
    try:
	# Record the "sent time"
        start = time.time()

	# Send the UDP packet with the ping message
        client.sendto(data.encode(),(host, int(port)))

	# Receive the server response
        message, server = client.recvfrom(1024)

	# Display the server response as an output
        print("Message: {}".format(message.decode()))
        print("From: {}:{}".format(server[0], server[1]))

	# Round trip time is the difference between sent and received time
        print("RTT: %s seconds.\n" % (time.time() - start))
    except:
        # Server does not response
	# Assume the packet is lost
        print("Request timed out.\n")
        continue

# Close the client socket
client.close()