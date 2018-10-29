#ifndef GPIO_H
#define GPIO_H

// Pin-datatype
typedef struct{
	unsigned int   port;
	unsigned int   pin;
} port_pin_t;

// GPIO pin modes
#define GPIO_MODE_INPUT  0b0001
#define GPIO_MODE_OUTPUT 0b0100

// GPIO-adresse
#define GPIO_BASE 0x40006000

// GPIO port-nummere
#define GPIO_PORT_A 0
#define GPIO_PORT_B 1
#define GPIO_PORT_C 2
#define GPIO_PORT_D 3
#define GPIO_PORT_E 4
#define GPIO_PORT_F 5


#endif
