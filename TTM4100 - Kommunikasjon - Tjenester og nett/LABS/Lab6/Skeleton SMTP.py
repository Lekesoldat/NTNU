# This skeleton is valid for both Python 2.7 and Python 3.
# You should be aware of your additional code for compatibility of the Python version of your choice.

from socket import *
import argparse as ap
import getpass as gp

#Get sender_email and recipient_email as arguments to the program
parser = ap.ArgumentParser(description='A test SMTP client without authentication')
parser.add_argument('-f', '--from', dest='fromMail', required=True, metavar='<sender_email>')
parser.add_argument('-t', '--to', dest='toMail', required=True, metavar='<recipient_email>')
#If using the authentication of the SMTP server, also get a valid username (optional exercise)
#parser.add_argument('-u', '--username', dest='username', required=True, metavar='<username>')

args = parser.parse_args()
fromMail = args.fromMail #Sender's email address
toMail = args.toMail #Recipient's email address

# Message to send
msg = "\r\n I love computer networks!"
endmsg = "\r\n.\r\n"

# You can run a local simple SMTP server such as "Fake SMTP Server" and communicate with it without authentication.
mailserver = 'localhost'
mailPort = 25;

# Create socket called clientSocket and establish a TCP connection
# (use the appropriate port) with mailserver
clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect((mailserver, mailPort))
print("Connecting to {}:{}".format(mailserver, mailPort))

# Returns a byte string
recv = clientSocket.recv(1024)
print("> Response: ", recv.decode(), "\n")
# Must decode to match pattern.
if recv.decode()[:3] != '220':
	print('220 reply not received from server.')

# Send HELO command and print server response.
# Can use EHLO instead since HELO is obsolete, but the latter can still be used
heloCommand = 'EHLO Magnus\r\n'
clientSocket.send(heloCommand.encode()) #Python 3
print("Sending EHLO")

recv1 = clientSocket.recv(1024)
print("> Response: ", recv1.decode(), "\n")

# Must decode to match pattern.
if recv1.decode()[:3] != '250':
	print('250 reply not received from server.')

# Send MAIL FROM command and print server response.
mailFromCommand = 'MAIL FROM: <{}>\r\n'.format(fromMail)

print("Sending MAIL FROM: <{}>".format(fromMail))
clientSocket.send(mailFromCommand.encode())

print("> Response: ", clientSocket.recv(1024).decode(), "\n")

# Send RCPT TO command and print server response.
rcptToCommand = 'RCPT TO: <{}>\r\n'.format(toMail)

print("Sending RCPT TO: <{}>".format(toMail))
clientSocket.send(rcptToCommand.encode())

print("> Response: ", clientSocket.recv(1024).decode(), "\n")

# Send DATA command and print server response.
dataCommand = 'DATA\r\n'

print("Sending DATA")
clientSocket.send(dataCommand.encode())

print("> Response: ", clientSocket.recv(1024).decode(), "\n")

# Send message data.
print("Sending MESSAGE")
clientSocket.send(msg.encode());

# Message ends with a single period.
print("Sending END MESSAGE")
clientSocket.send(endmsg.encode());

print("> Response: ", clientSocket.recv(1024).decode(), "\n")

# Send QUIT command and get server response.
quitCommand = 'QUIT\r\n'

print("Sending QUIT")
clientSocket.send(quitCommand.encode())

print("> Response: ", clientSocket.recv(1024).decode(), "\n")