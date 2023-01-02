; Author:               Josh Howard
; Course Title_Section: CSCIU210_01
; Creation Date:        December 8, 2017
; Program Name:         Assembly Language Program Project 3
; Revision:             1
; Program Desciption: 

.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

INCLUDE Irvine32.inc

.data

aName byte "Josh Howard",0
nameSize = ($ - aName) - 1
	
ArrayD DWORD 12345h, 23456h, 34567h, 45678h, 56789h, 67890h

notvalid BYTE "The number you have entered is not a valid menu choice.", 0Ah, 0Dh
         BYTE "Please select a valid menu choice from below.", 0Ah, 0Dh, 0
greatchoice BYTE "You have chosen a great meal. It will be coming up shortly.", 0Ah, 0Dh, 0
pleasepay BYTE "Please pay at the counter and we hope that you will come back again soon.", 0Ah, 0Dh, 0
soldout BYTE "Sorry, but we SOLD OUT of that Main Meal selection.", 0Ah, 0Dh
		BYTE "Please select another.", 0Ah, 0Dh, 0
play BYTE "1: Yes", 0Ah, 0Dh
	 BYTE "2: No", 0Ah, 0Dh
     BYTE "Would you like to play rock-paper-scissors: ", 0
proexit BYTE "This program will now exit!", 0Ah, 0Dh, 0

.code
main proc
	
	call  ColorChange		; changes the text and command prompt background color
	call  Crlf		; adds blank line
	call  RevName		; reverses a string and prints it out
	call  Crlf		; adds a blank line
	call  WriteProgNum		; writes the program name to the screen
	call  Crlf		; adds a blank line

menujmp:
	call  Menu		; print out the menu options
	call  ReadInt		; reads in an int from the user
	call  Crlf		; adds a blank line

.if eax == 0
	mov   edx,OFFSET notvalid		; copies the notvalid string into edx
	call  WriteString		; writes whats in the edx register to the screen
	call  Crlf		; adds a blank line
	jmp   menujmp		; puts the program back to the menujmp point
.elseif eax == 1
	mov   edx,OFFSET greatchoice		; copies the greatchoice string into edx
	call  WriteString		; writes whats in the edx register to the screen
	call  Multiprint		; print's a string a number of times
	call  Crlf		; adds a blank line
	mov   edx,OFFSET pleasepay		; copies the please pay string into edx
	call  WriteString		; print's what's in the edx register to the screen
.elseif eax == 2
	mov   edx,OFFSET soldout		; copies the soldout string into edx
	call  WriteString		; writes whats in the edx register to the screen
	call  Crlf		; adds a blank line
	jmp   menujmp		; puts the program back to the menujmp point
.elseif eax == 3
	mov   edx,OFFSET greatchoice		; copies the greatchoice string into edx
	call  WriteString		; writes what's in the edx register to the screen
	call  Multiprint		; print's a string a number of times
	call  Crlf		; adds a blank line
	mov   edx,OFFSET pleasepay		; copies the please pay string into edx
	call  WriteString		; writes what's in the edx register to the screen
.elseif eax == 4
	mov   edx,OFFSET proexit		; copies the proexit string into edx
	call  WriteString		; writes what's in the edx register to the screen
.elseif eax >= 5
	mov   edx,OFFSET notvalid		; copies the notvalid string into edx
	call  WriteString		; writes what's in the edx register to the screen
	call  Crlf		; adds a blank line
	jmp   menujmp		; puts the program back to the menujmp point
.endif

	mov   eax, 00000000		; clears the eax register
	mov   ebx, 00000000		; clears the ebx register
	mov   ecx, 00000000		; clears the ecx register
	mov   edx, 00000000		; clears the edx register

	call  SumDArray		; sums an array
	call  DumpRegs		; puts all register values to the screen

	call  RevName		; reverses a string and writes it to the screen
	call  Crlf		; adds a blank line
	call  RevName		; reverses a string and writes it to the screen
	call  Crlf		; adds a blank line
	call  RevName		; reverses a string and writes it to the screen
	call  Crlf		; adds a blank line

	mov   edx,OFFSET play		; copies the play string into edx
	call  WriteString		; writes what's in the edx register to the screen
	call  ReadInt		; reads in user input int

.if eax == 1
	call  RPS		; starts the RPS game
.endif
	
	call  Crlf		; adds a blank line
	call  Endloop		; prints the final message 3 times

	call  WaitMsg			; "Press any key..."
	exit		;exit program
main endp

;Changes the color of the command prompt
;to grey background and blue text
ColorChange PROC

	push  eax
	mov   eax,blue + (lightgray * 16)
	call  SetTextColor
	call  Clrscr
	pop   eax

ret
ColorChange ENDP

;Reverese a string, then prints it out
RevName PROC
	
	push  ecx
	push  esi
	push  eax

	mov	  ecx,nameSize
	mov	  esi,0

L1:	movzx eax,aName[esi]	; get character
	push  eax				; push on stack
	inc	  esi
	loop  L1

; Pop the name from the stack in reverse
; and store it in the aName array.

	mov	  ecx,nameSize
	mov	  esi,0

L2:	pop   eax				; get character
	mov	  aName[esi],al		; store in string
	inc	  esi
	loop  L2

	mov   edx,OFFSET aName
	call  WriteString
	call  Crlf

	pop   eax
	pop   esi
	pop   ecx

ret
RevName ENDP

;Duplicates a string 3 times, then prints it out
MultiPrint PROC

.data
help BYTE 3 DUP("* * * Thank you! * * *"),0Ah,0Dh,0
.code
	push  edx
	mov   edx,OFFSET help
	call  WriteString
	pop   edx

ret
MultiPrint ENDP

;Writes the program name to the screen
WriteProgNum PROC

.data
progname BYTE "Assembly Language Course Project", 0Ah,0
.code
	push  edx
	mov   edx,OFFSET progname
	call  WriteString
	pop   edx

ret
WriteProgNum ENDP

;Sets up and prints out a meal menu
Menu PROC

.data
mealoptions BYTE "Select a Main Meal Option", 0Ah, 0Dh
			BYTE " ", 0Ah, 0Dh
			BYTE "1. Turkey Sandwich",0Ah, 0Dh
			BYTE "2. Hot ham and Cheese Sandwich",0Ah, 0Dh
			BYTE "3. Garden Salad", 0Ah, 0Dh
			BYTE "4. Exit",0Ah, 0Dh
			BYTE "Choice> ",0
.code
	push  edx
	mov   edx,OFFSET mealoptions
	call  WriteString
	pop   edx

ret
Menu ENDP

;Takes a pre-defined array, sums the numbers
;inside and puts them in eax
SumDArray PROC

	mov   esi, 0	; array index
	mov   eax, 0	; set the sum to zero
	mov   ecx, LENGTHOF ArrayD  ; set number of elements

L1:	add   eax, ArrayD[esi]	; add each integer to sum
	add   esi, 4	; point to next integer
	loop  L1	; repeat for array size

ret
SumDArray ENDP

;Prints the ending messages 3 times to the screen
Endloop PROC

.data
	ended BYTE "***** This program has Successfully Ended. *****"
.code
	mov   edx,OFFSET ended
	mov   ecx, 3

L1:	call  WriteString
	call  Crlf
	loop  L1

ret
Endloop ENDP

RPS PROC

.data
compnum DWORD ?
usernum DWORD ?

win BYTE "You won!", 0Ah, 0Dh, 0
lost BYTE "You lost...", 0Ah, 0Dh, 0
tie BYTE "It's a tie!", 0Ah, 0Dh, 0
again BYTE "1: Play Again", 0Ah, 0Dh
	  BYTE "2: End", 0Ah, 0Dh
	  BYTE "Please choose: ",0
choose BYTE "1: Rock", 0Ah, 0Dh
	   BYTE "2: Paper", 0Ah, 0Dh
	   BYTE "3: Scissors", 0Ah, 0Dh
	   BYTE "Please choose: ",0
.code
rpsjmp:
	mov   eax,3		; moves 3 into eax
	call  RandomRange		; creates a random number between 0-2
	mov   compnum,eax	

	call  Clrscr
	mov   edx,OFFSET choose
	call  WriteString
	call  ReadInt
	dec   eax

.if eax == 0
	.if compnum == 1
		mov   edx,OFFSET lost
		call  WriteString
	.elseif compnum == 2
		mov   edx,OFFSET win
		call  WriteString
	.elseif compnum == 0
		mov   edx,OFFSET tie
		call  WriteString
	.endif
.elseif eax == 1
	.if compnum == 2
		mov   edx,OFFSET lost
		call  WriteString
	.elseif compnum == 0
		mov   edx,OFFSET win
		call  WriteString
	.elseif compnum == 1
		mov   edx,OFFSET tie
		call  WriteString
	.endif
.elseif eax == 2
	.if compnum == 0
		mov   edx,OFFSET lost
		call  WriteString
	.elseif compnum == 1
		mov   edx,OFFSET win
		call  WriteString
	.elseif compnum == 2
		mov   edx,OFFSET tie
		call  WriteString
	.endif
.endif

	mov   edx,OFFSET again
	call  WriteString
	call  ReadInt

.if eax == 1
	jmp rpsjmp
.else
	ret
.endif

RPS ENDP

end main