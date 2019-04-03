/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.polishalgorithm;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Michail
 */
public class Converting {
    private ArrayList<String> order;
    private StringBuilder prefix;
    private String computation;

    public String getRecord() {
        return prefix.toString();
    }

    public String getComputation() {
        return computation;
    }

    public void Convert(String data) {
        StringBuilder rev_data = new StringBuilder(data);
        rev_data.reverse();
        char c;
        ArrayList<String> operand = new ArrayList<>();
        for (int i = 0; i < rev_data.length(); i++) {
            c = rev_data.charAt(i);
            if (c != '(') {
                if (c == ')') {
                    rev_data.setCharAt(i, '(');
                    c = '(';
                }
            } else {
                rev_data.setCharAt(i, ')');
                c = ')';
            }
            if (c >= '0' && c <= '9') {
                if (i + 1 >= rev_data.length())
                    operand.add(String.valueOf(c));
                else {
                    for (int j = i + 1; j < rev_data.length(); j++) {
                        c = rev_data.charAt(j);
                        if (j == rev_data.length() - 1 && (c >= '0' && c <= '9')) {
                            operand.add(rev_data.substring(i, j + 1));
                            i = j;
                            break;
                        }
                        if (c == '-') {
                            if (j == rev_data.length() - 1) {
                                operand.add(rev_data.substring(i, j + 1));
                                i = j;
                                break;
                            } else {
                                c = rev_data.charAt(j + 1);
                                if (!(c >= '0' && c <= '9')) {
                                    operand.add(rev_data.substring(i, j + 1));
                                    i = j;
                                    break;
                                } else {
                                    operand.add(rev_data.substring(i, j));
                                    i = j - 1;
                                    break;
                                }
                            }
                        }
                        if (!(c >= '0' && c <= '9')) {
                            operand.add(rev_data.substring(i, j));
                            i = j - 1;
                            break;
                        }
                    }
                }
            } else
                operand.add(String.valueOf(c));
        }

        convert(operand);
    }

    private void convert(ArrayList<String> operand) {
        Stack symbol = new Stack();
        order = new ArrayList<>();
        prefix = new StringBuilder();
        for (String index : operand) {
            if (checkString(index)) {
                prefix.append(index);
                order.add(recursiveReverse(index));
            } else {
                int weight = Weight(index);
                if (weight > 0) {
                    if (symbol.isEmpty())
                        symbol.push(index);
                    else if (Weight(symbol.peek().toString()) == 0)
                        symbol.push(index);
                    else if (Weight(symbol.peek().toString()) <= weight)
                        symbol.push(index);
                    else {
                        while (Weight(symbol.peek().toString()) > weight) {
                            order.add(symbol.peek().toString());
                            prefix.append(symbol.pop());
                            if (symbol.isEmpty())
                                break;
                            weight = (Weight(symbol.peek().toString()));
                        }
                        symbol.push(index);
                    }
                } else
                    symbol.push(index);

                if (")".equals(index)) {
                    symbol.pop();
                    while (!symbol.isEmpty()) {
                        if ("(".equals(symbol.peek().toString())) {
                            symbol.pop();
                            break;
                        } else {
                            order.add(recursiveReverse(symbol.peek().toString()));
                            prefix.append(symbol.pop());
                        }
                    }
                }

            }
        }
        while (!symbol.isEmpty()) {
            String val = symbol.pop().toString();
            if (")".equals(val) || "(".equals(val))
                continue;
            prefix.append(val);
            order.add(recursiveReverse(val));

        }
        prefix.reverse();
    }

    public void calculate() {
        Stack operand = new Stack();

        for (String index : order) {
            if (checkString(index))
                operand.add(index);
            else
                operand.add(operation(index, Double.valueOf(operand.pop().toString()), Double.valueOf(operand.pop().toString())));
        }
        computation = (String.valueOf(Math.round(Double.valueOf(operand.pop().toString()))));
    }

    private double operation(String symbol, double val1, double val2) {
        switch (symbol) {
            case "+":
                return (val1 + val2);
            case "-":
                return (val1 - val2);
            case "*":
                return (val1 * val2);
            case "/":
                if (val2 == 0) return 0;
                else return (val1 / val2);
            default:
                return 0;
        }
    }

    private String recursiveReverse(String s) {
        if ((null == s) || (s.length() <= 1)) {
            return s;
        }
        return recursiveReverse(s.substring(1)) + s.charAt(0);
    }

    private int Weight(String sign) {
        switch (sign) {
            case "*":
            case "/":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                return 0;
        }
    }

    protected boolean checkString(String string) {
        if (string == null) return false;
        return string.matches("^-?\\d+$");
    }
}
