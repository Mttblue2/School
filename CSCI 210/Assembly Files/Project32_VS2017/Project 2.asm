; Author:               Josh Howard
; Course Title_Section: CSCIU210_01
; Creation Date:        November 15, 2017
; Program Name:         Assembly Language Program Project 2
; Revision:             1
; Program Desciption:  

.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

INCLUDE Irvine32.inc

.data

COUNT = 5
OptionNum DWORD ?

firstarray DWORD 0, 1, 2, 3
luckynum   DWORD ?

heading BYTE "Josh Howard",0Ah, 0Dh
        BYTE "Assembly Language Project 2", 0Ah,0
mealoptions BYTE "Select a Main Meal Option", 0Ah, 0Dh, 0
mealone		BYTE "1. Turkey Sandwich",0Ah, 0Dh, 0
mealtwo		BYTE "2. Hot ham and Cheese Sandwich",0Ah, 0Dh, 0
mealthree	BYTE "3. Garden Salad", 0Ah, 0Dh, 0
mealfour	BYTE "4. Exit",0Ah, 0Dh, 0
choices		BYTE "Choice> ",0
selected    BYTE "You have selected option ",0
unavaible   BYTE "Sorry but we are all out of that Main Meal selection.", 0
availble		BYTE "We do have this item, enjoy!!",0Ah, 0Dh, 0
comeback BYTE "We hope that you will come back again.",0
bye  BYTE "Bye Bye",0Ah,0Dh,0
ending BYTE "***** This program has Successfully Ended *****",0Ah, 0

.code
main PROC
     call  Crlf		; adds a blank line
     mov   edx,OFFSET heading		; copies heading string into edx
	 call  WriteString		; writes to screen what's in edx
	 call  Crlf		; adds a blank line

; creates a random number for availble option
	 mov   eax,4		; moves 4 into eax
	 call  RandomRange		; creates a random number between 0-3
	 mov   luckynum,eax		; moves luckynumber into ebx

     mov   ecx,COUNT

L1:	 mov   edx,OFFSET mealoptions
	 call  WriteString
	 mov   edx,OFFSET mealone
	 call  WriteString
	 mov   edx,OFFSET mealtwo
	 call  WriteString
	 mov   edx,OFFSET mealthree
	 call  WriteString
	 mov   edx,OFFSET mealfour
	 call  WriteString
	 
	 mov   edx,OFFSET choices
	 call  WriteString
	 call  ReadInt
	 mov   OptionNum, eax
	 call  Crlf
	 call  PrintOptions
	 call  Crlf

	 Loop  L1

	 call  Crlf
	 call  Crlf

	 mov   edx,OFFSET comeback
	 call  WriteString
	 call  Crlf

	 mov   edx,OFFSET ending		; copies ending string into edx
	 call  WriteString		; writes to screen what's in edx

	 call  WaitMsg			; "Press any key to continue..."

	exit
main ENDP

PrintOptions PROC

     mov   ebx, luckynum
	 push  ecx
	 mov   eax,OptionNum
	 mov   edx,OFFSET selected
	 call  WriteString
	 call  WriteInt
	 call  Crlf

.if  ebx == OptionNum
	 mov   edx,OFFSET availble
	 call  WriteString
	 pop   ecx
	 COUNT = 1
	 mov   ecx,COUNT
.elseif OptionNum == 4
	 pop   ecx
	 COUNT = 1
	 mov   ecx,COUNT
	 mov   esi, -1
.else
	 mov   edx,OFFSET unavaible
	 call  WriteString
	 pop   ecx
.endif

ret
PrintOptions ENDP
END main