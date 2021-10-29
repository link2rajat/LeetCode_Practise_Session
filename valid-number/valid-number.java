/* Follow the rules

Rules

Digits

First of all, there must always be at least one digit in the input for it to form a valid number. Let's use a variable seenDigit to indicate whether we have seen a digit yet.
Signs

If a sign is present, it must be the first character in a decimal number or integer. In a valid number, there are two possible locations for these signs - at the front of the number, or right after an exponent ("e" or "E") e.g., -63e+7. Therefore, if we see a sign, and it is not the first character of the input, and does not come immediately after an exponent ("e" or "E"), then we know the number is not valid.
Exponents ("e" or "E")

There cannot be more than one exponent in a valid number, so we will use a variable seenExponent to indicate whether we have already seen an exponent.
An exponent must appear after a decimal number or an integer. This means if we see an exponent, we must have already seen a digit.
Dots

There cannot be more than one dot in a valid number, since only integers are allowed after an exponent, so there cannot be more than one decimal number. We will use a variable seenDot to indicate whether we have seen a dot.
If we see a dot appear after an exponent, the number is not valid, because integers cannot have dots.
Anything else

Seeing anything else instantly invalidates the input.
Algorithm

Now that we have laid out the rules, let's iterate over the input. For each character, determine what group it belongs to, and verify that it follows the rules.

Declare 3 variables seenDigit, seenExponent, and seenDot. Set all of them to false.

Iterate over the input.

If the character is a digit, set seenDigit = true.

If the character is a sign, check if it is either the first character of the input, or if the character before it is an exponent. If not, return false.

If the character is an exponent, first check if we have already seen an exponent or if we have not yet seen a digit. If either is true, then return false. Otherwise, set seenExponent = true, and seenDigit = false. We need to reset seenDigit because after an exponent, we must construct a new integer.

If the character is a dot, first check if we have already seen either a dot or an exponent. If so, return false. Otherwise, set seenDot = true.

If the character is anything else, return false.

At the end, return seenDigit. This is one reason why we have to reset seenDigit after seeing an exponent - otherwise an input like "21e" would be incorrectly judged as valid.


*/
class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenExponent = false;
        boolean seenDecimal = false;
        
        for(int i=0;i<s.length();i++)
        {
            Character ch = s.charAt(i);
            
            if(Character.isDigit(ch))
            {
                seenDigit = true;
            }
            
            else if(ch=='+' || ch =='-')
            {
                if(i > 0 && s.charAt(i-1)!='e' && s.charAt(i-1)!='E')
                {
                    return false;
                }
            }
            else if(ch=='e' || ch=='E')
            {
                if(seenExponent || !seenDigit)
                {
                   return false;
                }
            
            seenExponent = true;
            seenDigit=false;
            }
            else if(ch=='.')
            {
                if(seenExponent || seenDecimal)
                {
                    return false;
                }
             seenDecimal = true;
            }
            else
            {
                return false;
            }
            
        }
        
        return seenDigit;
    }
}//T-O(N),S-O(1), n->length of String