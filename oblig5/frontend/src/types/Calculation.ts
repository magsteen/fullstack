export class Calculation {
  public _id: number;
  public _expression: string;
  public _result: string;

  constructor(id: number, expression: string, result: string) {
    this._id = id;
    this._expression = expression;
    this._result = result;
  }
}

export class InvalidCalculationError extends Error {}
