package edu.qc.seclass;

public class MyCustomString implements MyCustomStringInterface{
private String string;
	@Override
	public String getString() {
		if(this.string.isEmpty()) {
			return null;
		}
		return string;
	}

	@Override
	public void setString(String string) {
		this.string = string;
		
	}

	@Override
	public int countNumbers() {
		int count = 0;
		boolean temp = false;
		if(string.isEmpty()) {
			return 0;
		}
		else if(this.string == null) {
			throw new NullPointerException();
		}
		else {
			for(int i = 0; i < string.length(); i++) {
				if(Character.isDigit(string.charAt(i))) {
					if(temp == false) {
						count++;
						temp = true;
					}
					else if(temp == true && Character.isDigit(string.charAt(i+1))) {
						temp = true;
					}
					else {
						temp = true;
					}
				}
				else {
					temp = false;
				}
			}
			return count;
		}
	}

	@Override
	public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) {
		StringBuffer outputString = new StringBuffer();

        if(n <= 0){
            throw new IllegalArgumentException();
        }

        else if(this.string == null && n > 0){
            throw new NullPointerException();
        }

        else {
            if (n > this.string.length()) {
                return "";
            } else {
                if (startFromEnd == true) {
                    for (int i = this.string.length() - n; i >= 0; i -= n) {
                        outputString.insert(0, this.string.charAt(i));
                    }
                    return outputString.toString();
                } else {
                    for (int i = n - 1; i < this.string.length(); i += n) {
                        outputString.append(this.string.charAt(i));
                    }
                    return outputString.toString();
                }
            }
        }
    }

	@Override
	public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
		if(startPosition > endPosition){
            throw new IllegalArgumentException();
        }

        else if((startPosition <= endPosition) && ((startPosition < 1 || endPosition > this.string.length()))){
            throw new MyIndexOutOfBoundsException();

        }
        
        else if((startPosition <= endPosition) && ((startPosition > 0 && endPosition > 0 && this.string == null))){
            throw new NullPointerException();
        }

        else{
            StringBuffer intToString = new StringBuffer();
            for(int i = 0; i < this.string.length(); i++){
                if(Character.isDigit(string.charAt(i)) && i >= startPosition-1 && i <= endPosition -1){
                    switch(string.charAt(i)){
                        case '0' : 
                            intToString.append("Zero");
                            break;
                        case '1' : 
                            intToString.append("One");
                            break;
                        case '2' : 
                            intToString.append("Two");
                            break;
                        case '3' : 
                            intToString.append("Three");
                            break;
                        case '4' : 
                            intToString.append("Four");
                            break;
                        case '5' : 
                            intToString.append("Five");
                            break;
                        case '6' : 
                            intToString.append("Six");
                            break;
                        case '7' : 
                            intToString.append("Seven");
                            break;
                        case '8' : 
                            intToString.append("Eight");
                            break;
                        case '9' : 
                            intToString.append("Nine");
                            break;

                    }
                }
                else{
                    intToString.append(this.string.charAt(i));
                }
            }
            this.string = intToString.toString();
        }
    }

}
