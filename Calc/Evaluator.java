public class Evaluator{
    private ExpressionTokenizer tokenizer;

    public Evaluator(String expression){
        tokenizer = new ExpressionTokenizer(expression);
    }

    public int getTermValue(){
        int value = getFactorValue();
        boolean done = false;
        while (!done){
            String next = tokenizer.peekToken();
            if ("*".equals(next) || "+".equals(next)){
                tokenizer.nextToken();
                int value2 = getFactorValue();
                if ("*".equals(next)){
                    value *= value2;
                }
                else{
                    value += value2;
                }
            }
            else{
                done = true;
            }
        }
        return value;
    }

    public int getFactorValue(){
        int value;
        String next = tokenizer.peekToken();
        if ("(".equals(next)){
            tokenizer.nextToken();
            value = getTermValue();
            tokenizer.nextToken();
        }
        else{
            value = Integer.parseInt(tokenizer.nextToken());
        }
        return value;
    }
}