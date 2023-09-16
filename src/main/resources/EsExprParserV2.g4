grammar EsExprParserV2;
sql : expr order_clause?;

expr:
    expr RELATION expr         #Root1
    |
    '(' expr ')'              #Root2
    |
    ORDER_TOKEN  #Root4
    |
    column_name OPR value      #Root3
    ;

order_clause:
    ORDER_TOKEN var_order_manner+;
var_order_manner:
    column_name SORT_MANNER;

value: (STRING|column_name_full)('||'(STRING|column_name_full))*;

column_name_full: '${'VARIABLE'}';
column_name: '${'VARIABLE'}';

ORDER_TOKEN:'ORDER BY';
SORT_MANNER:('DESC'|'ASC');
RELATION:('AND'|'OR');
OPR:('='|'<>'|'>='|'<='|'<'|'>'|'IN'|'IKLIKE');
VARIABLE: (CHAR+|'_')(CHAR|INT|'_')+;

CHAR:[a-zA-Z]+;
INT:[0-9]+;

STRING:'\'' .*? '\'';
WS : [ \t\r\n]+ -> skip;