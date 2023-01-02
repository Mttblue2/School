; AddTwo.asm - adds two 32-bit integers.
; Chapter 3 example

.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.code
main proc
	mov	eax,5				
	add	eax,6
	
	call	 WriteInt			; display in signed decimal
	call	 Crlf
	call	 WriteHex			; display in hexadecimal
	call	 Crlf
	call	 WriteBin			; display in binary
	call	 Crlf
	call	 Crlf

	invoke ExitProcess,0
main endp
end main