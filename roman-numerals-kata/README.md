# Roman Numerals Kata

## Roman numerals

Symbol | Value
-------|-------
I      | 1
V      | 5
X      | 10
L      | 50
C      | 100
D      | 500
M      | 1,000

## Rules

* The symbols 'I', 'X', 'C', and 'M' can be repeated at most 3 times in a row.
* The symbols 'V', 'L', and 'D' can never be repeated.
* The '1' symbols ('I', 'X', and 'C') can only be subtracted from the 2 next highest values ('IV' and 'IX', 'XL' and 'XC', 'CD' and 'CM'). Only one subtraction can be made per numeral ('XC' is allowed, 'XXC' is not).
* The '5' symbols ('V', 'L', and 'D') can never be subtracted.

## Kata: Convert Arabic numbers into their Roman numeral equivalents

## Acceptance criteria:

> As a samurai
> I want to be able to convert a number to a numeral
> So that I can replace Arabic Numbers with Roman numerals

* > **Given** I have started the converter
  > **When** I enter $number
  > **Then** $numeral is returned

* > **Given** I have started the converter
  > **When** I enter something that is not an Arabic number
  > **Then** I should receive an error
