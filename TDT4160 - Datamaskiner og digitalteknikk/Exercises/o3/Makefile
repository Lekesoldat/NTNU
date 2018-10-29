####################################################################
# Makefile                                                         #
####################################################################

.SUFFIXES:				# ignore builtin rules
.PHONY: all debug release clean flash rammeverk 

####################################################################
# Definitions                                                      #
####################################################################

# notdirx: version of notdir which allows spaces in path
s? = $(subst $(empty) ,?,$1)
?s = $(subst ?, ,$1)
notdirx = $(call ?s,$(notdir $(call s?,$1)))

DEVICE = EFM32GG990F1024
PROJECTNAME = $(call notdirx,$(CURDIR))

OBJ_DIR = build
EXE_DIR = exe
LST_DIR = lst


####################################################################
# Definitions of toolchain.                                        #
# You might need to do changes to match your system setup          #
####################################################################

RM         := rm -rf
NULLDEVICE := /dev/null
SHELLNAMES := $(ComSpec)$(COMSPEC)

CC         := arm-none-eabi-gcc
LD         := arm-none-eabi-ld
AR         := arm-none-eabi-ar
OBJCOPY    := arm-none-eabi-objcopy
DUMP       := arm-none-eabi-objdump

# Detect operating system
ifeq ($(SHELLNAMES),)           # Linux
  EACOM = /opt/SimplicityStudio_v3/bgtool/commander/commander
else
  EACOM = C:\SiliconLabs\SimplicityStudio\v3\bgtool\commander\commander.exe
  ifneq ($(COMSPEC),)           # mingw/msys/cygwin platform running on Windows
    ifeq ($(findstring cygdrive,$(shell set)),)
      # We were not on a cygwin platform
      NULLDEVICE := NUL
    endif
  else                          # Windows
    NULLDEVICE := NUL
  endif
endif

# Create directories and do a clean which is compatible with parallell make
$(shell mkdir $(OBJ_DIR)>$(NULLDEVICE) 2>&1)
$(shell mkdir $(EXE_DIR)>$(NULLDEVICE) 2>&1)
$(shell mkdir $(LST_DIR)>$(NULLDEVICE) 2>&1)
ifeq (clean,$(findstring clean, $(MAKECMDGOALS)))
  ifneq ($(filter $(MAKECMDGOALS),all debug release),)
    $(shell $(RM) $(OBJ_DIR)/*>$(NULLDEVICE) 2>&1)
    $(shell $(RM) $(EXE_DIR)/*>$(NULLDEVICE) 2>&1)
    $(shell $(RM) $(LST_DIR)/*>$(NULLDEVICE) 2>&1) #*/
  endif
endif




####################################################################
# Flags                                                            #
####################################################################

# -MMD : Don't generate dependencies on system header files.
# -MP  : Add phony targets, useful when a h-file is removed from a project.
# -MF  : Specify a file to write the dependencies to.
DEPFLAGS = -MMD -MP -MF $(@:.o=.d)

#
# Add -Wa,-ahld=$(LST_DIR)/$(@F:.o=.lst) to CFLAGS to produce assembly list files
#
override CFLAGS += -D$(DEVICE) -Wall -Wextra -mcpu=cortex-m3 -mthumb -ffunction-sections \
-fdata-sections -mfix-cortex-m3-ldrd -fomit-frame-pointer -DDEBUG_EFM       \
-O0 \
$(DEPFLAGS)

ASMFLAGS += -x assembler-with-cpp -mcpu=cortex-m3 -mthumb

#
# NOTE: The -Wl,--gc-sections flag may interfere with debugging using gdb.
#
override LDFLAGS += -Xlinker -Map=$(LST_DIR)/$(PROJECTNAME).map -mcpu=cortex-m3 \
-mthumb -Tefm32gg.ld --specs=nano.specs \
 -Wl,--gc-sections

LIBS = -Wl,--start-group -lgcc -lc -lnosys -Wl,--end-group

INCLUDEPATHS += \
-I.. \
-I../common/CMSIS/Include \
-I../common/EFM32GG/Include \
-I../common/emlib/inc \
-I../common/EFM32/drivers \
-I../common/EFM32/bsp \
-I../common/EFM32GG_STK3700/config

####################################################################
# Files                                                            #
####################################################################

C_SRC +=  \
../common/EFM32GG/Source/system_efm32gg.c \
../common/EFM32/drivers/vddcheck.c \
../common/EFM32/drivers/segmentlcd.c \
../common/emlib/src/em_assert.c \
../common/emlib/src/em_cmu.c \
../common/emlib/src/em_emu.c \
../common/emlib/src/em_gpio.c \
../common/emlib/src/em_rtc.c \
../common/emlib/src/em_system.c \
../common/emlib/src/em_lcd.c \
../common/emlib/src/em_vcmp.c \
../common/emlib/src/em_usart.c \
../common/EFM32/bsp/bsp_stk.c \
../common/EFM32/bsp/bsp_stk_leds.c \
../common/EFM32/bsp/bsp_trace.c \
../common/$(PROJECTNAME)/init.c

s_SRC +=  \
../common/EFM32GG/Source/GCC/startup_efm32gg.s

STUDENT_SRC += \
$(PROJECTNAME).c

####################################################################
# Rules                                                            #
####################################################################

C_FILES = $(notdir $(C_SRC) )
S_FILES = $(notdir $(S_SRC) $(s_SRC) )
#make list of source paths, sort also removes duplicates
C_PATHS = $(sort $(dir $(C_SRC) ) )
S_PATHS = $(sort $(dir $(S_SRC) $(s_SRC) ) )

C_OBJS = $(addprefix $(OBJ_DIR)/, $(C_FILES:.c=.o))
S_OBJS = $(if $(S_SRC), $(addprefix $(OBJ_DIR)/, $(S_FILES:.S=.o)))
s_OBJS = $(if $(s_SRC), $(addprefix $(OBJ_DIR)/, $(S_FILES:.s=.o)))
C_DEPS = $(addprefix $(OBJ_DIR)/, $(C_FILES:.c=.d))
OBJS = $(C_OBJS) $(S_OBJS) $(s_OBJS)
STUDENT_OBJS = $(addprefix $(OBJ_DIR)/, $(STUDENT_SRC:.c=.o))

vpath %.c $(C_PATHS)
vpath %.s $(S_PATHS)
vpath %.S $(S_PATHS)


# Default build is debug build
all:      debug

debug:    CFLAGS += -DDEBUG -O0 -g3
debug:    $(EXE_DIR)/$(PROJECTNAME).bin

release:  CFLAGS += -DNDEBUG -O3 -g3 
release:  $(EXE_DIR)/$(PROJECTNAME).bin

rammeverk:  $(OBJS)

# Create objects from C SRC files
$(OBJ_DIR)/%.o: %.c
	@echo "Building file: $<"
	$(CC) $(CFLAGS) $(INCLUDEPATHS) -c -o $@ $<

# Assemble .s/.S files
$(OBJ_DIR)/%.o: %.s
	@echo "Assembling $<"
	$(CC) $(ASMFLAGS) $(INCLUDEPATHS) -c -o $@ $<

$(OBJ_DIR)/%.o: %.S
	@echo "Assembling $<"
	$(CC) $(ASMFLAGS) $(INCLUDEPATHS) -c -o $@ $<

# Link
$(EXE_DIR)/$(PROJECTNAME).out: $(STUDENT_OBJS) 
	@echo "Linking target: $@"
	$(CC) $(LDFLAGS) $(OBJS) $(STUDENT_OBJS) $(LIBS) -o $(EXE_DIR)/$(PROJECTNAME).out

# Create binary file
$(EXE_DIR)/$(PROJECTNAME).bin: $(EXE_DIR)/$(PROJECTNAME).out
	@echo "Creating binary file"
	$(OBJCOPY) -O binary $(EXE_DIR)/$(PROJECTNAME).out $(EXE_DIR)/$(PROJECTNAME).bin
# Uncomment next line to produce assembly listing of entire program
#	$(DUMP) -h -S -C $(EXE_DIR)/$(PROJECTNAME).out>$(LST_DIR)/$(PROJECTNAME)out.lst

# Flash on!
ifeq ($(f), 1)
	$(EACOM) flash $(EXE_DIR)/$(PROJECTNAME).bin
endif

clean:
ifeq ($(filter $(MAKECMDGOALS),all debug release),)
	$(RM) $(LST_DIR) $(EXE_DIR)
	$(RM) $(STUDENT_OBJS)
endif

# include auto-generated dependency files (explicit rules)
ifneq (clean,$(findstring clean, $(MAKECMDGOALS)))
-include $(C_DEPS)
endif

flash:
	$(EACOM) flash $(EXE_DIR)/$(PROJECTNAME).bin
	@echo "Completed!"
