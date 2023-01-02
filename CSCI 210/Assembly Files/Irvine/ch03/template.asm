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

.data
	; declare variables here
.code
main proc
	; write your code here

	invoke ExitProcess,0
main endp
end main