public class Token {
        private Type t;
        private Double value;
        private String operator;
        Token(Type t,Double v,String operator)
        {
            this.operator=operator;
            this.t = t;
            this.value = v;
        }
        public static Token numberToken(Type t, Double value){
            return new Token(t,value,null);
        }
        public static Token operatorToken(Type t, String operator){
            return new Token(t,null,operator);
        }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Type getT() {
        return t;
    }

    public void setT(Type t) {
        this.t = t;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if(this.value==null){
            return "Token: "+
                    "Type: "+this.t
                    +"Operator: "+this.operator;
        }
        return "Token: "+
                "Type: "+this.t
                +" Value: "+this.value;
    }
}
