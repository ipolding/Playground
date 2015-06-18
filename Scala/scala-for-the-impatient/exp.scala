def exp(base: Int, exponent: Int) : Long = {
		var answer: Int = 1
		if (exponent == 0) {1}
		else {
			answer = base * exp(base, math.abs(exponent - 1))
		if (exponent < 0 ) {answer = 1/answer}	

		}
    }

    def exp(base: Int, exponent: Int) : Long = {var answer: Int = 1;		if (exponent == 0) {1
    	}	else {			answer = base * exp(base, math.abs(exponent - 1));	if (exponent < 0 ) {answer = 1/answer};		answer;		}    }