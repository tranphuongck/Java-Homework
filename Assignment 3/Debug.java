enum Operator {
  ADD, SUBTRACT, MULTIPLY, DIVIDE
}

class Expression {
  double left_, right_;
  Operator op_;

  Expression(double left, double right, Operator op){
    this.left_  = left;
    this.right_ = right;
    this.op_    = op;
  }

  double evaluate() {
    switch (this.op_) {
      case ADD:
        return this.left_ + this.right_;
      case SUBTRACT:
        return this.left_ - this.right_;
      case MULTIPLY:
        return this.left_ * this.right_;
      case DIVIDE: //Switch case lacks default case
        return this.left_ / this.right_;
      default:
        return this.left_;
    }
  }
}

class Debug {

  public static void main(String[] args) {
    Operator[] ops = new Operator[4]; //array length of 5 has unused null index
    //lacks enum name
    ops[0] = Operator.ADD;
    ops[1] = Operator.SUBTRACT;
    ops[2] = Operator.MULTIPLY;
    ops[3] = Operator.DIVIDE;

    Expression[] exp = new Expression[ops.length];
    for (int i = 0; i < ops.length; ++i) {
      exp[i] = new Expression(2, 3, ops[i]);
    }

    for (int i = 0; i < ops.length; ++i) {
      System.out.println(exp[i].evaluate());
    }
  }
}
/*
Debug.java:26: error: missing return statement
  }
  ^
Debug.java:33: error: cannot find symbol
    ops[0] = ADD;
             ^
  symbol:   variable ADD
  location: class Debug
Debug.java:34: error: cannot find symbol
    ops[1] = SUBTRACT;
             ^
  symbol:   variable SUBTRACT
  location: class Debug
Debug.java:35: error: cannot find symbol
    ops[2] = MULTIPLY;
             ^
  symbol:   variable MULTIPLY
  location: class Debug
Debug.java:36: error: cannot find symbol
    ops[3] = DIVIDE;
             ^
  symbol:   variable DIVIDE
  location: class Debug
5 errors
*/