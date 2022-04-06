export class Calculation {
  public _expression: string;
  public _result: string;

  constructor(expression: string, result: string) {
    this._expression = expression;
    this._result = result;
  }
}

export class InvalidCalculationError extends Error {}
