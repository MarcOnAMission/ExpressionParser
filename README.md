# Arithmetic Expression Parser (Java)

This project is a simple arithmetic expression parser and evaluator written in Java. It supports the operators +, -, *, and /, correctly applying operator precedence (* and / before + and -).

The program runs in three stages:

1. Tokenization  
   The Tokenizer converts the input string into a list of tokens. It identifies multi-digit numbers and the operators + - * /.  
   Example: "20+5*7" → [20, +, 5, *, 7]

2. Parsing (AST Construction)  
   The Parser uses a stack-based method similar to the Shunting-Yard algorithm to build an Abstract Syntax Tree (AST).  
   - Number tokens become leaf nodes.  
   - Operators create parent nodes with left/right children.  
   - Precedence rules ensure the correct tree shape.  
   Example: 3 + 4 * 2 → (3 + (4 * 2))

3. Evaluation  
   EvaluateRoot() recursively evaluates the AST. Leaf nodes return numeric values. Operator nodes compute left op right. Division by zero throws an exception.

How to run:  
Set your operation string in Main:
String operation = "20+5*7/2+3+15";

The program prints the tree and the final computed value.

Files included:
- Tokenizer.java — converts text to tokens  
- Parser.java — builds the tree and evaluates it  
- TreeNode.java — AST node structure  
- Token.java — token representation  
- Type.java — token types  
- Main.java — entry point

This project demonstrates tokenizing input, building an AST using operator precedence, and evaluating expressions recursively.
