################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../src/bTree.c \
../src/main.c \
../src/quickSort.c \
../src/sundayMatch.c 

OBJS += \
./src/bTree.o \
./src/main.o \
./src/quickSort.o \
./src/sundayMatch.o 

C_DEPS += \
./src/bTree.d \
./src/main.d \
./src/quickSort.d \
./src/sundayMatch.d 


# Each subdirectory must supply rules for building sources it contributes
src/%.o: ../src/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


