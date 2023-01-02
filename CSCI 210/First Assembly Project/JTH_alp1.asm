; Author:               Josh Howard
; Course Title_Section: CSCIU210_01
; Creation Date:        November 15, 2017
; Program Name:         Assembly Language Program Project 1
; Revision:             1
; Program Desciption:  

.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

INCLUDE Irvine32.inc

.data

firstnum DWORD ?
secondnum DWORD ?
incnum DWORD ?
decnum DWORD ?

heading BYTE "Josh Howard",0Ah, 0Dh
       BYTE "Assembly Language Project 1", 0Ah,0
enternum BYTE "Please enter a signed integer: ",0
anothernum BYTE "Please enter another signed integer: ", 0
numentered BYTE "The number you entered is: ",0
hexequiv BYTE "The hexidecimal equivalent is: ",0
binequiv BYTE "The binary equivalent is: ",0
sumstring BYTE "The sum of the two integers you entered is: ",0
mulstring BYTE "The product of the two integers you entered is: ",0
twogreater BYTE "If the first number you entered would have been 2 numbers greater,",0Ah,0Dh
           BYTE	"It would have been: ",0
threeless BYTE "if the second number you entered would have been 3 numbers less,",0Ah,0Dh
          BYTE "It would have been: ",0
ifchoosensum BYTE "Had you entered these numbers, your sum would have been: ",0
ifchoosenpro BYTE "Had you entered these numbers, your product would have been: ",0
luckynum BYTE "Please enter your favorite lucky number: ",0
minetoo BYTE "Interesting, your favorite lucky number is ",0
minetoo1 BYTE ", so is mine!",0Ah, 0Dh, 0
twocomp BYTE "The Two's Complement of your favorite lucky number is shown in the EAX register below.",0Ah,0Dh,0
ending BYTE "This program shows off my skills in Assembly Language programming!",0Ah,0Dh,0Ah
       BYTE "***** This program has Successfully Ended *****",0Ah, 0Dh, 0Ah, 0

.code
main PROC
     call  Crlf		; adds a blank line
     mov   edx,OFFSET heading		; copies heading string into edx
	 call  WriteString		; writes to screen what's in edx
	 call  Crlf		; adds a blank line
	 call  Crlf		; adds a blank line

	 mov   edx,OFFSET enternum		; copies enter number string into edx
	 call  WriteString		; writes to screen what's in edx
	 call  ReadInt		; reading in user input number
	 mov   firstnum,eax		; copies  what's in eax (user input number), to firstnum variable
	 call  Crlf		; adds a blank line

	 mov   edx,OFFSET numentered	; copies number entered string into edx
	 call  WriteString		; writes to screen what's in edx
	 call  WriteInt			; display in signed decimal
	 call  Crlf		; adds a blank line

	 mov   edx,OFFSET hexequiv		; copies hexquiv string into edx
	 call  WriteString		; writes to screen what's in edx
	 call  WriteHex			; display in hexadecimal
	 call  Crlf		; adds a blank line

	 mov   edx,OFFSET binequiv		; copies binequiv string into edx
	 call  WriteString		; writes to screen what's in edx
	 call  WriteBin			; display in binary
	 call  Crlf		; moves cursor to next left position
	 call  Crlf		; adds a blank line
     
	 mov   edx,OFFSET anothernum	; copies anothernum string into edx
	 call  WriteString		; writes to screen what's in edx
	 call  ReadInt		; reading in user input number
	 mov   secondnum,eax		; copies what's in eax (user input number), to secondnum variable
	 call  Crlf		; adds a blank line

	 mov   edx,OFFSET numentered	; copies number entered string into edx
	 call  WriteString		;writes to screen what's in edx
	 call  WriteInt			; display in signed decimal
	 call  Crlf		; adds a blank line

	 mov   edx,OFFSET hexequiv		; copies hexquiv string into edx
	 call  WriteString		; writes to screen what's in edx
	 call  WriteHex			; display in hexadecimal
	 call  Crlf		; adds a blank line

	 mov   edx,OFFSET binequiv		; copies binequiv string into edx
	 call  WriteString		; writes to screen what's in edx
	 call  WriteBin			; display in binary
	 call  Crlf		; moves cursor to next left position
	 call  Crlf		; adds a blank line

	 mov   edx,OFFSET sumstring		; copies sumstring string into edx
	 call  WriteString		; writes to screen what's in edx
	 add   eax,firstnum		; adds firstnum variable to eax
	 call  WriteInt		; writes to screen what's in eax
	 call  Crlf		; adds a blank line
	 call  Crlf		; adds a blank line

	 mov   edx,OFFSET mulstring		; copies mulstring string into edx
	 call  WriteString		; writes to screen what's in edx
	 mov   eax,firstnum		; copies firstnum variable into eax
	 imul  secondnum		; multiples eax by secondnum variable
	 call  WriteInt		; writes to screen what's in eax
	 call  Crlf		; adds a blank line
	 call  Crlf		; adds a blank line

	 mov   edx,OFFSET twogreater	; copies twogreater string into edx
	 call  WriteString		; writes to screen what's in edx
	 mov   eax,firstnum		; copies firstnum variable into eax
	 inc   eax		; adds 1 to eax
	 inc   eax		; adds 1 to eax
	 mov   incnum,eax		; copies eax into incnum variable
	 call  WriteInt		; writes to screen what's in eax
	 call  Crlf		; adds a blank line
	 call  Crlf		; adds a blank line

	 mov   edx,OFFSET threeless		; copies threeless string into edx
	 call  WriteString		; writes to screen what's in edx
	 mov   eax,secondnum	; copies secondnum variable into eax
	 dec   eax		; subtracts 1 from eax
	 dec   eax		; subtracts 1 from eax
	 dec   eax		; subtracts 1 from eax
	 mov   decnum,eax		; copies eax into decnum variable
	 call  WriteInt		; writes to screen what's in eax
	 call  Crlf		; adds a blank line
	 call  Crlf		; adds a blank line

	 mov   eax,incnum		; copies incnum variable into eax
	 add   eax,decnum		; adds decnum variable to eax
	 mov   edx,OFFSET ifchoosensum	; copies ifchoosensum string into edx
	 call  WriteString		; writes to screen what's in edx
	 call  WriteInt		; writes to screen what's in eax
	 call  Crlf		; adds a blank line
	 call  Crlf		; adds a blank line

	 mov   eax,incnum		; copies incnum variable into eax
	 mul   decnum		; multiples eax by decnum
	 mov   edx,OFFSET ifchoosenpro		; copies ifchoosenpro string into edx
	 call  WriteString		; writes to screen what's in edx
	 call  WriteInt		; writes to screen what's in eax
	 call  Crlf		; adds a blank line
	 call  Crlf		; adds a blank line

	 mov   edx,OFFSET luckynum		; copies luckynum string into edx
	 call  WriteString		; writes to screen what's in edx
	 call  ReadInt		; writes to screen what's in eax
	 call  Crlf		; adds a blank line

	 mov   edx,OFFSET minetoo		; copies minetoo string into edx
	 call  WriteString		; writes to screen what's in edx
	 call  WriteInt		; writes to screen what's in eax
	 mov   edx,OFFSET minetoo1		; copies minetoo1 string into edx
	 call  WriteString		; writes to screen what's in edx
	 call  Crlf		; adds a blank line

	 mov   edx,OFFSET twocomp		; copies twocomp string into edx
	 call  WriteString		; writes to screen what's in edx
	 neg   eax		; takes the two's complement of what's in eax
	 call  DumpRegs		; dumps registers

	 mov   edx,OFFSET ending		;copies ending string into edx
	 call  WriteString		; writes to screen what's in edx

	 call  WaitMsg			; "Press any key to continue..."

	exit
main ENDP
END main