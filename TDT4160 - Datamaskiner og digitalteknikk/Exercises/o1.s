.thumb
.syntax unified

.include "gpio_constants.s"    					// Register-adresser og konstanter for GPIO

.text
	.global Start

Start:
	ldr r0, =GPIO_BASE + (LED_PORT  * PORT_SIZE) 		// r0 = Full adresse til LED_PORT

	// Data Out - LED
	ldr r1, =GPIO_PORT_DOUT					// r1 = Data out
	add r1, r0, r1 						// r1 = Full adresse til LED_PORT_DOUT

	// Data Out Clear - LED
	ldr r2, =GPIO_PORT_DOUTCLR				// r2 = Data Out Clear
	add r2, r0, r2						// r2 = Full adresse til LED_PORT_DOUTCLR

	// Bitvis or'er DOUT med bitstreng som skrur på LED
	ldr r3, =1 << LED_PIN					// r3 = 0b00000100 = Ønsket data på LED_PORT_DOUT, shifter 1 LED_PIN plasser til venstre.
	ldr r4, [r1]						// r4 = Data på LED_PORT_OUT
	orr r3, r4, r3						// r3 = DOUT or'et med ønsket output

	ldr r5, =GPIO_BASE + (BUTTON_PORT * PORT_SIZE) 		// r5 = Full adresse til BUTTON_PORT
	ldr r6, =GPIO_PORT_DIN					// r6 = Data In
	add r6, r5, r6						// Full adresse til BUTTON_PORT_DIN

	ldr r7, =1 << BUTTON_PIN				// r6 = 0b10000000 = Ønsket data på DOUT, shifter 1 BUTTON_PIN plasser til venstre.


Loop:
	ldr r8, [r6]						// Laster inn data fra r6 (pressed/unpressed)
	and r8, r8, r7						// Ander inputet med "på"-bitstrengen
	cmp r8, r7						// Om strengene samsvarer
	beq SkruPaa						// skru på LED

SkruAv:
	// Legger LED_PIN-bit i DOUTCLR
	str r3, [r1]						// Skrur av LED (Legger LED_BIT i DOUTCLR)
	b Loop							// Hopper opp i loopen

SkruPaa:
	str r3, [r2]						// Skru på LED
	b Loop							// Hopper opp i loopen

NOP // Behold denne på bunnen av fila
