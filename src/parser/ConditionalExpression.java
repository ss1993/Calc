package parser;

import state.State;

/**
 * Created by sebastian on 29/02/16.
 */
public class ConditionalExpression extends Expression {

    private Expression condition;
    private Expression whenTrueExpression;
    private Expression whenFalseExpression;


    public ConditionalExpression(Expression condition, Expression whenTrueExpression, Expression whenFalseExpression) {
        this.condition = condition;
        this.whenTrueExpression = whenTrueExpression;
        this.whenFalseExpression = whenFalseExpression;
    }

    @Override
    public String toString() {
        return "IFExpression( " + condition + " ; " + whenTrueExpression + " ; " + whenFalseExpression + " )";
    }

    @Override
    public int eval(State<Integer> variableState, State<Function> functionState) {
        return condition.eval(variableState, functionState) != 0 ? whenTrueExpression.eval(variableState, functionState) : whenFalseExpression.eval(variableState, functionState);
    }
}
