.thumb
.syntax unified

.include "gpio_constants.s"     			// Register-adresser og konstanter for GPIO
.include "sys-tick_constants.s" 			// Register-adresser og konstanter for SysTick

.text
	.global Start

Start:
	BL SetupGPIOConfig
	BL SetupSysTickConfig

Loop:
	B Loop


SetupGPIOConfig:

	/* GPIO_EXTIPSELH */
	ldr r0, =GPIO_BASE + GPIO_EXTIPSELH 		// Get External Interrupt Port Select High address
	ldr r1, [r0] 					// Data stored at EXTIPSELH
	and r1, ~(0b1111 << 4) 				// Bit pattern for EXTIPSELH for pin 9 to 0000
	orr r1, 0b0001 << 4 				// Bit pattern for EXTIPSELH for pin 9 to 0001
	str r1, [r0] 					// Store 0001 in EXTIPSELH for pin 9


	/* EXTIFALL */
	ldr r0, =GPIO_BASE + GPIO_EXTIFALL 		// Get address to EXTIFALL
	ldr r1, [r0] 					// Store data at EXTIFALL
	orr r1, 1 << BUTTON_PIN 			// Enable bit 9
	str r1, [r0] 					// Store on address

	/* Enable interrupts*/
	ldr r0, =GPIO_BASE+GPIO_IEN 			// Load IEN address
	ldr r1, [r0] 					// Store data at IEN address
	orr r1, 1 << BUTTON_PIN 			// Enable interrupt for pin 9
	str r1, [r0] 					// Store on address

	/* Clear Interrupt flag */
	ldr r0, =GPIO_BASE + GPIO_IFC 			// Get address for interrupt flag
	ldr r1, [r0] 					// Store data for interrupt flag
	orr r1, 1 << BUTTON_PIN 			// Set bit
	str r1, [r0] 					// Store on address

	bx lr

SetupSysTickConfig:
	/* Setup CTRL */
	ldr r0, =SYSTICK_BASE + SYSTICK_CTRL 		// CTRL - Address
	mov r1, #0b110 					// Enable Gecko clock, generate interrupt
	str r1, [r0]					// Store on address


	/* Setup LOAD - count down 10ms */
	ldr r0, =FREQUENCY / 10
	ldr r1, =SYSTICK_BASE + SYSTICK_LOAD 		// LOAD - Address
	str r0, [r1] 					// Store on address

	/* Setup VAL -> 0 */
	ldr r0, =SYSTICK_BASE + SYSTICK_VAL
	mov r1, #0
	str r1, [r0]

	bx lr

.global SysTick_Handler
.thumb_func

/* Every tenth second */
SysTick_Handler:
	mov r2, #1 					// Store '1' for incrementation
	mov r3, #0 					// Store '0' for reset

	ldr r1, =tenths 				// get tenths-address
	ldr r0, [r1] 					// grab value at tenths-address
	add r0, r0, r2 					// Increment by one

	cmp r0, #10 					// If a second has passed, update second
	beq reset_tenth

	str r0, [r1] 					// Else, update tenth
	bx lr 						// Return from interrupt


reset_tenth:
	/* Toggle LED */
	ldr r10, =GPIO_BASE + LED_PORT * PORT_SIZE + GPIO_PORT_DOUTTGL 
	ldr r11, =1 << 2 				// Bit pattern for LED_PIN = 2
	str r11, [r10]					// Toggle LED

	str r3, [r1] 					// Reset tenths

	/* Increment second */
	ldr r4, =seconds 				// Store address to seconds-reg
	ldr r5, [r4] 					// Store data at seconds-reg
	add r5, r5, r2 					// Increment by one

	cmp r5, #60 					// If a minute has passed, update minute
	beq reset_second

	str r5, [r4] 					// Else update second
	bx lr

reset_second:
	str r3, [r4] 					// Reset seconds

	/* Increment minute */
	ldr r6, =minutes 				// Address to minutes-reg
	ldr r7, [r6] 					// Data stored at minutes-reg
	add r7, r7, r2 					// Increment by one

	str r7, [r6] 					// Update minute
	bx lr

.global GPIO_ODD_IRQHandler
.thumb_func
GPIO_ODD_IRQHandler:
	/* Toggle clock */
	ldr r0, =SYSTICK_BASE + SYSTICK_CTRL 		// Get CTRL address
	ldr r1, [r0] 					// Store data at CTRL address
	eor r1, #0b001 					// Exclusive or last bit
	str r1, [r0]


	/* Clear Interrupt flag */
	ldr r0, =GPIO_BASE + GPIO_IFC 			// Get address for interrupt flag
	ldr r1, [r0] 					// Store data for interrupt flag
	orr r1, 1 << BUTTON_PIN 			// Set bit
	str r1, [r0] 					// Store on address

	bx lr

NOP // Behold denne på bunnen av fila
